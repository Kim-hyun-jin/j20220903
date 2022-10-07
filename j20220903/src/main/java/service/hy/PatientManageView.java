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

public class PatientManageView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("PatientManageView Service start...");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
				
		
		try {
			PatientDao pd = PatientDao.getInstance();
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
