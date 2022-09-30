package service.dj;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShareBoard;
import dao.ShareBoardDao;
import service.CommandProcess;

public class ShareBoardView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   ShareBoardDao bd = ShareBoardDao.getInstance();
		      
		      try {
			      int totCnt = bd.getTotalCnt(); // 4
			      // 알았다. 일단 ch16은 close project 하고 해야 정상테스트가 되고. 현재는 java는 잘 실행되었고 jsp에서 문제가 생겼어
			      //그 HTML을 안그려놔서 그런가? ㅡ그래도 저 4는 나와야되ㅡㄴ거아녀? jsp에 4는 들고왔는ㄷ; 다른거 세팅하다가 에러나니까 jsp 전체가 에러난거야;;음,
			      // 4 세팅하고 shareboard_no 세팅하려다가 없어서 에러난듯 기둘
			      String pageNum = request.getParameter("pageNum");
			      if(pageNum==null || pageNum.equals("")){ pageNum = "1"; }
			      int currentPage = Integer.parseInt(pageNum); // 1  2
			      int pageSize = 10, blockSize = 10;
			      int startRow = (currentPage -1) * pageSize + 1;// 1   11
			      int endRow = startRow + pageSize -1; // 10   20
			      int startNum = totCnt - startRow +1;
			      
			     //ShareBoard 조회                      1            10
			      List<ShareBoard> list= bd.shareBoardList(startRow, endRow);
			      //  정수를 뽑음 올림으로 ceil사용          37     / 10
			      int pageCnt = (int)Math.ceil((double)totCnt/pageSize);
			      //                    2-1               /10   *10 +1
			      int startPage = (int)(currentPage-1)/blockSize*blockSize + 1;
			      int endPage = startPage + blockSize -1;
			      //공갈 Page 방지 
			      if(endPage > pageCnt) endPage = pageCnt;
			      
			      request.setAttribute("list", list);//제일중요
			      request.setAttribute("totCnt", totCnt);
			      request.setAttribute("pageNum", pageNum);
			      request.setAttribute("currentPage", currentPage);
			      request.setAttribute("startNum", startNum);
			      request.setAttribute("blockSize",blockSize);
			      request.setAttribute("pageCnt", pageCnt);
			      request.setAttribute("startPage", startPage);
			      request.setAttribute("endPage", endPage);
	
		      }catch (Exception e) {
		    	  System.out.println("shareBoardView e.getMessage()->" + e.getMessage());
		    	 
		      }
		      
		      // view 명칭
		      return "shareBoard/shareBoard.jsp";
		
	
	}

}
