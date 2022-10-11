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

public class ProfileView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ProfileView 실행중...");
		
		DoctorDao doctorDao = DoctorDao.getInstance();
		HttpSession session = request.getSession();
		
		Doctor doctor = (Doctor) session.getAttribute("doctor_s");
		String img_path = doctor.getImage();
		System.out.println("img_path:" + img_path);
		request.setAttribute("img_path", img_path);
		return "profile/profile.jsp";
	}

}
