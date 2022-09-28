package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public int check(String doctor_no, String password) throws SQLException {
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
				String dbPasswd = rs.getString(2);
				// password 체크
				if (dbPasswd.equals(password)) {
					result = 1;
				}
			// ID 부터 X
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
}
