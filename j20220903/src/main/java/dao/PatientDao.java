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

	private PatientDao() {
	}

	public static PatientDao getInstance() {
		if (instance == null) {
			instance = new PatientDao();
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

	// 환자관리
	public List<Patient> selectAll(String doctor_no) throws SQLException {

		List<Patient> list = new ArrayList<Patient>();
		String sql = "select * from patient where doctor_no=? ORDER BY patient_no asc";

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, doctor_no);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					Patient patient = new Patient();

					patient.setAddress(rs.getString("address"));
					patient.setBirth(rs.getString("birth"));
					patient.setContact(rs.getString("contact"));

					patient.setGender(rs.getString("gender"));
					patient.setPatient_name(rs.getString("patient_name"));
					patient.setPatient_no(rs.getInt("patient_no"));
					patient.setProtector_contact(rs.getString("protector_contact"));
					patient.setSocial_number(rs.getString("social_number"));
					list.add(patient);

				} while (rs.next());
			}
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("selectAll rs까지 Err: " + e.getMessage());

		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (connection != null)
				connection.close();
		}

		return list;
	}

	public List<Patient> patientSearch(String department, String doctorName, String reservationDate, String patientName)
			throws SQLException {

		List<Patient> list = new ArrayList<Patient>();
		List<Patient> list_result = new ArrayList<Patient>();
		Connection conn			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		String sqlbase			= 
				  "SELECT *\r\n"
				  + "FROM patient p\r\n"
				  + "INNER JOIN (select * from doctor where department like ?) dd ON p.doctor_no=dd.doctor_no\r\n"
				  + "INNER JOIN (select * from doctor where doctor_name like ?) d ON p.doctor_no=d.doctor_no\r\n"
				  + "LEFT JOIN (select * from reservation where reservation_date like ?) r ON p.patient_no=r.patient_no\r\n"
				  + "WHERE p.patient_name like ?"
				  + "ORDER BY p.patient_no";
		String sqlbase2			= 
				"SELECT *\r\n"
						+ "FROM patient p\r\n"
						+ "INNER JOIN (select * from doctor where department like ?) dd ON p.doctor_no=dd.doctor_no\r\n"
						+ "INNER JOIN (select * from doctor where doctor_name like ?) d ON p.doctor_no=d.doctor_no\r\n"
						+ "INNER JOIN (select * from reservation where reservation_date like ?) r ON p.patient_no=r.patient_no\r\n"
						+ "WHERE p.patient_name like ?"
						+ "ORDER BY p.patient_no";
		try {
			conn = getConnection();
			if(!reservationDate.equals("")) pstmt = conn.prepareStatement(sqlbase2);
			else pstmt= conn.prepareStatement(sqlbase);
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
			System.out.println("listSize==>"+list.size());
			list_result.add(list.get(0));
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i).getPatient_no() != list.get(i - 1).getPatient_no()) {
					list_result.add(list.get(i));
				} else
					System.out.println("중복제거");
			}
		} catch (Exception e) {
			System.out.println("check error -> " + e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
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
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
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
				  "SELECT *\r\n"
				  + "FROM patient p\r\n"
				  + "INNER JOIN (select * from doctor where department like ?) dd ON p.doctor_no=dd.doctor_no\r\n"
				  + "INNER JOIN (select * from doctor where doctor_name like ?) d ON p.doctor_no=d.doctor_no\r\n"
				  + "LEFT JOIN (select * from reservation where reservation_date like ?) r ON p.patient_no=r.patient_no\r\n"
				  + "WHERE p.patient_name like ?"
				  + "ORDER BY p.patient_no";
		String sqlbase2			= 
				"SELECT *\r\n"
						+ "FROM patient p\r\n"
						+ "INNER JOIN (select * from doctor where department like ?) dd ON p.doctor_no=dd.doctor_no\r\n"
						+ "INNER JOIN (select * from doctor where doctor_name like ?) d ON p.doctor_no=d.doctor_no\r\n"
						+ "INNER JOIN (select * from reservation where reservation_date like ?) r ON p.patient_no=r.patient_no\r\n"
						+ "WHERE p.patient_name like ?"
						+ "ORDER BY p.patient_no";
		try {
			conn = getConnection();
			if(!reservationDate.equals("")) pstmt = conn.prepareStatement(sqlbase2);
			else pstmt= conn.prepareStatement(sqlbase);
			pstmt.setString(1, "%"+department+"%");
			pstmt.setString(2, "%"+doctorName+"%");
			pstmt.setString(3, "%"+reservationDate+"%");
			pstmt.setString(4, "%"+patientName+"%");
			
			rs=pstmt.executeQuery();
			
			ArrayList<ArrayList<String>> set = new ArrayList<ArrayList<String>>();

			if (rs.next()) {
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
				if(!set.get(i).get(0).equals(set.get(i-1).get(0))) {resultset.add(set.get(i));}
				else System.out.println("searchSet 중복제거");
			}
		} catch (Exception e) {
			System.out.println("check error -> " + e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return resultset;
	}

	// 환자등록

	public int regPatient(Patient patient) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into patient (patient_no, patient_name, social_number, birth, gender, contact, protector_contact, address, doctor_no)"
				+ " values(patient_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		/*
		 * String sql =
		 * "insert into patient (patient_no, patient_name, social_number, birth, gender, contact, protector_contact, address, doctor_no)"
		 * + " values(patient_seq.NEXTVAL, '?', '?', '?', '?', '?', '?', '?', ?)";
		 */
		
				
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, patient.getPatient_name());
			pstmt.setString(2, patient.getSocial_number());
			pstmt.setString(3, patient.getBirth());
			pstmt.setString(4, patient.getGender());
			pstmt.setString(5, patient.getContact());
			pstmt.setString(6, patient.getProtector_contact());
			pstmt.setString(7, patient.getAddress());
			pstmt.setString(8, patient.getDoctor_no());
			
			//의사번호 2 대신 받기
			//pstmt.setString(8, patient.getDoctor_no());
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력실패");
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("PatientDao / regPatient Err" + e.getMessage());
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}

	/*
	 * doctor_no=2 라고 가정 public Patient select(String doctor_no, int patient_no)
	 * throws SQLException {
	 */
	public Patient selectPatient(int patient_no,String doctor_no) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// doctor_no=2 라고 가정
		String sql = "SELECT * FROM patient WHERE doctor_no = ? AND patient_no=? ";

		Patient patient = new Patient();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			// doctor_no=2 라고 가정
			// pstmt.setInt(1, doctor_no);
			// pstmt.setInt(2, patient_no);
			pstmt.setString(1, doctor_no);
			pstmt.setInt(2, patient_no);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				patient.setPatient_no(rs.getInt("patient_no"));
				patient.setPatient_name(rs.getString("patient_name"));
				patient.setSocial_number(rs.getString("social_number"));
				patient.setBirth(rs.getString("birth"));
				patient.setGender(rs.getString("gender"));
				patient.setContact(rs.getString("contact"));
				patient.setProtector_contact(rs.getString("protector_contact"));
				patient.setAddress(rs.getString("address"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return patient;
	}
	
	public List<PatientInf> getMyPatientList(String doctor_no) throws SQLException {
		
		List<PatientInf> list = new ArrayList<PatientInf>();
		
		
		Connection conn			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		
		String sql =
				"select * from (select rownum rn, n.* from\r\n"
				+ "(select d.chart_no, p.patient_name, p.gender, d.chart_symptom, d.chart_disease,d.chart_date " 
				+"from diahistory d inner join patient p on d.patient_no = p.patient_no where d.doctor_no = ? "
				+"order by d.chart_date desc) n \r\n"
				+ ")\r\n"
				+ "where rn between 1 and 5";
		//doctor_no => ?
		try {
			conn = getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, doctor_no);
			rs=pstmt.executeQuery();
			
			if(doctor_no.equals("")) {
				System.out.println("doctor_no none");
			}
			
			//2 => session
			pstmt.setString(1, "2");
			
			while(rs.next()) {
				PatientInf patientInf = new PatientInf();
				patientInf.setChart_no(rs.getInt("chart_no"));
				patientInf.setPatient_name(rs.getString("patient_name"));
				patientInf.setGender(rs.getString("gender"));
				patientInf.setChart_symptom(rs.getString("chart_symptom"));
				patientInf.setChart_disease(rs.getString("chart_disease"));
				patientInf.setChart_date(rs.getDate("chart_date"));
				list.add(patientInf);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("PatientDao  PatientInf getMyPatientList Err"+ e.getMessage());
		} finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		System.out.println("getMyPatientList 실행");
		
		return list;
	}
public int updatePatient(Patient patient) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE patient SET patient_name=?, social_number=?, birth=?, gender=?, contact=?, protector_contact=?, address=?, doctor_no=? WHERE patient_no=?";
		System.out.println("updatePatient Dao sql->" + sql);
		System.out.println("updatePatient Dao patient.getDoctor_no()->" + patient.getDoctor_no());
		System.out.println("updatePatient Dao patient.getPatient_no()->" + patient.getPatient_no());
			try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, patient.getPatient_name());
			System.out.println("updatePatient Dao patient.getPatient_name()->" + patient.getPatient_name());
			pstmt.setString(2, patient.getSocial_number());
			pstmt.setString(3, patient.getBirth());
			pstmt.setString(4, patient.getGender());
			pstmt.setString(5, patient.getContact());
			pstmt.setString(6, patient.getProtector_contact());
			pstmt.setString(7, patient.getAddress());
			pstmt.setString(8, patient.getDoctor_no());
			pstmt.setInt(9, patient.getPatient_no());
			
			result = pstmt.executeUpdate();
			System.out.println("updatePatient Dao result->" + result);
			
		} catch (Exception e) {
			System.out.println("updatePatient Dao e.getMessage->" + e.getMessage());
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		
		return result;
		
	}

public PatientInf patientInf(int patient_no) throws SQLException {
    PatientInf pi = new PatientInf();
    Connection conn         = null;
    PreparedStatement pstmt   = null;
    ResultSet rs         = null;
    String sqlbase         = 
            "SELECT *\r\n"
            + "FROM patient p\r\n"
            + "INNER JOIN (select * from doctor) dd ON p.doctor_no=dd.doctor_no\r\n"
            + "INNER JOIN (select * from doctor) d ON p.doctor_no=d.doctor_no\r\n"
            + "LEFT JOIN (select * from reservation) r ON p.patient_no=r.patient_no\r\n"
            + "WHERE p.patient_no=?";
    try {
       conn = getConnection();
       pstmt= conn.prepareStatement(sqlbase);
       pstmt.setInt(1, patient_no);
       rs=pstmt.executeQuery();
       if(rs.next()) {
          System.out.println("rs.next() true!");
          pi.setAddress(rs.getString("Address"));
          pi.setBirth(rs.getString("Birth"));
          pi.setContact(rs.getString("Contact"));
          pi.setDepartment(rs.getString("Department"));
          pi.setDoctor_name(rs.getString("Doctor_name"));
          pi.setDoctor_no(rs.getString("Doctor_no"));
          pi.setGender(rs.getString("Gender"));
          pi.setImage(rs.getString("Image"));
          pi.setPassword(rs.getInt("Password"));
          pi.setPatient_name(rs.getString("Patient_name"));
          pi.setPatient_no(rs.getInt("Patient_no"));
          pi.setProtector_contact(rs.getString("Protector_contact"));
          pi.setSocial_number(rs.getString("Social_number"));
          ArrayList<String> rsResDate = new ArrayList<String>();
          ArrayList<String> rsResHour = new ArrayList<String>();
          do {
             rsResDate.add(rs.getString("reservation_date"));
             rsResHour.add(rs.getString("Reservation_hour"));
          } while (rs.next());
          pi.setReservation_date(rsResDate);
          pi.setReservation_hour(rsResHour);
       }
    }catch (Exception e) {
       System.out.println("patientInformation e.getMessage ==> " + e.getMessage());
    } finally {
       if (rs != null) rs.close();
       if (pstmt != null) pstmt.close();
       if (conn != null) conn.close();
    }
    return pi;

 }

	public int deletePatient(int patient_no) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "DELETE FROM patient WHERE patient_no=?";
		System.out.println("delete Dao sql->" + sql);
		System.out.println("updatePatient Dao patient_no()->" + patient_no);
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, patient_no);
			System.out.println("patient_no()->" + patient_no);

			result = pstmt.executeUpdate();
			System.out.println("result->" + result);

		} catch (Exception e) {
			System.out.println("deletePatient Dao e.getMessage" + e.getMessage());
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		
		return result;
		
	}
}
