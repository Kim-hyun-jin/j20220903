package service.khj;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.Doctor;
import dao.DoctorDao;
import service.CommandProcess;

public class ProfileModAct implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("profileModAct Start..");
		/*
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor)session.getAttribute("doctor_s");
		String doctor_no = doctor.getDoctor_no();
		
		DoctorDao doctorDao = DoctorDao.getInstance();
		int result = doctorDao.updateProfile(doctor);
		if(result == 1) {
			System.out.println("ProfileModAct 수정성공");
		} else{
			System.out.println("ProfileModAct 수정실패");
			response.sendRedirect("profile/profile.jsp");
		}
		request.setAttribute("doctor", doctor);
		request.setAttribute("doctor_no", doctor_no);
		request.setAttribute("result", result);
		*/
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor) session.getAttribute("doctor_s");
		
		System.out.println("doctor_s.doctor_no => " + doctor.getDoctor_no());
		// 5MB
		int maxSize = 5 * 1024 * 1024;
		String image = "/images";
		// Meta Data
		String realPath = request.getServletContext().getRealPath(image);
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		Enumeration en = multi.getFileNames();
		String serverSaveFilename = "";
		
		while (en.hasMoreElements()) {
			// input 태그의 속성이 file인 태그의 name 속성값 : 파라미터 이름
			String parameterName = (String) en.nextElement();
			// 서버에 저장된 파일 이름
			serverSaveFilename = multi.getFilesystemName(parameterName);
			// 전송전 원래의 파일 이름
			String original = multi.getOriginalFileName(parameterName);
			// 전송된 파일의 내용 타입
			String type = multi.getContentType(parameterName);
			// 전송된 파일속성이 file인 태그의 name 속성값을 이용해 파일객체 생성
			File file = multi.getFile(parameterName);
		}
		
		System.out.println("realPath : " + realPath);
		System.out.println("저장된 파일 이름 : " + serverSaveFilename);
		
		 // DataBase에도 파일 올리기 // DTO Setting
		String img_path = serverSaveFilename;
		System.out.println("img_path => " + img_path);
		
		DoctorDao dd = DoctorDao.getInstance();
		int result = dd.updateImage(img_path, doctor.getDoctor_no());
		
//		Member member = new Member();
//		member.setId(id);
//		member.setName(name);
//		member.setPasswd(passwd);
//		member.setAddress(address);
//		member.setTel(tel);
//		member.setImg_path(img_path);
//	 
//		MemberDao md = MemberDao.getInstance();
//		int result = md.insert3(member);
		
		return "profile/profile.jsp";
	}

}
