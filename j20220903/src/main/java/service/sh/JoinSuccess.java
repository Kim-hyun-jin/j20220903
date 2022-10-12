package service.sh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

public class JoinSuccess implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("JoinSuccess Start...");
		
		try {
			String doctor_no = request.getParameter("doctor_no");
			
			request.setAttribute("doctor_no", doctor_no);
		} catch (Exception e) {
			System.out.println("JoinSuccess Error -> " + e.getMessage());
		}
		
		return "login/joinSuccess.jsp";
	}

}
