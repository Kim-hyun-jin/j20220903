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
			if(!dh.isEmpty()) {
				int i = 0;
				do {
					ArrayList<DiaDrugInf> dd = ddd.diaDrugList(dh.get(i).getPatient_no(), dh.get(i).getChart_no());
					rsdd.add(dd);
					i++;
				} while (dh.size()>i);
			}
			if(pi.getSocial_number().length()==13) {
				StringBuffer sb = new StringBuffer(pi.getSocial_number());
				sb.delete(7,13);
				sb.insert(6,"-");
				pi.setSocial_number(sb.toString().concat("******"));
				if(pi.getContact()!=null) {
					if(pi.getContact().length()==11) {
						sb.delete(0, sb.length());
						sb.append(pi.getContact());
						sb.insert(7, "-");
						sb.insert(3, "-");
						pi.setContact(sb.toString());
					}
				}
				if(pi.getProtector_contact()!=null) {
					if(pi.getProtector_contact().length()==11) {
						sb.delete(0, sb.length());
						sb.append(pi.getProtector_contact());
						sb.insert(7, "-");
						sb.insert(3, "-");
						pi.setProtector_contact(sb.toString());
					}
				}
			}
//			System.out.println("pi 유효성 검사: pi.getPatient_name() ==> "+pi.getPatient_name());
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
			ArrayList<String> dep = new ArrayList<String>();
			dep.add(list_doc.get(0).getDepartment());
			for(int i1=1; i1<list_doc.size(); i1++) {
				if(!dep.contains(list_doc.get(i1).getDepartment())) {
					dep.add(list_doc.get(i1).getDepartment());
				}
			}
//			System.out.println("list_res_date.size() == >"+list_res_date.size());
			
			request.setAttribute("dep", dep);
			request.setAttribute("list_doc", list_doc);
			request.setAttribute("list_res_date", list_res_date);
		} catch (Exception e) {
			System.out.println("PatientSearchSelect e.getMessage ==> "+e.getMessage());
		}
		return "patientSearch/patientInf.jsp";
	}

}
