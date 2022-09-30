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

public class PatientDao {
	private static PatientDao instance;
	private PatientDao() {}	
	public static PatientDao getInstance() {
		if(instance==null) {
			instance = new PatientDao();
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
	public List<Patient> patientSearch(String department, String doctorName, String reservationDate, String patientName) throws SQLException {
		
		List<Patient> list = new ArrayList<Patient>();
		List<Patient> list_result = new ArrayList<Patient>();
		Connection conn			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
//		int i=2;
//		int j=1;
//		String sqlbase			= 						   "SELECT p.* FROM patient p";
//		if (department!="*")		sqlbase=sqlbase.concat(", (select * from doctor where department=?) d"); j++; i=i*3;
//		if (doctorName!="*")		sqlbase=sqlbase.concat(", (select * from doctor where doctor_name=?) dd"); j++; i=i*5;
//		if (reservationDate!="*")	sqlbase=sqlbase.concat(", (select * from reservation where reservation_date=?) r"); j++; i=i*7;
//									sqlbase=sqlbase.concat(" WHERE p.patient_name like ?");
//		if (department!="*")		sqlbase=sqlbase.concat(" AND p.patient_no = r.patient_no");
//		if (doctorName!="*")		sqlbase=sqlbase.concat(" AND p.doctor_no=dd.doctor_no");
//		if (reservationDate!="*")	sqlbase=sqlbase.concat(" AND p.doctor_no=d.doctor_no");
//		System.out.println(sqlbase);
		String sqlbase			= 						   "SELECT p.* FROM patient p, (select * from doctor where department like ?) d, "
				+ "(select * from doctor where doctor_name like ?) dd, (select * from reservation where reservation_date like ?) r "
				+ "WHERE p.patient_name like ? AND p.doctor_no=dd.doctor_no AND p.doctor_no=d.doctor_no";
		if (reservationDate!="") sqlbase=sqlbase.concat(" AND p.patient_no = r.patient_no");
		System.out.println(sqlbase);
		try {
			conn = getConnection();
			pstmt= conn.prepareStatement(sqlbase);
			pstmt.setString(1, "%"+department+"%");
			pstmt.setString(2, "%"+doctorName+"%");
			pstmt.setString(3, "%"+reservationDate+"%");
			pstmt.setString(4, "%"+patientName+"%");
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					Patient patient = new Patient();
					patient.setAddress(rs.getString("address"));
					patient.setBirth(rs.getString("Birth"));
					patient.setContact(rs.getString("Contact"));
					patient.setDoctor_no(rs.getString("Doctor_no"));
					patient.setGender(rs.getString("Gender"));
					patient.setPatient_name(rs.getString("Patient_name"));
					patient.setPatient_no(rs.getInt("Patient_no"));
					patient.setProtector_contact(rs.getString("Protector_contact"));
					patient.setSocial_number(rs.getString("Social_number"));
					list.add(patient);
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
	public List<Patient> patientSearch(String patientName) throws SQLException {
		List<Patient> list = new ArrayList<Patient>();

		Connection conn			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		String sql				= "select * from patient where patient_name like ?";
		
		try {
			conn = getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, "%"+patientName+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					Patient patient = new Patient();
					patient.setAddress(rs.getString("address"));
					patient.setBirth(rs.getString("birth"));
					patient.setContact(rs.getString("contact"));
					patient.setGender(rs.getString("Gender"));
					patient.setPatient_name(rs.getString("Patient_name"));
					patient.setPatient_no(rs.getInt("Patient_no"));
					patient.setProtector_contact(rs.getString("Protector_contact"));
					patient.setSocial_number(rs.getString("Social_number"));
					patient.setDoctor_no(rs.getString("Doctor_no"));
					list.add(patient);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("PatienDao patientSearch() e.getMessage --> "+e.getMessage());
		} finally {
			if(rs	!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn	!=null) conn.close();
		}
		
		return list;
	}
	public ArrayList<ArrayList<String>> searchSet(String department, String doctorName, String reservationDate,
			String patientName) throws SQLException {
		
		ArrayList<ArrayList<String>> resultset = new ArrayList<ArrayList<String>>();
		Connection conn			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		String sqlbase			= 
					  "SELECT * "
					+ "FROM patient p, "
					+ "(select * from doctor where department like ?) d, "
					+ "(select * from doctor where doctor_name like ?) dd, "
					+ "(select * from reservation where reservation_date like ?) r "
					+ "WHERE p.patient_name like ? "
					+ "AND p.doctor_no=dd.doctor_no "
					+ "AND p.doctor_no=d.doctor_no";
		
		if (reservationDate!="") sqlbase=sqlbase.concat(" AND p.patient_no = r.patient_no");
		
		try {
			conn = getConnection();
			pstmt= conn.prepareStatement(sqlbase);
			pstmt.setString(1, "%"+department+"%");
			pstmt.setString(2, "%"+doctorName+"%");
			pstmt.setString(3, "%"+reservationDate+"%");
			pstmt.setString(4, "%"+patientName+"%");
			
			rs=pstmt.executeQuery();
			
			ArrayList<ArrayList<String>> set = new ArrayList<ArrayList<String>>();
			
			if(rs.next()) {
				do {
					ArrayList<String> setlist = new ArrayList<String>();
					setlist.add(rs.getString("Patient_no"));
					setlist.add(rs.getString("Doctor_no"));
					setlist.add(rs.getString("doctor_name"));
					setlist.add(rs.getString("department"));
					setlist.add(rs.getString("reservation_date"));
					set.add(setlist);
				} while (rs.next());
			}
			
			resultset.add(set.get(0));
			for(int i=1; i<set.size(); i++) {
				if(set.get(i).get(1)!=set.get(i-1).get(1)) {
					resultset.add(set.get(i));
				}
			}
			
		} catch (Exception e) {
			System.out.println("check error -> " + e.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return resultset;
	}
}
