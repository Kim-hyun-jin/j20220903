package service.lhj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

public class MainCalendarRegView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MainCalendarRegView Start...");
		
		try {
			int schedule_no = 0;
			if(request.getParameter("schedule_no") != null) {
				schedule_no = Integer.parseInt(request.getParameter("schedule_no"));
//				ScheduleDao sd = ScheduleDao.getInstance();
//				Schedule schedule = sd.select(schedule_no);
		}  
			request.setAttribute("schedule_no", schedule_no);

		} catch (Exception e) {
			System.out.println("MainCalendarRegView e.getMessage() --> "+e.getMessage());
	
		}
	
		return "main/scheduleRegView.jsp";
	}

}
