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
	
	public  List<Schedule> list() throws SQLException {
		List<Schedule> list = new ArrayList<Schedule>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		String sql = "select * from schedule";
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
		int schedule_no = schedule.getSchedule_no();
		Connection conn = null;
		PreparedStatement pstmt = null;	
		int result =0;
		ResultSet rs = null;
	
		String sql1 = "select nvl(max(schedule_no),0) from schedule";	
		String sql = "insert into schedule values(?,?,?,?,?,?)";
	
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql1);
			rs= pstmt.executeQuery();
			rs.next();
			int schedule_no = rs.getInt(1)+1;
			rs.close();
			pstmt.close();
			pstmt.setInt(1, schedule.getSchedule_no());
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

			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		    return result;
	}
	
	
	
		
}
