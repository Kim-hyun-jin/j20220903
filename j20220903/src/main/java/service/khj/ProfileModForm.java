package service.khj;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Doctor;
import dao.DoctorDao;
import service.CommandProcess;

public class ProfileModForm implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
/*		Doctor doctor = new Doctor();
		DoctorDao doctorDao = DoctorDao.getInstance();
		try {
			doctor = doctorDao.select(doctor.getDoctor_no());
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("MyProfileModForm.java "+ e.getMessage());
		}
		
		request.setAttribute("doctor", doctor);
		request.getRequestDispatcher("profileMod.jsp")
				.forward(request, response);
*/
		return "profileMod.jsp";
	}

}
