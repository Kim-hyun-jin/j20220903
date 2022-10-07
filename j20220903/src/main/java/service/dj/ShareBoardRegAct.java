package service.dj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ShareBoard;
import dao.ShareBoardDao;
import service.CommandProcess;

public class ShareBoardRegAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. num , pageNum, writer , email , subject , passwd , content Get
		request.setCharacterEncoding("utf-8");
		
		// 이전 jsp에서 넘어온 name 파라미터를 꺼내오는 것. request.getParameter
		String pageNum = request.getParameter("pageNum");
		String doctor_no = request.getParameter("doctor_no");
		String shareBoard_content = request.getParameter("shareBoard_content");
		String shareBoard_subject = request.getParameter("shareBoard_subject");
		
		// 2. Board board 생성하고 Value Setting
		ShareBoard shareboard = new ShareBoard();
		shareboard.setDoctor_no(doctor_no);
		shareboard.setShareBoard_content(shareBoard_content);
		shareboard.setShareBoard_subject(shareBoard_subject);
		
		try {
			// 3. BoardDao bd Instance
			ShareBoardDao bd = ShareBoardDao.getInstance();// DB

			int result = bd.insert(shareboard);//shareboardDao에 
			// 4. request 객체에 result, num , pageNum
			request.setAttribute("result", result);
			request.setAttribute("shareboard_no", shareboard.getShareBoard_no());
			request.setAttribute("pageNum", pageNum);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "shareBoard/shareBoardRegPro.jsp";
	}
}
