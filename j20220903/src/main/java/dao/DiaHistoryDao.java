package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DiaHistoryDao {
	private static DiaHistoryDao instance;
	private DiaHistoryDao() {}	
	public static DiaHistoryDao getInstance() {
		if(instance==null) {
			instance = new DiaHistoryDao();
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
	public ArrayList<DiaHistoryInf> diaHistoryList(int patient_no) throws SQLException {

		ArrayList<DiaHistoryInf> rsDiaHistories = new ArrayList<DiaHistoryInf>();
		Connection conn			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		String sqlbase			= 
				"SELECT dh.* ,d.doctor_name,d.department\r\n"
				+ "FROM diahistory dh, doctor d\r\n"
				+ "WHERE dh.patient_no =?\r\n"
				+ "AND dh.doctor_no=d.doctor_no";
		try {
			conn = getConnection();
			pstmt= conn.prepareStatement(sqlbase);
			pstmt.setInt(1, patient_no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("rs.next() true!");
				do {
					DiaHistoryInf dia= new DiaHistoryInf();
					dia.setChart_date(rs.getDate("chart_date"));
					dia.setChart_disease(rs.getString("chart_disease"));
					dia.setChart_no(rs.getInt("chart_no"));
					dia.setChart_symptom(rs.getString("chart_symptom"));
					dia.setDoctor_no(rs.getInt("doctor_no"));
					dia.setPatient_no(rs.getInt("patient_no"));
					dia.setDoctor_name(rs.getString("Doctor_name"));
					dia.setDepartment(rs.getString("Department"));
					rsDiaHistories.add(dia);
				} while (rs.next());
			
			}
		}catch (Exception e) {
			System.out.println("DiaHistory.historyList e.getMessage ==> " + e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return rsDiaHistories;
	}
	public int diaReg(String chart_symptom, String chart_disease, String patient_no, int doctor_no, String[] drug_code) throws SQLException {
		int result = 0;
		System.out.println(patient_no);
		Connection conn			= null;
		PreparedStatement pstmt	= null;
		String sqlbase			= "INSERT INTO diahistory values(?,(SELECT MAX(CHART_NO)+1 FROM DIAHISTORY WHERE PATIENT_NO =?),?,?,sysdate,?)";
		try {
			conn = getConnection();
			pstmt= conn.prepareStatement(sqlbase);
			pstmt.setString(1, patient_no);
			pstmt.setString(2, patient_no);
			pstmt.setString(3, chart_symptom);
			pstmt.setString(4, chart_disease);
			pstmt.setInt(5, doctor_no);
			result=pstmt.executeUpdate();
			if(result>0) {
				String sql2 = "INSERT INTO diadrug values(?,(SELECT MAX(CHART_NO) FROM diahistory WHERE PATIENT_NO=?),?)";
				for(int i=0; i<drug_code.length; i++) {
					pstmt.close();
					pstmt=conn.prepareStatement(sql2);
					pstmt.setString(1, patient_no);
					pstmt.setString(2, patient_no);
					pstmt.setString(3, drug_code[i]);
					int rs=pstmt.executeUpdate();
				}
			}
		}catch (Exception e) {
			System.out.println("DiaHistory.diaReg e.getMessage ==> " + e.getMessage());
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}
}
