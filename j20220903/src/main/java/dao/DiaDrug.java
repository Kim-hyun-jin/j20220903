package dao;

public class DiaDrug {

	private int patient_no;//PK 환자번호
	private int chart_no;//PK FK 차트번호
	private int drug_code;//PK Fk 약품코드
	
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
