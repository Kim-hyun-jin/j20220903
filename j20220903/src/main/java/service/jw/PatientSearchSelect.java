package service.jw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DiaDrugDao;
import dao.DiaDrugInf;
import dao.DiaHistoryDao;
import dao.DiaHistoryInf;
import dao.Doctor;
import dao.DoctorDao;
import dao.PatientDao;
import dao.PatientInf;
import dao.Reservation;
import dao.ReservationDao;
import service.CommandProcess;

public class PatientSearchSelect implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("PatientSearchSelect start...");
		int patient_no = Integer.parseInt(request.getParameter("patient_no"));
//		System.out.println("patient_no ==>"+patient_no);
		try {
			PatientDao pd = PatientDao.getInstance();
			DiaHistoryDao dhd = DiaHistoryDao.getInstance();
			DiaDrugDao ddd = DiaDrugDao.getInstance();
			
			PatientInf pi = pd.patientInf(patient_no);
			ArrayList<DiaHistoryInf> dh = dhd.diaHistoryList(patient_no);
			ArrayList<ArrayList<DiaDrugInf>> rsdd = new ArrayList<ArrayList<DiaDrugInf>>();
			int i = 0;
			if(!dh.isEmpty()) {
				do {
					ArrayList<DiaDrugInf> dd = ddd.diaDrugList(dh.get(i).getPatient_no(), dh.get(i).getChart_no());
					rsdd.add(dd);
					i++;
				} while (dh.size()>i);
			}
			System.out.println("pi 유효성 검사: pi.getPatient_name() ==> "+pi.getPatient_name());
			request.setAttribute("pi", pi);
			request.setAttribute("dh", dh);
			request.setAttribute("rsdd", rsdd);

			
//			==== 검색기준데이터 저장용
			DoctorDao dd = DoctorDao.getInstance();
			ReservationDao rd = ReservationDao.getInstance();
			List<Doctor> list_doc = dd.doctorList("");
			List<Reservation> list_res = rd.reserList("");
			
			List<String> list_res_date = new ArrayList<String>();
			list_res_date.add(list_res.get(0).getReservation_date()); 
			for(int i1=1; i1<list_res.size(); i1++) {
				if(!list_res.get(i1).getReservation_date().equals(list_res.get(i1-1).getReservation_date())) {
					list_res_date.add(list_res.get(i1).getReservation_date());
				}
			}
//			System.out.println("list_res_date.size() == >"+list_res_date.size());
			
			request.setAttribute("list_doc", list_doc);
			request.setAttribute("list_res_date", list_res_date);
		} catch (Exception e) {
			System.out.println("PatientSearchSelect e.getMessage ==> "+e.getMessage());
		}
		return "patientSearch/patientInf.jsp";
	}

}
