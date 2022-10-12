package service.dj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ShareBoardDao;
import service.CommandProcess;

public class ShareBoardDelAct implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String shareBoard_no1 = request.getParameter("shareBoard_no");
			// 1. num , passwd , pageNum Get
			int shareBoard_no = Integer.parseInt(shareBoard_no1);
			String pageNum = request.getParameter("pageNum");
			// 2. BoardDao bd Instance
			ShareBoardDao bd = ShareBoardDao.getInstance();
			// 3. 본인의 게시판 만 삭제 
			int result = bd.delete(shareBoard_no);
			// 4. request 객체에  num , pageNum ,result
			request.setAttribute("result", result);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("shareBoard_no", shareBoard_no);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return  "shareBoard/shareBoardDelPro.jsp";
	}

}