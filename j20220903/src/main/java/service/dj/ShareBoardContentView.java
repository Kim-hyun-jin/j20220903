package service.dj;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;
import dao.ShareBoard;
import dao.ShareBoardDao;
import service.CommandProcess;

public class ShareBoardContentView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ContentAction Service start...");
		// 1. num , pageNum
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		try {
			// 2. BoardDao bd Instance
			ShareBoardDao bd = ShareBoardDao.getInstance();

			// 4. Board board = bd.select(num);
			ShareBoard board = bd.select(num);   

			// 5. request 객체에 num , pageNum , board
			request.setAttribute("num", num);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("board", board);		
		} catch (Exception e) {
			System.out.println(e.getMessage()); 
		}

		//       View
		return "content.jsp";
	      
	   }
}