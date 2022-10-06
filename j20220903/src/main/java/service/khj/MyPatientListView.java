package service.khj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Patient;
import dao.PatientDao;
import dao.PatientInf;
import service.CommandProcess;

public class MyPatientListView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Object doctor = session.getAttribute("doctor_s");
		String doctor_no = "2";
		PatientDao patientDao =PatientDao.getInstance();
		PatientInf patientInf = patientDao.getMyPatientList(doctor_no);
		
		request.setAttribute("myPatientList", patientInf);
		
		
		return "patientManage/myPatientList.jsp";
	}

}
