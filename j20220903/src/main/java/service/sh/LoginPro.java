package service.sh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DoctorDao;
import service.CommandProcess;

public class LoginPro implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginPro Start...");
		
		try {
			String doctor_no = request.getParameter("doctor_no");
			String password = request.getParameter("password");
			
			DoctorDao dd = DoctorDao.getInstance();
			int result = dd.check(doctor_no, password);
			
			request.setAttribute("doctor_no", doctor_no);
			request.setAttribute("password", password);
		} catch (Exception e) {
			System.out.println("LoginPro Error ->" + e.getMessage());
		}
		
		return "loginPro.jsp";
	}

}
