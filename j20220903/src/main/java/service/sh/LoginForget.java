package service.sh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DoctorDao;
import service.CommandProcess;

public class LoginForget implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginForget Start...");
		
		try {
			String doctor_no = request.getParameter("doctor_no");
			String doctor_name = request.getParameter("doctor_name");
			
			System.out.println("LoginForget doctor_no -> " + doctor_no);
			System.out.println("LoginForget doctor_name -> " + doctor_name);
			DoctorDao dd = DoctorDao.getInstance();
			String password = dd.search(doctor_no, doctor_name);
			System.out.println("LoginForget password -> " + password);
			
			request.setAttribute("password", password);
		} catch (Exception e) {
			System.out.println("LoginForget Error -> " + e.getMessage());
		}
		return "login/loginForgetPro.jsp";
	}

}
