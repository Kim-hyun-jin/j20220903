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

public class ReservationDao {
	private static ReservationDao instance;
	private ReservationDao() {}	
	
	public static ReservationDao getInstance() {
		if(instance==null) {
			instance = new ReservationDao();
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
	
	public int getTotalCnt() throws SQLException {
		Connection conn = null;
		Statement stmt = null; 
		ResultSet rs = null;
		int tot = 0;
		String sql = "select count(*) from reservation order by reservation_date";
		System.out.println("Dao getTotalCnt sql-->"+sql);
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) tot = rs.getInt(1);
			System.out.println("Dao getTotalCnt totCnt-->"+tot);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null) conn.close();
		}
		return tot;
	}

	public List<Reservation> reservationList(int startRow, int endRow) throws SQLException {
		List<Reservation> list = new ArrayList<Reservation>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from reservation order by reservation_date";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, startRow);
			//pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					Reservation reservation = new Reservation();
					reservation.setReservation_date(rs.getString("reservation_date"));
					reservation.setReservation_hour(rs.getString("reservation_hour"));
					reservation.setDoctor_no(rs.getString("doctor_no"));
					reservation.setPatient_no(rs.getInt("patient_no"));
					list.add(reservation);
				} while(rs.next());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
			return list;
	}
	public Reservation select(String reservation_date) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from reservation order by reservation_date=";
		Reservation reservation = new Reservation();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				reservation.setReservation_date(rs.getString("reservation_date"));
				reservation.setReservation_hour(rs.getString("reservation_hour"));
				reservation.setDoctor_no(rs.getString("doctor.no"));
				reservation.setPatient_no(rs.getInt("patient_no"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		}
		return reservation;
	}
	public int delete(String reservation_date, String reservation_hour, String doctor_no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "delete from reservation where reservation_date=? and reservation_hour=? and doctor_no=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reservation_date);
			pstmt.setString(2, reservation_hour);
			pstmt.setString(3, doctor_no);
			result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("삭제가 되었습니다.");
			} else {
				System.out.println("삭제 실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("delete error msg-->" + e.getMessage());
		} finally {

			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}
	public List<Reservation> reserList(String res_date, String res_hour, String doctor_no) throws SQLException {
		List<Reservation> list = new ArrayList<Reservation>();
		Connection conn			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		String sql				= "SELECT * FROM reservation WHERE reservation_date=? AND reservation_hour=? AND doctor_no=?";
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, res_date);
			pstmt.setString(2, res_hour);
			pstmt.setString(3, doctor_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					Reservation reservation = new Reservation();
					reservation.setReservation_date(rs.getString(1));
					reservation.setReservation_hour(rs.getString(2));
					reservation.setDoctor_no(rs.getString(3));
					reservation.setPatient_no(rs.getInt(4));
					list.add(reservation);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("ReservationDao reserList() e.getMessage --> "+e.getMessage());
		} finally {
			if(rs	!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn	!=null) conn.close();
		}
		
		
		return list;
	}
	public List<Reservation> reserList(String res_date) throws SQLException {
		List<Reservation> list = new ArrayList<Reservation>();
		Connection conn			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		String sql				= "SELECT * FROM reservation WHERE reservation_date=?";
		String sqlif			= "SELECT * FROM reservation ORDER BY reservation_date";
		
		try {
			conn=getConnection();
			if (res_date=="") {
				pstmt=conn.prepareStatement(sqlif);
			} else {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, res_date);
			}
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					Reservation reservation = new Reservation();
					reservation.setReservation_date(rs.getString(1));
					reservation.setReservation_hour(rs.getString(2));
					reservation.setDoctor_no(rs.getString(3));
					reservation.setPatient_no(rs.getInt(4));
					list.add(reservation);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("ReservationDao reserList() e.getMessage --> "+e.getMessage());
		} finally {
			if(rs	!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn	!=null) conn.close();
		}
		
		
		return list;
	}

}
