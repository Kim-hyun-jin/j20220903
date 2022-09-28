package service.sh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DrugDao;
import service.CommandProcess;

public class DrugSearch implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DrugSearch Start...");
		String drug_name = request.getParameter("drug_name");
		
		DrugDao dd = DrugDao.getInstance();
		
		
		return null;
	}

}
