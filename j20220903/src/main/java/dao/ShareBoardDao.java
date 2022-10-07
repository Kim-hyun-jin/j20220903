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
	// 1.shareBoard 객체를 리스트로 담음 
		List<ShareBoard> list = new ArrayList<ShareBoard>();
		Connection conn = null;	
		PreparedStatement pstmt= null;
		ResultSet rs = null;
//		String sql = "SELECT *  "
//	 	    	+ "FROM (Select rownum rn ,a.*  From shareboard a  order by a.shareboard_no desc )"
//	 		    + "WHERE rn BETWEEN ? AND ? " ;
		
		String sql = "SELECT new_shareboard_rn.* "
					+ " FROM "
					+ " ( "
					+ "    SELECT new_shareboard.*,  rownum rn "
					+ "    FROM "
					+ "    (   SELECT "
					+ "            sb.*, dt.doctor_name "
					+ "        FROM shareboard sb, "
					+ "             doctor dt "
					+ "        WHERE sb.doctor_no = dt.doctor_no "
					+ "        ORDER BY sb.shareboard_no DESC"
					+ "    ) new_shareboard "
					+ " ) new_shareboard_rn "
					+ " WHERE new_shareboard_rn.rn BETWEEN ? AND ? ";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ShareBoard shareBoard = new ShareBoard();
				shareBoard.setDoctor_name(rs.getString("doctor_name"));
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
	
	public ShareBoard select(int shareboard_no ) throws SQLException {
		Connection conn = null;	
		PreparedStatement pstmt= null;

		ResultSet rs = null;
		/*
		 * String sql = "select * from shareboard where shareboard_no="+ shareboard_no;
		 */
		/*String sql = " select sb.*, dt.doctor_name "
				+ " from shareboard sb, doctor dt "
				+ " where sb.doctor_no = dt.doctor_no "
				+ " ORDER BY sb.shareboard_no DESC ";*/
		
		String sql = " select sb.*, dt.doctor_name "
				+ "            from shareboard sb "
				+ "             join doctor dt "
				+ "             on sb.doctor_no = dt.doctor_no "
				+ "             where sb.shareboard_no =? " ;
		
		System.out.println("ShareBoardDao select sql->"+sql);
		
		
		
		ShareBoard board = new ShareBoard();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shareboard_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				board.setDoctor_name(rs.getString("doctor_name"));
				board.setDoctor_no(rs.getString("doctor_no"));
				board.setShareBoard_content(rs.getString("shareBoard_content"));
				board.setShareBoard_date(rs.getDate("shareBoard_date"));
				board.setShareBoard_no(rs.getInt("shareBoard_no"));
				board.setShareBoard_subject(rs.getString("shareBoard_subject"));
				System.out.println("ShareBoardDao select doctor_name->"+rs.getString("doctor_name"));
			
			}
		} catch(Exception e) {	
			System.out.println(e.getMessage()); 
		} finally {
			if (rs !=null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn !=null) conn.close();
		}
		return board;
	}
	
	public int insert(ShareBoard shareboard) throws SQLException {
			  Connection conn  = null;
		      PreparedStatement pstmt = null;
		      int result = 0;
		      ResultSet rs = null;
		      
				/* String sql1 = "SELECT nvl(max(), 0) FROM shareboard"; */
		      String sql = "INSERT INTO SHAREBOARD VALUES(shareboard_seq.NEXTVAL,?,?,to_date(sysdate),?)";
		      		
		      try {
		         conn = getConnection();
		         pstmt = conn.prepareStatement(sql);		         
		         // key인 num 1씩 증가, mysql auto_increment / oracle sequence
		         // sequence 사용 : VALUES(시퀀스명(board_seq).nextval,?,?...)
		         pstmt.setString(1, shareboard.getShareBoard_subject());
		         pstmt.setString(2, shareboard.getShareBoard_content()); 
		         pstmt.setString(3, shareboard.getDoctor_no());
		    
		         result = pstmt.executeUpdate();
		         
		      } catch (Exception e) {
		         System.out.println(e.getMessage());
		      } finally {
		         if (rs != null)      rs.close();
		         if (pstmt != null) pstmt.close();
		         if (conn !=null)   conn.close();
		      }
		      return result;
		   }
	 public int update(ShareBoard shareboard) throws SQLException {

	      Connection conn  = null;
	      PreparedStatement pstmt = null;
	      int result = 0;
	      
	      String sql =" update shareboard set "
	      			+ " ShareBoard_subject=?, "
	      			+ " ShareBoard_content=? "
	      			+ "where shareboard_no=? ";
	           
	      
	      try {
	         conn = getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, shareboard.getShareBoard_subject());
	         pstmt.setString(2, shareboard.getShareBoard_content());
	         pstmt.setInt(3, shareboard.getShareBoard_no());

	         result =  pstmt.executeUpdate();
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      } finally {
	         if (pstmt != null) pstmt.close();
	         if (conn !=null)   conn.close();
	      }
	      return result;
     
  }
	public int delete(int shareBoard_no) {
		int result  = 0;  
		Connection conn = null;
		PreparedStatement pstmt = null; 
		String sql  = "delete from shareboard where shareboard_no=?"; 	
		try { 
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shareBoard_no);
			result = pstmt.executeUpdate();
		} catch(Exception e) { 
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}
}

	
