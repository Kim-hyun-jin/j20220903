package service.sh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			String auto = request.getParameter("auto_log");
			
			System.out.println("LoginPro auto -> " + auto);
			
			DoctorDao dd = DoctorDao.getInstance();
			int result = dd.check(doctor_no, password);
			
			Doctor doctor = dd.select(doctor_no);
			
			if (result == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("doctor_s", doctor);
				
				if (auto != null) {
					System.out.println("hi");
					// 자동로그인 체크시 시간 설정 1년!
					session.setMaxInactiveInterval(60 * 60 * 24 * 365);
				}
			}
			System.out.println("LoginPro doctor_image => " + doctor.getImage());
			request.setAttribute("result", result);
		} catch (Exception e) {
			System.out.println("LoginPro Error ->" + e.getMessage());
		}
		
		return "login/loginPro.jsp";

	}

}
