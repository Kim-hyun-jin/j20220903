package service.jw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Doctor;
import dao.DoctorDao;
import dao.Reservation;
import dao.ReservationDao;
import service.CommandProcess;

public class PatientSearchView implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("PatientSearchView Start...");
		String rdt = "*";
		try {
			DoctorDao dd = DoctorDao.getInstance();
			ReservationDao rd = ReservationDao.getInstance();
			List<Doctor> list_doc = dd.doctorList("*");
			List<Reservation> list_res = rd.reserList(rdt);
			System.out.println("list_doc.size() == >"+list_doc.size());
			System.out.println("list_res.size() == >"+list_res.size());
			
			request.setAttribute("list_doc", list_doc);
	        request.setAttribute("list_res", list_res);
	        System.out.println("list_res.size() == >"+list_res.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "patientSearch/patientSearch.jsp";
	}

}
