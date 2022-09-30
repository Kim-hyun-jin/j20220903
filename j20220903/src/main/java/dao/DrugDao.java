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
	
	public List<Drug> drugList(String drug_name, String drug_class) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Drug> list = new ArrayList<Drug>();
		String sql = "SELECT * FROM drug WHERE drug_name LIKE ? ORDER BY drug_code ASC";
		
		if (drug_class.equals("shot")) {
			sql = "SELECT * FROM drug WHERE drug_name LIKE ? AND drug_class='주사제' ORDER BY drug_code ASC";
		} else if (drug_class.equals("soft")) {
			sql = "SELECT * FROM drug WHERE drug_name LIKE ? AND drug_class='경질캡슐' ORDER BY drug_code ASC";
		} else if (drug_class.equals("liquid")) {
			sql = "SELECT * FROM drug WHERE drug_name LIKE ? AND drug_class='액제' ORDER BY drug_code ASC";
		} else;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setString(1, "%"+drug_name+"%");
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
}
