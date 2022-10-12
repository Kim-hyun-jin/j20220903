package service.khj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DiaDrugDao;
import dao.DiaHistoryDao;
import service.CommandProcess;

public class DiaModAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DiaModAct start...");
		String patient_no = request.getParameter("patient_no");
		String chart_no = request.getParameter("chart_no");
		String chart_symptom = request.getParameter("chart_symptom");
		String chart_disease = request.getParameter("chart_disease");
		String[] drug_code = request.getParameterValues("drug_list");
		
		try {
			DiaHistoryDao dhd=DiaHistoryDao.getInstance();
			DiaDrugDao ddd= DiaDrugDao.getInstance();
			
			int ddirs = ddd.diaDrugMod(patient_no, chart_no,drug_code);
			int dhdrs = dhd.diaMod(patient_no,chart_no,chart_symptom,chart_disease); 
			
			System.out.println("diadrug == "+ddd);
			System.out.println("diahistory == "+dhd);
			request.setAttribute("patient_no", patient_no);
			request.setAttribute("diaDrugResult", ddirs);
			request.setAttribute("modResult", dhdrs); 
		} catch (Exception e) {
			System.out.println("DiaInfView e.getMessage() ==>"+e.getMessage());
		}
		return "patientManage/diaHistory.jsp";
	}

}
