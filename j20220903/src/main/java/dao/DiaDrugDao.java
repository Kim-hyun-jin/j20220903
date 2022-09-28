package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DiaDrugDao {
	private static DiaDrugDao instance;
	private DiaDrugDao() {}	
	public static DiaDrugDao getInstance() {
		if(instance==null) {
			instance = new DiaDrugDao();
		}
		return instance;
	}
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	public String connectionCheck() {
		String result= "실패";
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "select * from diadrug";
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			int rs=pstmt.executeUpdate();
			if(rs>0) {
				result="성공!";
			}
		} catch (Exception e) {
		}
		return result;
	}

}
