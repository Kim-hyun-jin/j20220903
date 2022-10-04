package service.dj;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ShareBoard;
import dao.ShareBoardDao;
import service.CommandProcess;

public class ShareBoardModAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
        String pageNum = request.getParameter("pageNum");
		
		try {
			// 2. Board board 생성하고 Value Setting
	        ShareBoard shareboard = new ShareBoard();
	        shareboard.setShareBoard_no(Integer.parseInt(request.getParameter("shareboard_no")));
	        shareboard.setShareBoard_subject(request.getParameter("shareboard_subject"));
	        shareboard.setShareBoard_content(request.getParameter("shareboard_content"));
			// 3. BoardDao bd Instance
			ShareBoardDao bd = ShareBoardDao.getInstance();
			int result = bd.update(shareboard);
			// 4. request 객체에 result, num , pageNum 
			request.setAttribute("result", result);
			request.setAttribute("doctor_no", shareboard.getDoctor_no());
			request.setAttribute("pageNum", pageNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
        // 5.updatePro.jsp Return
        return  "shareBoard/shareBoardModPro.jsp";
	}
	}


