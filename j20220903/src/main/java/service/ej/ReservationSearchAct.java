package service.ej;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Reservation2;
import dao.ReservationDao;
import service.CommandProcess;

public class ReservationSearchAct implements CommandProcess {

	//환자검색 액션
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ReservationSearchAct 작동...");

		String patientName = request.getParameter("patientName");
				
		
		try {
//			PatientDao pd = PatientDao.getInstance();
			
//			List<Patient> list_pat = pd.patientSearch(patientName);
//			request.setAttribute("list_pat", list_pat);
			
			ReservationDao rd = ReservationDao.getInstance();
			System.out.println("###########ReservationSearchAct start");
			List<Reservation2> list_pat = rd.reservationInfoSearch(patientName);
			System.out.println("###########ReservationSearchAct end");
			
			List<Reservation2> doctorInfo = rd.doctorInfo(patientName);
			
			
			request.setAttribute("list_pat", list_pat);
			request.setAttribute("doctorinfo", doctorInfo);
			
		} catch (Exception e) {
			System.out.println("patientSearchAct e.getMessage"+ e.getMessage());
		}
		
		
		return "reservation/reservationSearch.jsp";
	}

}
