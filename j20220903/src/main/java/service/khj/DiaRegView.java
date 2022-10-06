package service.khj;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Drug;
import dao.DrugDao;
import service.CommandProcess;

public class DiaRegView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DiaRegView start...");
		try {
			DrugDao dd = DrugDao.getInstance();
			ArrayList<Drug> drug = dd.drugListAll();
			
			request.setAttribute("drug", drug);
			request.setAttribute("patient_no", request.getParameter("patient_no"));
		} catch (Exception e) {
			System.out.println("DiaRegView e.getMessage ==> "+e.getMessage());
		}
		return "patientManage/diaReg.jsp";
	}

}
