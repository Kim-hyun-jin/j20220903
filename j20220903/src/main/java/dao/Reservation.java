package dao;

public class Reservation {


	private String reservation_date;//PK 예약일
	private String reservation_hour;//PK 예약시간
	private String doctor_no;//PK FK 의사번호
	private String patient_no;//FK 환자번호
	
	
	public String getReservation_date() {
		return reservation_date;
	}
	public void setReservation_date(String reservation_date) {
		this.reservation_date = reservation_date;
	}
	public String getReservation_hour() {
		return reservation_hour;
	}
	public void setReservation_hour(String reservation_hour) {
		this.reservation_hour = reservation_hour;
	}
	public String getDoctor_no() {
		return doctor_no;
	}
	public void setDoctor_no(String doctor_no) {
		this.doctor_no = doctor_no;
	}
	public String getPatient_no() {
		return patient_no;
	}
	public void setPatient_no(String patient_no) {
		this.patient_no = patient_no;
	}

	
}
