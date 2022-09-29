package service.jw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Doctor;
import dao.DoctorDao;
import dao.Reservation;
import dao.ReservationDao;
import service.CommandProcess;

public class PatientSearchAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("PatientSearchAct 작동...");

		String department = request.getParameter("department");
		String doctor_Name = request.getParameter("doctor_Name");
		String reservation = request.getParameter("reservation");

		DoctorDao dd= DoctorDao.getInstance();
		ReservationDao rd= ReservationDao.getInstance();
		
		List<Doctor> list_dept = new ArrayList<Doctor>();
		List<Doctor> list_doc = new ArrayList<Doctor>();
		List<Reservation> list_res = new ArrayList<Reservation>();
		
		
		request.setAttribute("list_dept", list_dept);
		request.setAttribute("list_doc", list_doc);
		request.setAttribute("list_res", list_res);
		
		return "main/3-layout.html";
	}

}
