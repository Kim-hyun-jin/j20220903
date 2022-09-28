package dao;

import java.util.Date;

public class DiaHistory {
	
	private int patient_no;
	private int chart_no;
	private String chart_symptom;
	private String chart_disease;
	private Date chart_date;
	private String doctor_no;
	
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
