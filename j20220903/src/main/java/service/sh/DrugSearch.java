package service.sh;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Doctor;
import dao.DoctorDao;
import dao.Drug;
import dao.DrugDao;
import service.CommandProcess;

public class DrugSearch implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DrugSearch Start...");
		
		try {
			String doctor_no	= request.getParameter("doctor_no");
			String drug_name	= request.getParameter("drug_name");
			String drug_class	= request.getParameter("drug_class");
			
			System.out.println(drug_class); /* 제대로 넘어 오는구만 */
			
			DoctorDao docd = DoctorDao.getInstance();
			Doctor doctor = docd.select(doctor_no);
			
			DrugDao dd = DrugDao.getInstance();
			List<Drug> list = dd.drugList(drug_name, drug_class);
			
			
			request.setAttribute("doctor", doctor);
			request.setAttribute("list", list);
		} catch (SQLException e) {
			System.out.println("DrugSearch Error => " + e.getMessage());
		}
		
		
		return "drug/drug.jsp";
	}

}
