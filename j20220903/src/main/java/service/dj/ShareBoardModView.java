package service.dj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShareBoard;
import dao.ShareBoardDao;
import service.CommandProcess;

public class ShareBoardModView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		
			String pageNum = request.getParameter("pageNum");
			int shareboard_no = Integer.parseInt(request.getParameter("shareboard_no"));

			ShareBoardDao bd = ShareBoardDao.getInstance();//DB랑 연결
			ShareBoard shareBoard = bd.select(shareboard_no);//
		
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("shareBoard",shareBoard);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "shareBoard/shareBoardModForm.jsp";
		}
	}


