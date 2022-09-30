package service.ej;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Reservation;
import dao.ReservationDao;
import service.CommandProcess;

public class ReservationDelAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ReservationDelAct service start...");
		try {
			String reservation_date = request.getParameter("reservation_date");
			String reservation_hour = request.getParameter("reservation_hour");
			String doctor_no = request.getParameter("doctor_no");
			ReservationDao rd = ReservationDao.getInstance();
			int result = rd.delete("22/09/28", "09", "7");
			request.setAttribute("result", result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "reservation/reservationDel.jsp";
	}

}
