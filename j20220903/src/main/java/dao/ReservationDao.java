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
					reservation.setPatient_no(rs.getString(4));
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
					reservation.setPatient_no(rs.getString(4));
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
