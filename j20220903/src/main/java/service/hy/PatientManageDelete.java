package service.hy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Patient;
import dao.PatientDao;
import service.CommandProcess;

public class PatientManageDelete implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("PatientManageDelete Service start...");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String doctor_no = request.getParameter("doctor_no");
		doctor_no = "2";	//임의 지정
		
		int patient_no = Integer.parseInt(request.getParameter("patient_no"));
		
		try {
			PatientDao pd = PatientDao.getInstance();
			
			int result = pd.deletePatient(patient_no);
			request.setAttribute("result", result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//삭제되었습니다 화면 페이지
		return "patientManage/patientManageDelete.jsp";
	}

}
