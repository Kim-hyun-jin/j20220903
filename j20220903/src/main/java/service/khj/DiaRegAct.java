package service.khj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DiaHistoryDao;
import dao.PatientDao;
import service.CommandProcess;

public class DiaRegAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DiaRegAct start...");
		String chart_symptom = request.getParameter("chart_symptom");
		String[] drug_code = request.getParameterValues("drug_list");
		String chart_disease = request.getParameter("chart_disease");
		String patient_no = request.getParameter("patient_no");
		System.out.println("patient_no"+patient_no);
//		int doctor_no = request.getParameter("doctor_no");
		
		try {
			DiaHistoryDao dhd = DiaHistoryDao.getInstance();
			int result = dhd.diaReg(chart_symptom,chart_disease,patient_no,2,drug_code);
			
			request.setAttribute("patient_no", patient_no);
			request.setAttribute("result", result);
		} catch (Exception e) {
			System.out.println("DiaRegAct e.getMessage ==>"+e.getMessage());
		}
		return "patientManage/diaHistory.jsp";
	}

}
