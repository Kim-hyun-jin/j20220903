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
	public int diaReg(String chart_symptom, String chart_disease, String patient_no, String doctor_no, String[] drug_code) throws SQLException {
		int result = 0;
		System.out.println(patient_no);
		Connection conn			= null;
		PreparedStatement pstmt	= null;
		ResultSet rsa		=	null;
		
		String sqlbase			= "INSERT INTO diahistory values(?,(SELECT MAX(CHART_NO)+1 FROM DIAHISTORY WHERE PATIENT_NO =?),?,?,sysdate,?)";
		String sqlbase2			= "select chart_no from diahistory WHERE patient_no=?";
		String sqlbase3			= "INSERT INTO diahistory values(?,1,?,?,sysdate,?)";
		try {
			conn = getConnection();
			pstmt= conn.prepareStatement(sqlbase2);
			pstmt.setString(1, patient_no);
			rsa= pstmt.executeQuery();
			if(!rsa.next()) {
				rsa.close();
				pstmt.close();
				pstmt = conn.prepareStatement(sqlbase3);
				pstmt.setString(1, patient_no);
				pstmt.setString(2, chart_symptom);
				pstmt.setString(3, chart_disease);
				pstmt.setString(4, doctor_no);
			} else {
				rsa.close();
				pstmt.close();
				pstmt= conn.prepareStatement(sqlbase);
				pstmt.setString(1, patient_no);
				pstmt.setString(2, patient_no);
				pstmt.setString(3, chart_symptom);
				pstmt.setString(4, chart_disease);
				pstmt.setString(5, doctor_no);
			}
			result=pstmt.executeUpdate();
			if(result>0) {
				String sql2 = "INSERT INTO diadrug values(?,(SELECT MAX(CHART_NO) FROM diahistory WHERE PATIENT_NO=?),?)";
				int rs=0;
				for(int i=0; i<drug_code.length; i++) {
					pstmt.close();
					pstmt=conn.prepareStatement(sql2);
					pstmt.setString(1, patient_no);
					pstmt.setString(2, patient_no);
					pstmt.setString(3, drug_code[i]);
					rs+=pstmt.executeUpdate();
				}
				if(rs>0) System.out.println("약품등록 성공!("+rs+"/"+drug_code.length+")");
			}
		}catch (Exception e) {
			System.out.println("DiaHistory.diaReg e.getMessage ==> " + e.getMessage());
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}
	public DiaHistoryInf diaInf(int patient_no,int chart_no) throws SQLException {

		DiaHistoryInf rsDia = new DiaHistoryInf();
		Connection conn			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		String sqlbase			= 
				"SELECT dh.* ,d.doctor_name,d.department\r\n"
				+ "FROM diahistory dh, doctor d\r\n"
				+ "WHERE dh.patient_no =?\r\n"
				+ "AND dh.chart_no =?\r\n"
				+ "AND dh.doctor_no=d.doctor_no";
		try {
			conn = getConnection();
			pstmt= conn.prepareStatement(sqlbase);
			pstmt.setInt(1, patient_no);
			pstmt.setInt(2, chart_no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				rsDia.setChart_date(rs.getDate("chart_date"));
				rsDia.setChart_disease(rs.getString("chart_disease"));
				rsDia.setChart_no(rs.getInt("chart_no"));
				rsDia.setChart_symptom(rs.getString("chart_symptom"));
				rsDia.setDoctor_no(rs.getInt("doctor_no"));
				rsDia.setPatient_no(rs.getInt("patient_no"));
				rsDia.setDoctor_name(rs.getString("Doctor_name"));
				rsDia.setDepartment(rs.getString("Department"));
			}
		}catch (Exception e) {
			System.out.println("DiaHistory.historyList e.getMessage ==> " + e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return rsDia;
	}
	public int diaDel(int patient_no, int chart_no) throws SQLException {
		int result=0;
		Connection conn			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		String sql				= "DELETE diahistory WHERE patient_no=? AND chart_no=?";
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, patient_no);
			pstmt.setInt(2, chart_no);
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("DiaHistory.diaHistoryDel e.getMessage ==> " + e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}
	public int diaMod(String patient_no, String chart_no, String chart_symptom, String chart_disease) throws SQLException {
		int result = 0;
		Connection conn			= null;
		PreparedStatement pstmt	= null;
		String sqlbase			= "UPDATE diahistory SET chart_symptom=?, chart_disease=? WHERE chart_no=? AND patient_no=?";
		try {
			conn = getConnection();
			pstmt= conn.prepareStatement(sqlbase);
			pstmt.setString(1, chart_symptom);
			pstmt.setString(2, chart_disease);
			pstmt.setString(3, chart_no);
			pstmt.setString(4, patient_no);
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("DiaHistory.diaMod e.getMessage ==> " + e.getMessage());
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}
}
