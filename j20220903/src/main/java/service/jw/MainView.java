package service.jw;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Schedule;
import dao.ScheduleDao;
import dao.Doctor;
import dao.PatientDao;
import dao.PatientInf;
import service.CommandProcess;

public class MainView implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MainView 실행중...");	

		//String doctor_no = "2";
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor) session.getAttribute("doctor_s");
		String doctor_no = doctor.getDoctor_no();
		PatientDao patientDao =PatientDao.getInstance();
		List<PatientInf> list = patientDao.getMyPatientList(doctor_no);
		
		request.setAttribute("myPatientList", list);
		
		return "index.jsp";
	}

}
