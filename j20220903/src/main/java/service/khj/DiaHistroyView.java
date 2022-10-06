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
import service.CommandProcess;

public class DiaHistroyView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int patient_no =Integer.parseInt(request.getParameter("patient_no"));
		request.setAttribute("patient_no", patient_no);
		
		try {
			DiaDrugDao ddd = DiaDrugDao.getInstance();
			DiaHistoryDao dhd = DiaHistoryDao.getInstance();
			ArrayList<DiaHistoryInf> dhl = dhd.diaHistoryList(patient_no);
			ArrayList<ArrayList<DiaDrugInf>> rsdd = new ArrayList<ArrayList<DiaDrugInf>>();
			int i = 0;
			if(!dhl.isEmpty()) {
				do {
					ArrayList<DiaDrugInf> dd = ddd.diaDrugList(dhl.get(i).getPatient_no(), dhl.get(i).getChart_no());
					rsdd.add(dd);
					i++;
				} while (dhl.size()>i);
				request.setAttribute("rsdd", rsdd);
				request.setAttribute("dhl", dhl);
				request.setAttribute("patient_no", patient_no);
			}
		} catch (Exception e) {
			System.out.println("DiaHistoryView e.getMessage ==> "+ e.getMessage());
		}
		System.out.println("DiaHistoryView.java");
		return "patientManage/diaHistory.jsp";
	}

}
