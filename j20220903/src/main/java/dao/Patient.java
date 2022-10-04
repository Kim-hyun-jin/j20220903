package dao;

public class Patient {
	
	private int patient_no;//PK 환자번호
	private String patient_name;//환자이름 NOT NULL
	private String gender;//성별 NOT NULL
	private String birth;//생년월일 NOT NULL
	private String address;//주소 
	private String contact;//연락처
	private String protector_contact;//보호자연락처
	private String social_number;//주민번호 NOT NULL
	private String doctor_no;//담당의 NOT NULL
	
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

	
}
