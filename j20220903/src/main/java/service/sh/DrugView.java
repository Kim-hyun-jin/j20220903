package service.sh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CommandProcess;

public class DrugView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DrugView 실행중...");
		
		
		HttpSession session = request.getSession();
		if (session.getAttribute("doctor_s") == null) { return "login/loginForm.jsp"; }
		
		return "drug/drug.jsp";
	}

}