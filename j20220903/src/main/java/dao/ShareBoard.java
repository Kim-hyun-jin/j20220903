package dao;

import java.util.Date;

public class ShareBoard {


	   private int shareBoard_no;//PK 글번호
	   private String shareBoard_subject;//제목
	   private String shareBoard_content;//상세내용
	   private Date shareBoard_date;//등록일
	   private String doctor_no;//FK 의사번호
	   
	   
	   public int getShareBoard_no() {
	      return shareBoard_no;
	   }
	   public void setShareBoard_no(int shareBoard_no) {
	      this.shareBoard_no = shareBoard_no;
	   }
	   public String getShareBoard_subject() {
	      return shareBoard_subject;
	   }
	   public void setShareBoard_subject(String shareBoard_subject) {
	      this.shareBoard_subject = shareBoard_subject;
	   }
	   public String getShareBoard_content() {
	      return shareBoard_content;
	   }
	   public void setShareBoard_content(String shareBoard_content) {
	      this.shareBoard_content = shareBoard_content;
	   }
	   public Date getShareBoard_date() {
	      return shareBoard_date;
	   }
	   public void setShareBoard_date(Date shareBoard_date) {
	      this.shareBoard_date = shareBoard_date;
	   }
	   public String getDoctor_no() {
	      return doctor_no;
	   }
	   public void setDoctor_no(String doctor_no) {
	      this.doctor_no = doctor_no;
	   }

}
