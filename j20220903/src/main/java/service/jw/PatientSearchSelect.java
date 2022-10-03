package service.jw;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DiaDrug;
import dao.DiaDrugDao;
import dao.DiaDrugInf;
import dao.DiaHistory;
import dao.DiaHistoryDao;
import dao.DiaHistoryInf;
import dao.PatientDao;
import dao.PatientInf;
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
		} catch (Exception e) {
			System.out.println("PatientSearchSelect e.getMessage ==> "+e.getMessage());
		}
		return "patientSearch/patientInf.jsp";
	}

}
