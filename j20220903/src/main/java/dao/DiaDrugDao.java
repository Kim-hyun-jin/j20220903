package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public ArrayList<DiaDrugInf> diaDrugList(int patient_no, int chart_no) throws SQLException{
		ArrayList<DiaDrugInf> rsDiadrugs = new ArrayList<DiaDrugInf>();
		Connection conn			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		String sql				= 
				"SELECT *\r\n"
				+ "FROM diadrug ddd\r\n"
				+ "LEFT JOIN drug drug ON drug.drug_code = ddd.drug_code\r\n"
				+ "WHERE ddd.patient_no=? AND ddd.chart_no=?";
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, patient_no);
			pstmt.setInt(2, chart_no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					DiaDrugInf dd = new DiaDrugInf();
					dd.setChart_no(chart_no);
					dd.setPatient_no(patient_no);
					dd.setDrug_code(rs.getInt("drug_code"));
					dd.setDrug_name(rs.getString("drug_name"));
					dd.setDrug_class(rs.getString("drug_class"));
					rsDiadrugs.add(dd);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("DiaDrug.diaDrugList e.getMessage ==> " + e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return rsDiadrugs;
	}

}
