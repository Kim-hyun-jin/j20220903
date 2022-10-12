package service.lhj;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Schedule;
import dao.ScheduleDao;
import service.CommandProcess;

public class MainCalendarModView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MainCalendarModView start...");
		
		int schedule_no = Integer.parseInt(request.getParameter("schedule_no"));
	
		try {
			ScheduleDao sd = ScheduleDao.getInstance();
			Schedule schedule = sd.select(schedule_no);
			request.setAttribute("schedule", schedule);
			
		} catch (SQLException e) {
			
			System.out.println("MainCalendarModView e.getMessage()"+e.getMessage()); 
		}
		
		
		
		return "main/scheduleMod.jsp";
	}

}
