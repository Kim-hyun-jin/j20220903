package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DrugDao {
	private static DrugDao instance;

	private DrugDao() {
	}

	public static DrugDao getInstance() {
		if (instance == null) {
			instance = new DrugDao();
		}
		return instance;
	}

	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public int getCnt(String drug_name, String drug_class) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT COUNT(drug_name)\r\n"
					+ "FROM (\r\n"
					+ "		SELECT * FROM drug WHERE drug_name LIKE ? ORDER BY drug_code ASC\r\n"
					+ ")";
		
		if (drug_class.equals("shot")) {
			sql = "SELECT COUNT(drug_name)\r\n"
					+ "FROM (\r\n"
					+ "		SELECT * FROM drug WHERE drug_name LIKE ? AND drug_class='주사제' ORDER BY drug_code ASC\r\n"
					+ ")";
		} else if (drug_class.equals("soft")) {
			sql = "SELECT COUNT(drug_name)\r\n"
					+ "FROM (\r\n"
					+ "		SELECT * FROM drug WHERE drug_name LIKE ? AND drug_class='경질캡슐' ORDER BY drug_code ASC\r\n"
					+ ")";
		} else if (drug_class.equals("liquid")) {
			sql = "SELECT COUNT(drug_name)\r\n"
					+ "FROM (\r\n"
					+ "		SELECT * FROM drug WHERE drug_name LIKE ? AND drug_class='액제' ORDER BY drug_code ASC\r\n"
					+ ")";
		} else;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+drug_name+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println("getTotalCnt error -> " + e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}
	
	public List<Drug> drugList(String drug_name, String drug_class, int startRow, int endRow) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Drug> list = new ArrayList<Drug>();
		String sql = "SELECT *\r\n"
				+ "FROM (\r\n"
				+ "    SELECT ROWNUM rn, a.*\r\n"
				+ "    FROM (SELECT * FROM drug WHERE drug_name LIKE ? ORDER BY drug_code ASC) a\r\n"
				+ "    )\r\n"
				+ "WHERE rn BETWEEN ? and ?";
		
		if (drug_class.equals("shot")) {
			sql = "SELECT *\r\n"
					+ "FROM (\r\n"
					+ "    SELECT ROWNUM rn, a.*\r\n"
					+ "    FROM (SELECT * FROM drug WHERE drug_name LIKE ? AND drug_class='주사제' ORDER BY drug_code ASC) a\r\n"
					+ "    )\r\n"
					+ "WHERE rn BETWEEN ? and ?";
		} else if (drug_class.equals("soft")) {
			sql = "SELECT *\r\n"
					+ "FROM (\r\n"
					+ "    SELECT ROWNUM rn, a.*\r\n"
					+ "    FROM (SELECT * FROM drug WHERE drug_name LIKE ? AND drug_class='경질캡슐' ORDER BY drug_code ASC) a\r\n"
					+ "    )\r\n"
					+ "WHERE rn BETWEEN ? and ?";
		} else if (drug_class.equals("liquid")) {
			sql = "SELECT *\r\n"
					+ "FROM (\r\n"
					+ "    SELECT ROWNUM rn, a.*\r\n"
					+ "    FROM (SELECT * FROM drug WHERE drug_name LIKE ? AND drug_class='액제' ORDER BY drug_code ASC) a\r\n"
					+ "    )\r\n"
					+ "WHERE rn BETWEEN ? and ?";
		} else;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+drug_name+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					Drug drug = new Drug();
					drug.setDrug_code(rs.getInt("drug_code"));
					drug.setDrug_class(rs.getString("drug_class"));
					drug.setDrug_name(rs.getString("drug_name"));
					list.add(drug);
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
	@SuppressWarnings("finally")
	public ArrayList<Drug> drugListAll() throws SQLException {
		ArrayList<Drug> drug = new ArrayList<Drug>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql = "SELECT * FROM DRUG";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				do {
					Drug dr = new Drug();
					dr.setDrug_class(rs.getString("drug_class"));
					dr.setDrug_code(rs.getInt("drug_code"));
					dr.setDrug_name(rs.getString("drug_name"));
					drug.add(dr);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("drugListAll error -> " + e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		return drug;
		}
	}
}
