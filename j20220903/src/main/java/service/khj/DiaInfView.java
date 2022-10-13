package service.khj;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DiaDrugDao;
import dao.DiaDrugInf;
import dao.DiaHistoryDao;
import dao.DiaHistoryInf;
import dao.PatientDao;
import dao.PatientInf;
import service.CommandProcess;

public class DiaInfView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DiaInfView start...");
		int patient_no = Integer.parseInt(request.getParameter("patient_no"));
		int chart_no = Integer.parseInt(request.getParameter("chart_no"));
		
		try {
			PatientDao pd = PatientDao.getInstance();
			DiaHistoryDao dhd=DiaHistoryDao.getInstance();
			DiaDrugDao ddd= DiaDrugDao.getInstance();
			
			PatientInf pi = pd.patientInf(patient_no);
			DiaHistoryInf dhi = dhd.diaInf(patient_no,chart_no); 
//			ArrayList<DiaHistoryInf> dhl = dhd.diaHistoryList(patient_no);
			ArrayList<DiaDrugInf> ddi = ddd.diaDrugList(patient_no, chart_no);
			
			
			request.setAttribute("diaInf", dhi);
			request.setAttribute("patientInf", pi);
			request.setAttribute("diaDrug", ddi);
			request.setAttribute("patient_no", patient_no);
			request.setAttribute("chart_no", chart_no);
		} catch (Exception e) {
			System.out.println("DiaInfView e.getMessage() ==>"+e.getMessage());
		}
		return "patientManage/diaInf.jsp";
	}

}
