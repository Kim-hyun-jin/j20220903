package service.jw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Doctor;
import dao.DoctorDao;
import dao.Patient;
import dao.PatientDao;
import dao.Reservation;
import dao.ReservationDao;
import service.CommandProcess;

public class PatientSearchAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("PatientSearchAct 작동...");

		String department = request.getParameter("department");
		String doctorName = request.getParameter("doctorName");
		String reservationDate = request.getParameter("reservationDate");
		System.out.println("hi" + reservationDate);
		System.out.println("hi" + reservationDate);
		
		if (reservationDate == null || reservationDate == "") {
			reservationDate = "";
		}
		
		if (reservationDate != null && reservationDate != "") {
			reservationDate = reservationDate.replaceAll("-", "/"); 
			reservationDate = reservationDate.substring(reservationDate.length()-8, reservationDate.length());
		}
		
		String patientName = request.getParameter("patientName");
				
		HttpSession session = request.getSession();
		Doctor doc = (Doctor)session.getAttribute("doctor_s");
		System.out.println("session 유효성검사"+doc.getDoctor_no());
		
		try {
			PatientDao pd = PatientDao.getInstance();
			DoctorDao dd = DoctorDao.getInstance();
			ReservationDao rd= ReservationDao.getInstance();
			
			List<Patient> list_pat = pd.patientSearch(department, doctorName, reservationDate, patientName);
			ArrayList<ArrayList<String>> searchSet = pd.searchSet(department, doctorName, reservationDate, patientName);
			
			List<Doctor> list_doc = dd.doctorList("");
			List<Reservation> list_res=rd.reserList("");
			
			List<String> list_res_date = new ArrayList<String>();
			list_res_date.add(list_res.get(0).getReservation_date()); 
			for(int i=1; i<list_res.size(); i++) {
				if(!list_res.get(i).getReservation_date().equals(list_res.get(i-1).getReservation_date())) {
					list_res_date.add(list_res.get(i).getReservation_date());
				}
			}
			System.out.println("list_pat size ==> "+list_pat.size());
			System.out.println("서치셋 size ==> "+searchSet.size());
			request.setAttribute("searchSet", searchSet);
			request.setAttribute("list_pat", list_pat);
			request.setAttribute("list_doc", list_doc);
			request.setAttribute("list_res", list_res);
			request.setAttribute("list_res_date", list_res_date);
		} catch (Exception e) {
			System.out.println("patientSearchAct e.getMessage"+ e.getMessage());
		}
		
		
		return "patientSearch/patientSearchAct.jsp";
	}

}
