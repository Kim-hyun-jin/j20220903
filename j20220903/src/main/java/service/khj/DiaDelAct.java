package service.khj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DiaDrugDao;
import dao.DiaHistoryDao;
import service.CommandProcess;

public class DiaDelAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("DiaModAct start...");
		int patient_no = Integer.parseInt(request.getParameter("patient_no"));
		int chart_no = Integer.parseInt(request.getParameter("chart_no"));
		
		try {
			DiaHistoryDao dhd=DiaHistoryDao.getInstance();
			DiaDrugDao ddd= DiaDrugDao.getInstance();
			
			int ddirs = ddd.diaDrugDel(patient_no, chart_no);
			int dhdrs = dhd.diaDel(patient_no,chart_no); 
			
			request.setAttribute("patient_no", patient_no);
			request.setAttribute("diaDrugResult", ddirs);
			request.setAttribute("delResult", dhdrs); 
		} catch (Exception e) {
			System.out.println("DiaInfView e.getMessage() ==>"+e.getMessage());
		}
		return "patientManage/diaHistory.jsp";
	}

}
