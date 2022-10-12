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


	public class ScheduleDao {
		private static ScheduleDao instance;
		private ScheduleDao() {}	
		public static ScheduleDao getInstance() {
			if(instance==null) {
				instance = new ScheduleDao();
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
		
	public  List<Schedule> list(String doctor_no) throws SQLException {
		List<Schedule> list = new ArrayList<Schedule>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		String sql = "select * from schedule where doctor_no="+doctor_no;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				do{
					Schedule schedule= new Schedule();
					schedule.setDoctor_no(rs.getString("doctor_no"));
					schedule.setSchedule_no(rs.getInt("schedule_no"));
					schedule.setSchedule_title(rs.getString("schedule_title"));
					schedule.setSchedule_startdate(rs.getString("schedule_startdate"));
					schedule.setSchedule_enddate(rs.getString("schedule_enddate"));
					schedule.setSchedule_content(rs.getString("schedule_content"));
					list.add(schedule);
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
	
	public  Schedule select(int schedule_no) throws SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;		
		String sql = "select * from schedule where schedule_no="+schedule_no;
		Schedule schedule = new Schedule();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
					schedule.setSchedule_no(rs.getInt("schedule_no"));
					schedule.setDoctor_no(rs.getString("doctor_no"));
					schedule.setSchedule_title(rs.getString("schedule_title"));
					schedule.setSchedule_startdate(rs.getString("schedule_startdate"));
					schedule.setSchedule_enddate(rs.getString("schedule_enddate"));
					schedule.setSchedule_content(rs.getString("schedule_content"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		}
		    return schedule;
	}
	
	public  int insert(Schedule schedule) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;	
		int result =0;
		ResultSet rs = null;
		String sql1 = "select nvl(max(schedule_no),0) from schedule";	
		String sql = "insert into schedule values(?,?,?,?,?,?)";
	
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			rs.next();
			int number = rs.getInt(1) + 1; 
			rs.close();   
			pstmt.close();	
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, schedule.getDoctor_no());
			pstmt.setString(3, schedule.getSchedule_title());
			pstmt.setString(4, schedule.getSchedule_startdate());	
			pstmt.setString(5, schedule.getSchedule_enddate());		
			pstmt.setString(6, schedule.getSchedule_content());	
			result = pstmt.executeUpdate();
			System.out.println("insert result="+result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			
			if (rs !=null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		    return result;
	}
	
	public  int update(Schedule schedule) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;	
		int result = 0;	
		String sql="update schedule set doctor_no=?,schedule_title=?,schedule_startdate=?,"+
            	"schedule_enddate=?,schedule_content=? where schedule_no=?";
	
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schedule.getDoctor_no());
			pstmt.setString(2, schedule.getSchedule_title());
			pstmt.setString(3, schedule.getSchedule_startdate());	
			pstmt.setString(4, schedule.getSchedule_enddate());		
			pstmt.setString(5, schedule.getSchedule_content());	
			pstmt.setInt(6, schedule.getSchedule_no());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		    return result;
	}
	
	public  int delete(int schedule_no ) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;	
		int result = 0;	
		String sql="delete from schedule where schedule_no=?";		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, schedule_no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		    return result;
	}
	
	public  List<Schedule> getTodoList(String doctor_no) throws SQLException {
		List<Schedule> todoList = new ArrayList<Schedule>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		String sql = "SELECT SCHEDULE_STARTDATE,SCHEDULE_TITLE\r\n"
						+ "FROM SCHEDULE\r\n"
						+ "WHERE SCHEDULE_STARTDATE=TO_CHAR(SYSDATE,'YYYY-MM-DD')\r\n"
						+ "AND DOCTOR_NO="+doctor_no;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(rs);
			if(rs.next()){
				do{
					Schedule schedule= new Schedule();
					schedule.setSchedule_title(rs.getString("schedule_title"));
					schedule.setSchedule_startdate(rs.getString("schedule_startdate"));
					todoList.add(schedule);
				 } while(rs.next());
		
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		    return todoList;
	}
	
	public  List<Schedule> getReservationlist(String doctor_no) throws SQLException {
		List<Schedule> reservationList = new ArrayList<Schedule>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		String sql = "SELECT TO_CHAR(TO_DATE(RESERVATION.RESERVATION_DATE,'YY/MM/DD'),'YYYY-MM-DD') AS RESERVATION_DATE,PATIENT.PATIENT_NAME\r\n"
						+ "FROM RESERVATION,PATIENT\r\n"
						+ "WHERE RESERVATION.PATIENT_NO=PATIENT.PATIENT_NO\r\n"
						+ "AND TO_CHAR(TO_DATE(RESERVATION.RESERVATION_DATE,'YY/MM/DD'),'YY/MM/DD')=TO_CHAR(SYSDATE,'YY/MM/DD')\r\n"
						+ "AND RESERVATION.DOCTOR_NO="+doctor_no;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				do{
					Schedule schedule= new Schedule();
					schedule.setReservation_date(rs.getString("reservation_date"));
					schedule.setPatient_name(rs.getString("patient_name"));
					reservationList.add(schedule);
				 } while(rs.next());
		
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		    return reservationList;
	}
	
	
		
}

