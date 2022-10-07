package service.hy;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Patient;
import dao.PatientDao;
import service.CommandProcess;

public class PatientManageUpdate implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("PatientManageUpdate Service start...");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String doctor_no = request.getParameter("doctor_no");
		doctor_no = "2"; //임의 지정
		
		int patient_no = Integer.parseInt(request.getParameter("patient_no"));
		
		
		try {
			Patient patient = new Patient();
			patient.setPatient_no(patient_no);
			patient.setDoctor_no(doctor_no);
			patient.setPatient_name(request.getParameter("patient_name"));
			patient.setGender(request.getParameter("gender"));
			patient.setBirth(request.getParameter("birth"));
			patient.setAddress(request.getParameter("address"));
			patient.setContact(request.getParameter("contact"));
			patient.setProtector_contact(request.getParameter("protector_contact"));
			patient.setSocial_number(request.getParameter("social_number"));

			System.out.println("PatientManageUpdate Service patient_no ->" + patient_no);
			System.out.println("patient_name ->" + request.getParameter("patient_name"));
			System.out.println("birth ->" + request.getParameter("birth"));
			System.out.println("address ->" + request.getParameter("address"));
			System.out.println("protector_contact ->" + request.getParameter("protector_contact"));
			System.out.println("social_number ->" + request.getParameter("social_number"));

			PatientDao pd = PatientDao.getInstance();
			
			int result = pd.updatePatient(patient);
		
			request.setAttribute("result", result);	
			
		} catch (Exception e) {
			System.out.println("patientManageUpdate.java" + e.getMessage());
		}
		
		//업데이트 완료 페이지
		return "patientManage/patientManageUpdate.jsp";
	}

}
