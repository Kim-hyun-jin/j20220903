package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//singleton + DBCP
public class DoctorDao {
	private static DoctorDao instance;
	
	private DoctorDao() {
	}
	
	public static DoctorDao getInstance() {
		if (instance == null) {
			instance = new DoctorDao();
		}
		return instance;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
	
	public int check(String doctor_no, int password) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT doctor_no, password FROM doctor WHERE doctor_no=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, doctor_no);
			rs = pstmt.executeQuery();
			// 일단 id OK 상태
			if(rs.next()) {
				int dbPasswd = rs.getInt(2);
				System.out.println(dbPasswd);
				// password 체크
				if (dbPasswd == password) {
					result = 1;
				}
			} ;

		} catch (Exception e) {
			System.out.println("check error -> " + e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}
	
	public Doctor select(String doctor_no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM doctor WHERE doctor_no=?";

		Doctor doctor = new Doctor();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, doctor_no);
			rs = pstmt.executeQuery();
			// id는 primary key 이므로 데이터는 하나
			// 따라서 while문이 필요 없다.
			if (rs.next()) {
				doctor.setDoctor_no(rs.getString("doctor_no"));
				doctor.setDoctor_name(rs.getString("doctor_name"));
				doctor.setDepartment(rs.getString("department"));
				doctor.setPassword(rs.getInt("password"));
				doctor.setImage(rs.getString("image"));
			}
		} catch (Exception e) {
			System.out.println("select error -> " + e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}

		return doctor;

	}
	
	public String search(String doctor_no, String doctor_name) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT password FROM doctor WHERE doctor_no=? AND doctor_name=?";
		String result = "";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, doctor_no);
			pstmt.setString(2, doctor_name);
			rs = pstmt.executeQuery();
			// id는 primary key 이므로 데이터는 하나
			// 따라서 while문이 필요 없다.
			if (rs.next()) {
				result = rs.getString("password");
				System.out.println("DoctorDao search result -> " + result);
			}
		} catch (Exception e) {
			System.out.println("select error -> " + e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
public List<Doctor> doctorList(String doctor_no) throws SQLException {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      List<Doctor> list = new ArrayList<Doctor>();
	      String sql = "SELECT * FROM doctor WHERE doctor_no=?";
	      String sqlif = "SELECT * FROM doctor";
	      try {
	    	  conn = getConnection();
	    	  if(doctor_no=="") {
	    		 pstmt = conn.prepareStatement(sqlif);
	    	  } else {
	        	 pstmt = conn.prepareStatement(sql);
	        	 pstmt.setString(1, doctor_no);
	    	  }
	    	  rs = pstmt.executeQuery();
	    	  if (rs.next()) {
	    		  do {
	    			  Doctor doctor = new Doctor();
	    			  doctor.setDoctor_no(rs.getNString(1));
	    			  doctor.setDoctor_name(rs.getString(3));
	    			  doctor.setDepartment(rs.getString(4));
	    			  doctor.setPassword(rs.getInt(2));
	    			  doctor.setImage(rs.getString(5));
	    			  list.add(doctor);
	    		  } while (rs.next());
	    	  }
	      } catch (Exception e) {
	         System.out.println("list error -> " + e.getMessage());
	      } finally {
	         if (rs != null) rs.close();
	         if (pstmt != null) pstmt.close();
	         if (conn != null) conn.close();
	      }
	      return list;
	   }

}
