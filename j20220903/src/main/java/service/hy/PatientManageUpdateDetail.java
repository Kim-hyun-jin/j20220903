package service.hy;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Patient;
import dao.PatientDao;
import service.CommandProcess;

public class PatientManageUpdateDetail implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("patientManageUpdateDetail Service start...");
		
		String doctor_no = request.getParameter("doctor_no");
		doctor_no = "2";
		
		int patient_no = Integer.parseInt(request.getParameter("patient_no"));
		System.out.println("patient_no ->" + patient_no);
		
		try {
			PatientDao pd = PatientDao.getInstance();
			
			
			Patient patient = pd.selectPatient(patient_no);
			//doctor_no 2로 임시처리 getAttribute from request
			//session.get?
			request.setAttribute("list", patient);
			System.out.println(patient);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "patientManage/patientManageUpdateDetail.jsp";
	}

}
