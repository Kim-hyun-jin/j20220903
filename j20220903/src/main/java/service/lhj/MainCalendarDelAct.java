package service.lhj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScheduleDao;
import service.CommandProcess;

public class MainCalendarDelAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MainCalendarDelAct start...");
		try {
			int schedule_no = Integer.parseInt(request.getParameter("schedule_no"));
			ScheduleDao sd = ScheduleDao.getInstance();
			int result = sd.delete(schedule_no);
			request.setAttribute("result", result);
			request.setAttribute("schedule_no", schedule_no);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "main/scheduleDelAct.jsp";  
	}

}
