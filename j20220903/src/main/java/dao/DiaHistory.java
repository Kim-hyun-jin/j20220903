package dao;

import java.util.Date;

public class DiaHistory {
	
	private int patient_no;//PK FK 환자번호
	private int chart_no;//PK 차트번호
	private String chart_symptom;//증상
	private String chart_disease;//병명
	private Date chart_date;//진단일시
	private String doctor_no;//FK 의사번호
	
	public int getPatient_no() {
		return patient_no;
	}
	public void setPatient_no(int patient_no) {
		this.patient_no = patient_no;
	}
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
	public String getDoctor_no() {
		return doctor_no;
	}
	public void setDoctor_no(String doctor_no) {
		this.doctor_no = doctor_no;
	}
	
}
