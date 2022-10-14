package service.ej;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservationDao;
import service.CommandProcess;

public class ReservationDel implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("ReservationDel service start...");
		
		System.out.println("체크박스확인유무->"+request.getParameter("chk"));
		 String[] reservation_date = request.getParameterValues("reservation_date"); 
		 String[] reservation_hour = request.getParameterValues("reservation_hour"); 
		 String[] doctor_no = request.getParameterValues("doctor_no");
		 String[] chk =request.getParameterValues("chk");
		 
		
//		String reservation_date = request.getParameter("value1");
//		String reservation_hour = request.getParameter("value2");
//		String doctor_no = request.getParameter("value3");
		/*
		 * Reservation rs = (Reservation)request.getAttribute("chk");
		 * System.out.println("받은값=="+rs.getDoctor_no());
		 */
		try {

			
			/*
			 * Reservation2 reservation22 = new Reservation2();
			 * reservation22.setReservation_date(reservation_date);
			 * System.out.println("ReservationDel 1->"+reservation_date);
			 * 
			 * reservation22.setReservation_hour(reservation_hour);
			 * System.out.println("ReservationDel 2->"+reservation_hour);
			 * reservation22.setDoctor_no(doctor_no);
			 * System.out.println("ReservationDel 3->"+doctor_no);
			 */
			int resultset = 0;
			ReservationDao rd = ReservationDao.getInstance();
			for(String check : chk) {
				int i = Integer.parseInt(check);
				System.out.println("선택된 번호"+i);
				if(i==-1) {
					int i2=reservation_date.length-1;
					int result = rd.delete(reservation_date[i2], reservation_hour[i2], doctor_no[i2]);
					resultset = resultset+result;
				} else {
				int result = rd.delete(reservation_date[i], reservation_hour[i], doctor_no[i]);
				resultset = resultset+result;
				}
			}
			System.out.println("요청값 : "+chk.length+"중 처리값 :"+resultset);
			System.out.println("ReservationDel 4");
			request.setAttribute("reservation_date", reservation_date);
			request.setAttribute("reservation_hour", reservation_hour);
			request.setAttribute("doctor_no", doctor_no);
			request.setAttribute("result", resultset);
			System.out.println("ReservationDel 5");
			System.out.println("ReservationDel result->"+resultset);
		} catch (Exception e) {
			System.out.println("getMessage->"+e.getMessage());
		}
		
		return "reservation/reservationDel.jsp";

		//return "reservation/reservationView.jsp";
	}

}

