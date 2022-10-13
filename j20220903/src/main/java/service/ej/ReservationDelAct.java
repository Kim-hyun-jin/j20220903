package service.ej;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservationDao;
import service.CommandProcess;

public class ReservationDelAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ReservationDelAct service start...");
		try {
			String reservation_date = request.getParameter("reservation_date");
			System.out.println("ReservationDelAct 1"+reservation_date);
			String reservation_hour = request.getParameter("reservation_hour");
			System.out.println("ReservationDelAct 2"+reservation_hour);
			String doctor_no = request.getParameter("doctor_no");
			System.out.println("ReservationDelAct 3"+doctor_no);
			ReservationDao rd = ReservationDao.getInstance();
			int result = rd.delete(reservation_date, reservation_hour, doctor_no);
			request.setAttribute("result", result);
			System.out.println("ReservationDelAct result->"+result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "reservation/reservationDel.jsp";
	}
}
