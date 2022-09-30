package service.jw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PatientDao;
import dao.PatientInformation;
import service.CommandProcess;

public class PatientSearchSelect implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("PatientSearchSelect start...");
		int patient_no = Integer.parseInt(request.getParameter("patient_no"));
		System.out.println("patient_no ==>"+patient_no);
		try {
			PatientDao pd = PatientDao.getInstance();
			PatientInformation pi = pd.patientInformation(patient_no); 
			
			System.out.println("pi 유효성 검사: pi.getPatient_name() ==> "+pi.getReservation_date().get(1));
			request.setAttribute("pi", pi);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "patientSearch/patientInf.jsp";
	}

}
