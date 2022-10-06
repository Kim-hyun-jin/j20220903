package service.lhj;

import java.io.IOException;
import java.sql.SQLException;
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
			/* String no = request.getParameter("doctor_no"); */
			/* List<Schedule> list = sd.list(no); */
			List<Schedule> list = sd.list();
			request.setAttribute("list", list);
		    
		} catch (Exception e) {
			System.out.println("MainCalendarMini e.getMessage()-->"+e.getMessage());
		}
			
		return "mainCalendar.jsp";
	}

}
