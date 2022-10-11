package service.khj;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Doctor;
import dao.DoctorDao;
import service.CommandProcess;

public class ProfileModView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("ProfileModView start...");
		request.setCharacterEncoding("utf-8");
		
		String doctor_no = request.getParameter("doctor_no");
		String doctor_name = request.getParameter("doctor_name");
		String department = request.getParameter("department");
		int password = Integer.parseInt(request.getParameter("password"));
		String img_path = request.getParameter("img_path");
		
		System.out.println("ProfileModView img_path: "+ img_path);
		request.setAttribute("doctor_no", doctor_no);
		request.setAttribute("doctor_name", doctor_name);
		request.setAttribute("department", department);
		request.setAttribute("password", password);
		request.setAttribute("img_path", img_path);
		 
		return "profile/profileMod.jsp";
	}

}
