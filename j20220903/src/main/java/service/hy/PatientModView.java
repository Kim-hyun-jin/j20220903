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

public class PatientModView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("PatientManageView Service start...");
		
		PatientDao pd = PatientDao.getInstance();
		
		try {

			List<Patient> listDao = pd.selectAll();
			//doctor_no 2로 임시처리 getAttribute from request
			//session.get?
			request.setAttribute("patient_list", listDao);

		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("PatientManageView.java:"+e.getMessage());
		}
		return "patientManage/patientManage.jsp";
	}

}
