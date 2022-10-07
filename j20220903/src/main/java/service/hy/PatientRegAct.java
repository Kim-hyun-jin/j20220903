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

		request.setCharacterEncoding("utf-8");

		try {
			Patient patient = new Patient();
			patient.setPatient_name(request.getParameter("patient_name"));
			patient.setGender(request.getParameter("gender"));
			patient.setBirth(request.getParameter("birth"));
			patient.setAddress(request.getParameter("address"));
			patient.setContact(request.getParameter("contact"));
			patient.setProtector_contact(request.getParameter("protector_contact"));
			patient.setSocial_number(request.getParameter("social_number"));

			PatientDao pd = PatientDao.getInstance();
			int result = pd.regPatient(patient);
			
			request.setAttribute("result", result);

		} catch (Exception e) {
			System.out.println("PatientRegAct.java" + e.getMessage());
			
		}
		return "patientManage/patientManageAction.jsp";
	}
}