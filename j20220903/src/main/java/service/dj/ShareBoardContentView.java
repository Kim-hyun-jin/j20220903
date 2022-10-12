package service.dj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Doctor;
import dao.ShareBoard;
import dao.ShareBoardDao;
import service.CommandProcess;

public class ShareBoardContentView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ShareBoardContentView Service start...");
		// 1. shareboard_no , pageNum
		int shareboard_no = Integer.parseInt(request.getParameter("shareboard_no"));
		String pageNum = request.getParameter("pageNum");
//		String doctor_no = request.getParameter("doctor_no");
//		String doctor_name = request.getParameter("doctor_name");
		System.out.println("ShareBoardContentView Service shareboard_no->"+shareboard_no);
		
		try {
			// 2. shareBoardDao bd Instance
			ShareBoardDao bd = ShareBoardDao.getInstance();

			// 4. shareBoard board = bd.select(num);
			ShareBoard shareBoard = bd.select(shareboard_no);   

			// 세션가져오기
			HttpSession session = request.getSession();
			Doctor doctor = (Doctor)session.getAttribute("doctor_s");
			
			// 5. request 객체에 num , pageNum , board
			// request.setAttribute("doctor_name", shareBoard.getDoctor_name());
			request.setAttribute("shareboard_no", shareboard_no);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("shareBoard", shareBoard);
			request.setAttribute("doctor", doctor);
			
		} catch (Exception e) {
			System.out.println(e.getMessage()); 
		}

		//       View
		return "shareBoard/shareBoardContent.jsp";
	      
	   }
}