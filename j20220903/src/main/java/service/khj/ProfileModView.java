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

		/* 오류남 세션처리
		 * HttpSession session = request.getSession(); Doctor doctor = (Doctor)
		 * session.getAttribute("doctor_s"); String doctor_no = doctor.getDoctor_no();
		 * 
		 * request.setAttribute("doctor_no", doctor_no);
		 * request.setAttribute("doctor",doctor);
		 */
		 
		return "profile/profileMod.jsp";
	}

}
