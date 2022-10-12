package service.lhj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Schedule;
import dao.ScheduleDao;
import service.CommandProcess;

public class MainCalendarRegAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MainCalendarRegAct start...");
		request.setCharacterEncoding("utf-8");
		
		try {
			request.setCharacterEncoding("utf-8");
			Schedule schedule = new Schedule();
			schedule.setSchedule_no(Integer.parseInt(request.getParameter("schedule_no")));
			//schedule.setDoctor_no("2");
			schedule.setDoctor_no(request.getParameter("doctor_no"));
			schedule.setSchedule_title(request.getParameter("schedule_title"));
			schedule.setSchedule_startdate(request.getParameter("schedule_startdate"));
			schedule.setSchedule_enddate(request.getParameter("schedule_enddate"));
			schedule.setSchedule_content(request.getParameter("schedule_content"));
			
			ScheduleDao sd = ScheduleDao.getInstance();
			int result = sd.insert(schedule);   
			
			request.setAttribute("schedule_no", schedule.getSchedule_no());
			request.setAttribute("result", result);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "main/scheduleRegAct.jsp";

	}

}
