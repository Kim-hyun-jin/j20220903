package service.sh;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Doctor;
import dao.DoctorDao;
import dao.Drug;
import dao.DrugDao;
import service.CommandProcess;

public class DrugSearch implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DrugSearch Start...");
		
		try {
			String doctor_no	= request.getParameter("doctor_no");
			String drug_name	= request.getParameter("drug_name");
			String drug_class	= request.getParameter("drug_class");
			
			System.out.println(drug_class); /* 제대로 넘어 오는구만 */
			
			DoctorDao docd = DoctorDao.getInstance();
			Doctor doctor = docd.select(doctor_no);
			
			DrugDao dd = DrugDao.getInstance();
			int totCnt = dd.getCnt(drug_name, drug_class);
			
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null || pageNum.equals("")) { pageNum = "1"; }
			int currentPage = Integer.parseInt(pageNum);
			int pageSize = 10, blockSize = 10;
			int startRow = (currentPage -1) * pageSize + 1;
			int endRow = startRow + pageSize - 1;
			
			List<Drug> list = dd.drugList(drug_name, drug_class, startRow, endRow);
			int pageCnt = (int)Math.ceil((double)totCnt/pageSize);
			
			int startPage = (int)(currentPage-1)/blockSize*blockSize + 1;
			int endPage = startPage + blockSize - 1;
			// 공갈 Page
			if (endPage > pageCnt) endPage = pageCnt;
			
			request.setAttribute("totCnt", totCnt);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startRow", startRow);
			request.setAttribute("blockSize", blockSize);
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("doctor", doctor);
			request.setAttribute("list", list);
		} catch (SQLException e) {
			System.out.println("DrugSearch Error => " + e.getMessage());
		}
		
		
		return "drug/drug.jsp";
	}

}
