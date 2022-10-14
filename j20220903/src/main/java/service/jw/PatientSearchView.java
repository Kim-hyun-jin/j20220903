package service.jw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		session.removeAttribute("searchSet");
		session.removeAttribute("list_pat");
		session.removeAttribute("list_res_date");
		session.removeAttribute("department");
		session.removeAttribute("doctorName");
		session.removeAttribute("reservationDate");
		session.removeAttribute("patientName");
		
		try {
			DoctorDao dd = DoctorDao.getInstance();
			ReservationDao rd = ReservationDao.getInstance();
			List<Doctor> list_doc = dd.doctorList("");
			List<Reservation> list_res = rd.reserList("");
			
			List<String> list_res_date = new ArrayList<String>();
			list_res_date.add(list_res.get(0).getReservation_date()); 
			for(int i=1; i<list_res.size(); i++) {
				if(!list_res.get(i).getReservation_date().equals(list_res.get(i-1).getReservation_date())) {
					list_res_date.add(list_res.get(i).getReservation_date());
				}
			}
			ArrayList<String> dep = new ArrayList<String>();
			ArrayList<String> nam = new ArrayList<String>();
			dep.add(list_doc.get(0).getDepartment());
			nam.add(list_doc.get(0).getDoctor_name());
			for(int i=1; i<list_doc.size(); i++) {
				if(!dep.contains(list_doc.get(i).getDepartment())) {
					dep.add(list_doc.get(i).getDepartment());
				}
				if(!nam.contains(list_doc.get(i).getDoctor_name())) {
					nam.add(list_doc.get(i).getDoctor_name());
				}
			}
			session.setAttribute("dep", dep);
			session.setAttribute("nam", nam);
			session.setAttribute("list_res_date", list_res_date);
		} catch (Exception e) {
			System.out.println("PatientSearchView ==> "+e.getMessage());
		}
		return "patientSearch/patientSearch2.jsp";
	}

}
