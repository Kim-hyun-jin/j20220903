package service.ej;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Reservation2;
import dao.ReservationDao;
import service.CommandProcess;

public class ReservationRegAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			System.out.println("ReservationRegAct START...");
			String reservation_date = request.getParameter("reservation_date");
			String reservation_hour = request.getParameter("reservation_hour");
			String doctor_no = request.getParameter("doctor_no");
			int patient_no = Integer.parseInt(request.getParameter("patient_no"));
			
			if (reservation_date == null || reservation_date == "") {
				reservation_date = "";
			}
			
			if (reservation_date != null && reservation_date != "") {
				reservation_date = reservation_date.replaceAll("-", "/"); 
				reservation_date = reservation_date.substring(reservation_date.length()-8, reservation_date.length());
			}
			
			Reservation2 reservation22 = new Reservation2();
			reservation22.setReservation_date(reservation_date);
			System.out.println("1");
			
			reservation22.setReservation_hour(reservation_hour);
			reservation22.setDoctor_no(doctor_no);
			reservation22.setPatient_no(patient_no);
			System.out.println("2");
			
			ReservationDao rd = ReservationDao.getInstance();
			int result = rd.insert(reservation22);
			request.setAttribute("reservation_date", reservation_date);
			request.setAttribute("reservation_hour", reservation_hour);
			request.setAttribute("doctor_no", doctor_no);
			request.setAttribute("patient_no", patient_no);
			request.setAttribute("result", result);
			System.out.println("result->"+result);
		} catch (Exception e) {
			System.out.println("getMessage->"+e.getMessage());
		}
		
		return "reservation/reservationRegAct.jsp";
	}

}
