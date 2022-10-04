package service.khj;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Doctor;
import dao.DoctorDao;
import service.CommandProcess;

public class ProfileModAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String doctor_no = request.getParameter("doctor_no");
		int result=0;
		
		try {
			
			DoctorDao doctorDao = DoctorDao.getInstance();
			result = doctorDao.updateProfileInfo("doctor_no");
			
			request.setAttribute("doctor_no", doctor_no);
			request.setAttribute("result", result);
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("ProfileView.java "+ e.getMessage());
		}
		
		return "profile/profileAct.jsp";
	}

}
