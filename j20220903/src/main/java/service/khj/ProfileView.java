package service.khj;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import dao.Doctor;
import dao.DoctorDao;
import service.CommandProcess;

public class ProfileView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String doctor_no = (String)session.getAttribute("doctor_no");
		//doctor_no 를 생성자 인자값으로 전달
		Doctor doctor = new Doctor();
		DoctorDao doctorDao = DoctorDao.getInstance();
		
		try {
			doctor = doctorDao.select("2");
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("MyProfileView.java "+ e.getMessage());
		}
		
		request.setAttribute("doctor", doctor);
		
		
		return "profile/profile.jsp";
	}

}
