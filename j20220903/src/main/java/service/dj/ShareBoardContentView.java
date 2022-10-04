package service.dj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ShareBoard;
import dao.ShareBoardDao;
import service.CommandProcess;

public class ShareBoardContentView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ContentView Service start...");
		// 1. num , pageNum
		int shareboard_no = Integer.parseInt(request.getParameter("shareboard_no"));
		String pageNum = request.getParameter("pageNum");
		
		try {
			// 2. shareBoardDao bd Instance
			ShareBoardDao bd = ShareBoardDao.getInstance();

			// 4. shareBoard board = bd.select(num);
			ShareBoard shareBoard = bd.select(shareboard_no);   

			// 5. request 객체에 num , pageNum , board
			request.setAttribute("shareboard_no", shareboard_no);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("shareBoard", shareBoard);		
		} catch (Exception e) {
			System.out.println(e.getMessage()); 
		}

		//       View
		return "shareBoard/shareBoardContent.jsp";
	      
	   }
}