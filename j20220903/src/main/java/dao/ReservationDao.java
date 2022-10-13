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

	public List<Reservation2> reservationList(int startRow, int endRow) throws SQLException {
		List<Reservation2> list = new ArrayList<Reservation2>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//String sql = "select * from reservation order by reservation_date";
		String sql = "select p.patient_name, d.doctor_name, d.doctor_no, d.department, r.reservation_date, r.reservation_hour from patient p, reservation r, doctor d "
				+ "where p.patient_no = r.patient_no and r.doctor_no = d.doctor_no order by reservation_date";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, startRow);
			//pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					Reservation2 reservation = new Reservation2();
					reservation.setReservation_date(rs.getString("reservation_date"));
					reservation.setReservation_hour(rs.getString("reservation_hour"));
					reservation.setDoctor_no(rs.getString("doctor_no"));
//					reservation.setPatient_no(rs.getInt("patient_no"));
					reservation.setPatient_name(rs.getString("patient_name"));
					reservation.setDoctor_name(rs.getString("doctor_name"));
					reservation.setDepartment(rs.getString("department"));
					
					
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
//			if(result > 0) {
//				JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
//			} else {
//				JOptionPane.showMessageDialog(null, "삭제 실패하였습니다.");
//			}
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
	
	public List<Reservation2> reservationInfoSearch(String patientName) throws SQLException {
		
		List<Reservation2> list = new ArrayList<Reservation2>();
		List<Reservation2> list_result = new ArrayList<Reservation2>();
		Connection conn			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
//		String sqlbase			= 						   "SELECT p.* FROM patient p, (select * from doctor where department like ?) d, "
//				+ "(select * from doctor where doctor_name like ?) dd, (select * from reservation where reservation_date like ?) r "
//				+ "WHERE p.patient_name like ? AND p.doctor_no=dd.doctor_no AND p.doctor_no=d.doctor_no";
		
		
//		String sqlbase	= 	"select p.*, d.*, r.* from (select * from patient) p ,(select * from doctor) d , (select * from reservation ) r"
//				+ " WHERE p.patient_name like ? AND p.doctor_no=d.doctor_no and r.doctor_no = d.doctor_no ";
		
		String sqlbase	= 	"select "
				+ " a.PATIENT_NO,"
				+ " a.PATIENT_NAME,"
		    + " a.GENDER,"
		    + " a.BIRTH,"
		   + "  a.ADDRESS,"
		    + " a.DOCTOR_NO,"
		    + " b.DOCTOR_NAME,"
		    + " b.DEPARTMENT"
		    + " from patient a  left join doctor b "
		    + " on a.doctor_no=b.doctor_no "
		    + " where a.patient_name like ?";

		 
		System.out.println(sqlbase);
		try {
			conn = getConnection();
			pstmt= conn.prepareStatement(sqlbase);
			pstmt.setString(1, "%"+patientName+"%");
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					Reservation2 info = new Reservation2();
//					info.setReservation_date(rs.getString("Reservation_date"));
//					info.setReservation_hour(rs.getString("Reservation_hour"));
//					info.setDoctor_no(rs.getString("Doctor_no"));
					info.setPatient_no(rs.getInt("Patient_no"));
					info.setPatient_name(rs.getString("Patient_name"));
//					info.setDoctor_name(rs.getString("Doctor_name"));
//					info.setDepartment(rs.getString("Department"));
					info.setGender(rs.getString("Gender"));
					info.setBirth(rs.getString("Birth"));
					info.setAddress(rs.getString("address"));
					list.add(info);
				} while (rs.next());
			}
			list_result.add(list.get(0));
			for(int i=1; i<list.size(); i++) {
				if(list.get(i).getPatient_no()!=list.get(i-1).getPatient_no()) {
					list_result.add(list.get(i));
				} else System.out.println("중복제거");
			}
		} catch (Exception e) {
			System.out.println("check error -> " + e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return list_result;
	}
	public List<Reservation2> doctorInfo(String doctorName) throws SQLException {
		
		List<Reservation2> list = new ArrayList<Reservation2>();
		List<Reservation2> list_result = new ArrayList<Reservation2>();
		Connection conn			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		
		String sqlbase	= 	"select DISTINCT d.doctor_name, d.doctor_no from doctor d, reservation r where d.doctor_no = r.doctor_no";
		
		
		System.out.println(sqlbase);
		try {
			conn = getConnection();
			pstmt= conn.prepareStatement(sqlbase);
			pstmt.setString(1, "doctorName");
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					Reservation2 doctorinfo = new Reservation2();
//					info.setReservation_date(rs.getString("Reservation_date"));
//					info.setReservation_hour(rs.getString("Reservation_hour"));
					doctorinfo.setDoctor_no(rs.getString("Doctor_no"));
//					info.setPatient_no(rs.getInt("Patient_no"));
//					info.setPatient_name(rs.getString("Patient_name"));
					doctorinfo.setDoctor_name(rs.getString("Doctor_name"));
//					info.setDepartment(rs.getString("Department"));
//					info.setGender(rs.getString("Gender"));
//					info.setBirth(rs.getString("Birth"));
//					info.setAddress(rs.getString("address"));
					list.add(doctorinfo);
				} while (rs.next());
			}
			list_result.add(list.get(0));
			for(int i=1; i<list.size(); i++) {
				if(list.get(i).getPatient_no()!=list.get(i-1).getPatient_no()) {
					list_result.add(list.get(i));
				} else System.out.println("중복제거");
			}
		} catch (Exception e) {
			System.out.println("check error -> " + e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return list_result;
	}
	public int insert(Reservation2 reservation21) throws SQLException {
		int patient_no = reservation21.getPatient_no();
		System.out.println("patient_no->"+patient_no);
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		String sql = "insert into reservation values(?,?,?,?)";
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql);
			System.out.println("sQL->"+sql);
			if(patient_no != 0) { 

			pstmt.setString(1, reservation21.getReservation_date());
			System.out.println(111);
			pstmt.setString(2, reservation21.getReservation_hour());
			System.out.println(222);
			pstmt.setString(3, reservation21.getDoctor_no());
			System.out.println(333);
			pstmt.setInt(4, reservation21.getPatient_no());
			System.out.println(444);
				
			}
			result=pstmt.executeUpdate();
			System.out.println("RESULT -> " + result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			if(pstmt !=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		return result;
	} 
	


}
