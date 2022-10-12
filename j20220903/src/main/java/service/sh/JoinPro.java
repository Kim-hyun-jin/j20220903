package service.sh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Doctor;
import dao.DoctorDao;
import service.CommandProcess;

public class JoinPro implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("JoinPro start....");
		
		try {
			int password = Integer.parseInt(request.getParameter("password"));
			String doctor_name = request.getParameter("doctor_name");
			String department = request.getParameter("department");
			
			Doctor doctor = new Doctor();
			DoctorDao dd = DoctorDao.getInstance();
			doctor.setDoctor_name(doctor_name);
			doctor.setDepartment(department);
			doctor.setPassword(password);
			
			int result = dd.insert(doctor);
			String doctor_no = dd.join();
			System.out.println("doctor_no => " + doctor_no);
			
			request.setAttribute("result", result);
			request.setAttribute("doctor_no", doctor_no);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "login/joinPro.jsp";
	}

}
