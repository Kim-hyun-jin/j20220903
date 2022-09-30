package service.ej;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Reservation;
import dao.ReservationDao;
import service.CommandProcess;

public class Reservation1 implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Reservation Service start...");
		
		ReservationDao rd = ReservationDao.getInstance();
		try {
			int totCnt = rd.getTotalCnt();
			String pageNum = request.getParameter("pageNum");
			if (pageNum==null||pageNum.equals("")) {pageNum="1";}
			int currentPage = Integer.parseInt(pageNum);
			int pageSize = 10, blockSize=10;
			int startRow = (currentPage -1) * pageSize +1;
			int endRow = startRow + pageSize -1;
			int startNum = totCnt - startRow + 1;
			
			List<Reservation> list = rd.reservationList(startRow, endRow);
			int pageCnt = (int)Math.ceil((double)totCnt/pageSize);
			int startPage = (int)(currentPage-1)/blockSize*blockSize+1;
			int endPage = startPage + blockSize -1;
			if (endPage > pageCnt) endPage = pageCnt;
			System.out.println(list.size());
			System.out.println(totCnt);
			request.setAttribute("list", list);
			request.setAttribute("totCnt", totCnt);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startNum", startNum);
			request.setAttribute("blockSize", blockSize);
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
		} catch (Exception e) {
			System.out.println("Reservation Service e.getMessage() -->" +e.getMessage());
		}
		return "reservationList.jsp";

	}
}
