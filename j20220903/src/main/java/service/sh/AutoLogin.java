package service.sh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CommandProcess;

public class AutoLogin implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AutoLogin Start...");
		
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("doctor_s") == null) { return "login/loginForm.jsp"; }
		} catch (Exception e) {
			System.out.println("AutoLogin Error -> " + e.getMessage());
		}
		
		return "index.jsp";
	}

}
