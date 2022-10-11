package service.khj;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PatientDao;
import dao.PatientInf;
import service.CommandProcess;

public class MyPatientListView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		 * HttpSession session = request.getSession(); Doctor doctor = new Doctor();
		 * doctor = (Doctor) session.getAttribute("doctor_s"); String doctor_no =
		 * doctor.getDoctor_no();
		 */
		String doctor_no = "2";
		try {
			PatientDao patientDao =PatientDao.getInstance();
			List<PatientInf> list = patientDao.getMyPatientList(doctor_no);
			
			request.setAttribute("myPatientList", list);
		} catch (Exception e) {
			System.out.println("MyPatientListView e.getMessage ==> "+e.getMessage());
		}
		return "patientManage/myPatientList.jsp";
	}
}
