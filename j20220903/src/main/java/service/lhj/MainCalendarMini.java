package service.lhj;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Schedule;
import dao.ScheduleDao;
import service.CommandProcess;


public class MainCalendarMini implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MainCalendarMini Service start...");
		
		ScheduleDao sd = ScheduleDao.getInstance();
		
		try {
			String doctor_no= request.getParameter("doctor_no");
			List<Schedule> list = sd.list(doctor_no);
			List<Schedule> reservationList = sd.getReservationlist(doctor_no);
			List<Schedule> todoList = sd.getTodoList(doctor_no); 
			
			request.setAttribute("list", list);
			request.setAttribute("reservationList", reservationList); 
			request.setAttribute("todoList", todoList);
			
		    
		} catch (Exception e) {
			System.out.println("MainCalendarMini e.getMessage()-->"+e.getMessage());
		}
			
		return "main/mainCalendar.jsp";
	}

}
