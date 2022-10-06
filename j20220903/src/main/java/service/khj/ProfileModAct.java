package service.khj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Doctor;
import dao.DoctorDao;
import oracle.net.aso.e;
import service.CommandProcess;

public class ProfileModAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor)session.getAttribute("doctor_s");
		String doctor_no = doctor.getDoctor_no();
		
		DoctorDao doctorDao = DoctorDao.getInstance();
		int result = doctorDao.updateProfile(doctor);
		if(result == 1) {
			System.out.println("ProfileModAct 수정성공");
		} else{
			System.out.println("ProfileModAct 수정실패");
			response.sendRedirect("profile/profile.jsp");
		}
		request.setAttribute("doctor", doctor);
		request.setAttribute("doctor_no", doctor_no);
		request.setAttribute("result", result);
		*/
		return "profile/profile.jsp";
	}

}
