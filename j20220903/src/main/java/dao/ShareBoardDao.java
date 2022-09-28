package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ShareBoardDao {
	private static ShareBoardDao instance;
	
	private ShareBoardDao() {}
	public static ShareBoardDao getInstance() {
		if (instance == null) {	
			instance = new ShareBoardDao();	
		}
		return instance;
	}
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)
				ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		}catch(Exception e) { 
			System.out.println(e.getMessage());	
		}
		return conn;
		
	}
	
	public int getTotalCnt() throws SQLException {
		Connection conn = null;	
		Statement stmt= null; 
		ResultSet rs = null;    
		int tot = 0;
		String sql = "select count(*) from shareboard";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) tot = rs.getInt(1);
		} catch(Exception e) {	
			System.out.println(e.getMessage()); 
		} finally {
			if (rs !=null) rs.close();
			if (stmt != null) stmt.close();
			if (conn !=null) conn.close();
		}
		return tot;
	}
	
	public List<ShareBoard> shareBoardList(int startRow, int endRow) throws SQLException {
		List<ShareBoard> list = new ArrayList<ShareBoard>();
		Connection conn = null;	
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String sql = "SELECT *  "
	 	    	+ "FROM (Select rownum rn ,a.*  From shareboard a)"
	 		    + "WHERE rn BETWEEN ? AND ? " ;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ShareBoard shareBoard = new ShareBoard();
				shareBoard.setDoctor_no(rs.getString("doctor_no"));
				shareBoard.setShareBoard_content(rs.getString("shareBoard_content"));
				shareBoard.setShareBoard_no(rs.getInt("shareBoard_no"));
				shareBoard.setShareBoard_subject(rs.getString("shareBoard_subject"));
				shareBoard.setShareBoard_date(rs.getDate("shareBoard_date"));
				list.add(shareBoard);
			}
		} catch(Exception e) {	
			System.out.println(e.getMessage()); 
		} finally {
			if (rs !=null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn !=null) conn.close();
		} 
		return list;
	}
}