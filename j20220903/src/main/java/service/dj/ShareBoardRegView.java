package service.dj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;
import dao.ShareBoard;
import dao.ShareBoardDao;
import service.CommandProcess;

public class ShareBoardRegView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

System.out.println("WriteFormAction Start...");
		
		
		try {
			//신규글
			int num = 0, ref = 0, re_level = 0, re_step= 0;
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null) pageNum ="1";
			//댓글일 경우
			if(request.getParameter("num") != null) {
				num = Integer.parseInt(request.getParameter("num"));
				ShareBoardDao bd = ShareBoardDao.getInstance();
				
		
				}
			
			
			request.setAttribute("num", num);
			request.setAttribute("ref", ref);
			request.setAttribute("re_level", re_level);
			request.setAttribute("re_step", re_step);
			request.setAttribute("pageNum", pageNum);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "shareBoard/shareBoardRegform.jsp";
	}

}
