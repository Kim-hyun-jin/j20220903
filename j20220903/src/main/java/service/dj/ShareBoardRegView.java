package service.dj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Doctor;
import dao.DoctorDao;
import service.CommandProcess;

public class ShareBoardRegView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("WriteFormAction Start...");

		try {
			// 신규글 이전 jsp에서 넘긴 파라미터
			String pageNum = request.getParameter("pageNum");
			String doctor_no = request.getParameter("doctor_no");	// 의사번호는 알어, BUT 이름은 몰라
			// String doctor_name = request.getParameter("doctor_name");

			if (pageNum == null)
				pageNum = "1";
			
			//ShareBoardDao bd = ShareBoardDao.getInstance();

			// 4. shareBoard board = bd.select(num);
			//Doctor doctor = new Doctor();
			
			DoctorDao dd = DoctorDao.getInstance();
			Doctor doctor = dd.select(doctor_no);	// 의사 이름 가져오기 쿼리
			String doctor_name = doctor.getDoctor_name();

			// 다음 jsp에서 사용할 값
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("doctor_no", doctor_no);
			request.setAttribute("doctor_name", doctor_name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "shareBoard/shareBoardRegForm.jsp";
	}

}
