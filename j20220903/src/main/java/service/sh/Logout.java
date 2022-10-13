package service.sh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CommandProcess;

public class Logout implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Logout Start...");
		
		try {
			HttpSession session = request.getSession();
			session.invalidate();
		} catch (Exception e) {
			System.out.println("LoginPro Error ->" + e.getMessage());
		}
		
		return "login/loginForm.jsp";
	}

}
