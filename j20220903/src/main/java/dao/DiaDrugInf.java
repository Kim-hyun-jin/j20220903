package dao;

public class DiaDrugInf {

	private int patient_no;//PK 환자번호
	private int chart_no;//PK FK 차트번호
	private int drug_code;//PK Fk 약품코드
	private String drug_class;//약품분류
	private String drug_name;//약품명
	
	public String getDrug_class() {
		return drug_class;
	}
	public void setDrug_class(String drug_class) {
		this.drug_class = drug_class;
	}
	public String getDrug_name() {
		return drug_name;
	}
	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}
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
	public int getDrug_code() {
		return drug_code;
	}
	public void setDrug_code(int drug_code) {
		this.drug_code = drug_code;
	}
}
