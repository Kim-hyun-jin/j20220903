<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>profileMod.jsp</p>
	<form action="MyProfileModPro.do" method="post">
		<input type="hidden" name="doctor_no" value="${doctor.doctor_no}">
		
		<table border="1">
			<caption>내정보 수정</caption>
			<tr><td>이름</td><td><input type="text" name="doctor_name" required="required" value="${doctor.name}"></td></tr>
			<tr><td>사번</td><td><input type="text" name="doctor_no" required="required" value="${doctor.doctor_no}"></td></tr>
			<tr><td>담당과</td><td><input type="text" name="department" required="required" value="${doctor.department}"></td></tr>
			<tr><td colspan="2"><input type="submit" value="수정완료"></td></tr>
		</table>
	</form>
</body>
</html>