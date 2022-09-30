package service.sh;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Doctor;
import dao.DoctorDao;
import service.CommandProcess;

public class LoginPro implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginPro Start...");
		
		try {
			String doctor_no = request.getParameter("doctor_no");
			int password = Integer.parseInt(request.getParameter("password"));
			
			DoctorDao dd = DoctorDao.getInstance();
			int result = dd.check(doctor_no, password);
			System.out.println(result);
			Doctor doctor = dd.select(doctor_no);
			
			request.setAttribute("result", result);
			request.setAttribute("doctor", doctor);
		} catch (Exception e) {
			System.out.println("LoginPro Error ->" + e.getMessage());
		}
		
		return "login/loginPro.jsp";

	}

}
