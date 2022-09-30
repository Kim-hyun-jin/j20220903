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
		
		PatientDao patientDao = PatientDao.getInstance();
		
		try {
			List<Patient> listDao = patientDao.selectNameAll();
			request.setAttribute("patient_name_list", listDao);

		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("PatientManageView.java:"+e.getMessage());
		}
		return "patientManage/patientManage.jsp";
	}

}
