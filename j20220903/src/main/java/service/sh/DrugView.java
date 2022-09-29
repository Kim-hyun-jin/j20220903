package service.sh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Doctor;
import dao.DoctorDao;
import service.CommandProcess;

public class DrugView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DrugView 실행중...");
		
		String doctor_no = request.getParameter("doctor_no");
		
		try {
			DoctorDao dd = DoctorDao.getInstance();
			
			Doctor doctor = dd.select(doctor_no);
			
			System.out.println(doctor_no);
			System.out.println(doctor.getDoctor_name());
			
			request.setAttribute("doctor", doctor);
		} catch (Exception e) {
			System.out.println("DrugView error => " + e.getMessage());
		}
		
		return "drug/drug.jsp";
	}

}
