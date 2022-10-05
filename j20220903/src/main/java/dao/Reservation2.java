package dao;

public class Reservation2 {


	private String reservation_date;//PK 예약일
	private String reservation_hour;//PK 예약시간
	private String doctor_no;//PK FK 의사번호
	private int patient_no;//FK 환자번호
	
	private String patient_name;
	private String doctor_name;
	private String department;
	
	private String gender;
	private String birth;
	private String address;
	private String contact;
	
	
	
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
	public int getPatient_no() {
		return patient_no;
	}
	public void setPatient_no(int patient_no) {
		this.patient_no = patient_no;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
