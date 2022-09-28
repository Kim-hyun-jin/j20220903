package service.jw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DiaDrugDao;
import service.CommandProcess;

public class PatientSearchAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("PatientSearchAct 작동...");

		String department = request.getParameter("department");
		String doctor_Name = request.getParameter("doctor_Name");
		String reservation = request.getParameter("reservation");
		DiaDrugDao ddd= DiaDrugDao.getInstance();
		String result = ddd.connectionCheck();
		System.out.println("connectionCheck == "+result);
		return "main/3-layout.html";
	}

}
