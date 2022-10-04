package service.khj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

public class DiaHistroyView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int patient_no =Integer.parseInt(request.getParameter("patient_no"));
		request.setAttribute("patient_no", patient_no);
		System.out.println("DiaHistoryView.java");
		return "patientManage/diaHistory.jsp";
	}

}
