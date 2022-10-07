package service.hy;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Patient;
import dao.PatientDao;
import service.CommandProcess;

public class PatientRegAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		Patient patient = new Patient();
		patient.setPatient_no(Integer.parseInt(request.getParameter("patient_no")));
		patient.setPatient_name(request.getParameter("patient_name"));
		patient.setGender(request.getParameter("gender"));
		patient.setBirth(request.getParameter("birth"));
		patient.setAddress(request.getParameter("address"));
		patient.setContact(request.getParameter("contact"));
		patient.setProtector_contact(request.getParameter("protector_contact"));
		patient.setSocial_number(request.getParameter("social_number"));
		
		
		PatientDao patientDao = PatientDao.getInstance();
		
		int result = patientDao.regPatient(patient);
		
		if(result > 0 ) {
		//doctor_no 2로 임시처리 getAttribute from request
		//session.get?
			System.out.println("환자등록 완료");
			request.setAttribute("result", result);
			return "patientManage/patientManage.jsp";
			
		} else{
			
			return "error.jsp";
		}
	}

}
