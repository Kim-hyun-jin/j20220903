package service.jw;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Patient;
import dao.PatientDao;
import service.CommandProcess;

public class PatientSearchAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("PatientSearchAct 작동...");

		HttpSession session = request.getSession();
		
		String department = request.getParameter("department");
		String doctorName = request.getParameter("doctorName");
		String reservationDate = request.getParameter("reservationDate");
		String patientName = request.getParameter("patientName");
		if (reservationDate == null || reservationDate == "") {
			reservationDate = "";
		}
		if (reservationDate != null && reservationDate != "") {
			reservationDate = reservationDate.replaceAll("-", "/"); 
			reservationDate = reservationDate.substring(reservationDate.length()-8, reservationDate.length());
		}
		
		session.setAttribute("department", department);
		session.setAttribute("doctorName", doctorName);
		session.setAttribute("reservationDate", request.getParameter("reservationDate"));
		session.setAttribute("patientName", request.getParameter("patientName"));
		
		try {
			PatientDao pd = PatientDao.getInstance();
			
			List<Patient> list_pat = pd.patientSearch(department, doctorName, reservationDate, patientName);
			ArrayList<ArrayList<String>> searchSet = pd.searchSet(department, doctorName, reservationDate, patientName);
			
			List<String> list_res_date = new ArrayList<String>();
			System.out.println("list_pat size ==> "+list_pat.size());
			System.out.println("서치셋 size ==> "+searchSet.size());
			session.setAttribute("searchSet", searchSet);
			session.setAttribute("list_pat", list_pat);
			session.setAttribute("list_res_date", list_res_date);
			
		} catch (Exception e) {
			System.out.println("patientSearchAct e.getMessage"+ e.getMessage());
		}
		
		
		return "patientSearch/patientSearchAct.jsp";
	}

}
