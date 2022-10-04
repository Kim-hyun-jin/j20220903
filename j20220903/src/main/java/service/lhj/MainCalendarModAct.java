package service.lhj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Schedule;
import dao.ScheduleDao;
import service.CommandProcess;

public class MainCalendarModAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 1. num , pageNum, writer ,  email , subject , passwd , content   Get
			// 2. Board board 생성하고 Value Setting
	        request.setCharacterEncoding("utf-8"); 
	        Schedule schedule = new Schedule();
	        schedule.setSchedule_title(request.getParameter("Schedule_title"));
	        schedule.setSchedule_startdate(request.getParameter("Schedule_startdate"));
	        schedule.setSchedule_enddate(request.getParameter("Schedule_enddate"));
	        schedule.setSchedule_content(request.getParameter("setSchedule_content"));
	  
			
			// 3. BoardDao bd Instance
	        ScheduleDao sd= ScheduleDao.getInstance();//DB 
	        //String result = sd.insert(schedule);   
	        // 4. request 객체에 result, num , pageNum 	        
	       request.setAttribute(null, response);
		
		} catch (Exception e) {
			System.out.println(e.getMessage()); 
		}

        return "schedule.jsp";
	
	}

}
