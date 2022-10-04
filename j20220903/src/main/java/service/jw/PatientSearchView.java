package service.jw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		try {
			DoctorDao dd = DoctorDao.getInstance();
			ReservationDao rd = ReservationDao.getInstance();
			List<Doctor> list_doc = dd.doctorList("");
			List<Reservation> list_res = rd.reserList("");
			System.out.println("list_doc.size() == >"+list_doc.size());
			System.out.println("list_res.size() == >"+list_res.size());
			
			List<String> list_res_date = new ArrayList<String>();
			list_res_date.add(list_res.get(0).getReservation_date()); 
			for(int i=1; i<list_res.size(); i++) {
				System.out.println("PatientSearchView list_res.get(i).getReservation_date()->"+list_res.get(i-1).getReservation_date());
				if(!list_res.get(i).getReservation_date().equals(list_res.get(i-1).getReservation_date())) {
					System.out.println("date값 입력");
					list_res_date.add(list_res.get(i).getReservation_date());
				} else System.out.println("중복제거");
			}
			System.out.println("list_res_date.size() == >"+list_res_date.size());
			
			request.setAttribute("list_doc", list_doc);
			request.setAttribute("list_res_date", list_res_date);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "patientSearch/patientSearch.jsp";
	}

}
