package dao;

import java.util.ArrayList;
import java.util.Date;

public class PatientInf {
	private int patient_no;//PK 환자번호
	private String patient_name;//환자이름
	private String gender;//성별
	private String birth;//생년월일
	private String address;//주소
	private String contact;//연락처
	private String protector_contact;//보호자연락처
	private String social_number;//주민번호
	private String doctor_no;//담당의
	private int password;//비밀번호
	private String doctor_name;//의사이름
	private String department;//진료과
	private String image;//의사사진
	private ArrayList<String> reservation_date;//PK 예약일
	private ArrayList<String> reservation_hour;//PK 예약시간
	private int chart_no;//PK 차트번호
	private String chart_symptom;//증상
	private String chart_disease;//병명
	private Date chart_date;//진단일시
	
	public int getChart_no() {
		return chart_no;
	}
	public void setChart_no(int chart_no) {
		this.chart_no = chart_no;
	}
	public String getChart_symptom() {
		return chart_symptom;
	}
	public void setChart_symptom(String chart_symptom) {
		this.chart_symptom = chart_symptom;
	}
	public String getChart_disease() {
		return chart_disease;
	}
	public void setChart_disease(String chart_disease) {
		this.chart_disease = chart_disease;
	}
	public Date getChart_date() {
		return chart_date;
	}
	public void setChart_date(Date chart_date) {
		this.chart_date = chart_date;
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
	public String getProtector_contact() {
		return protector_contact;
	}
	public void setProtector_contact(String protector_contact) {
		this.protector_contact = protector_contact;
	}
	public String getSocial_number() {
		return social_number;
	}
	public void setSocial_number(String social_number) {
		this.social_number = social_number;
	}
	public String getDoctor_no() {
		return doctor_no;
	}
	public void setDoctor_no(String doctor_no) {
		this.doctor_no = doctor_no;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public ArrayList<String> getReservation_date() {
		return reservation_date;
	}
	public void setReservation_date(ArrayList<String> reservation_date) {
		this.reservation_date = reservation_date;
	}
	public ArrayList<String> getReservation_hour() {
		return reservation_hour;
	}
	public void setReservation_hour(ArrayList<String> reservation_hour) {
		this.reservation_hour = reservation_hour;
	}
}
