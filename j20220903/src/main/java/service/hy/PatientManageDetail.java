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

public class PatientManageDetail implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("PatientManageDetail Service start...");
		
		
		/* String doctor_no = request.getParameter("doctor_no"); */
		int patient_no = Integer.parseInt(request.getParameter("patient_no"));
		System.out.println("patient_no"+patient_no);
			
		try {
			
			PatientDao pd = PatientDao.getInstance();
			
			//doctor_no 임의로 2
			/* Patient patient = pd.select(doctor_no, patient_no); */
			Patient patient = pd.selectPatient(patient_no);
			
			request.setAttribute("list", patient);
			System.out.println("patient..." + patient.getPatient_name());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "patientManage/patientManageDetail.jsp";
	}

}
