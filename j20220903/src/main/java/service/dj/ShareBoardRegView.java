package service.dj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

public class ShareBoardRegView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("WriteFormAction Start...");

		try {
			// 신규글
			String pageNum = request.getParameter("pageNum");
			String doctor_no = request.getParameter("doctor_no");

			// doctor_no 의사이름을 가져오기
			if (pageNum == null)
				pageNum = "1";

			
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("doctor_no", doctor_no);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "shareBoard/shareBoardRegForm.jsp";
	}

}
