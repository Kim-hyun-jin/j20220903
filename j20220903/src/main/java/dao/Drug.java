package dao;

public class Drug {
	
	private int drug_code;//PK 약품코드
	private String drug_class;//약품분류
	private String drug_name;//약품명
	
	public int getDrug_code() {
		return drug_code;
	}
	public void setDrug_code(int drug_code) {
		this.drug_code = drug_code;
	}
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
	
}
