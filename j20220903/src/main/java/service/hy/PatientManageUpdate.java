package service.hy;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Patient;
import dao.PatientDao;
import service.CommandProcess;

public class PatientManageUpdate implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("PatientManageUpdate Service start...");
		
		
		String doctor_no = request.getParameter("doctor_no");
		//임의 지정
		doctor_no = "2";
		int patient_no = Integer.parseInt(request.getParameter("patient_no"));
		
		try {
			PatientDao pd = PatientDao.getInstance();
			Patient patient = pd.deletePatient(patient_no);
			request.setAttribute("list", patient);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//삭제하시겠습니까 화면 페이지 
		//return null;
	}

}
