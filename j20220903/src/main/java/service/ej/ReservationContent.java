package service.ej;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Reservation;
import dao.ReservationDao;
import service.CommandProcess;

public class ReservationContent implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ReservationContent Service Start...");
			int patient_no = Integer.parseInt(request.getParameter("patient_no"));
			String pageNum = request.getParameter("pageNum");
			try {
				ReservationDao rd = ReservationDao.getInstance();
				/* Reservation reservation = rd.select(patient_no); */
				
				request.setAttribute("patient_no", patient_no);
				request.setAttribute("pageNum", pageNum);
				/* request.setAttribute("reservation", reservation); */
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return "content.jsp";
	}

}
