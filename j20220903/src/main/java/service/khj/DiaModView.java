package service.khj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DiaDrugDao;
import dao.DiaDrugInf;
import dao.DiaHistoryDao;
import dao.DiaHistoryInf;
import dao.Drug;
import dao.DrugDao;
import dao.PatientDao;
import dao.PatientInf;
import service.CommandProcess;

public class DiaModView implements CommandProcess {

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
			DrugDao dd = DrugDao.getInstance();
			
			PatientInf pi = pd.patientInf(patient_no);
			DiaHistoryInf dhi = dhd.diaInf(patient_no,chart_no); 
			ArrayList<DiaDrugInf> ddi = ddd.diaDrugList(patient_no, chart_no);
			ArrayList<Drug> drug = dd.drugListAll();
			
			List<Integer> drugList = new ArrayList<Integer>();
			for(DiaDrugInf dl : ddi) {
				drugList.add(dl.getDrug_code());
			}
			
			request.setAttribute("drug", drug);
			request.setAttribute("drugList", drugList);
			request.setAttribute("diaInf", dhi);
			request.setAttribute("patientInf", pi);
			request.setAttribute("diaDrug", ddi);
		} catch (Exception e) {
			System.out.println("DiaInfView e.getMessage() ==>"+e.getMessage());
		}
		return "patientManage/diaMod.jsp";
	}

}
