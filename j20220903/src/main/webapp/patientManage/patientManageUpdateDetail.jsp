<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환자 수정, 삭제 페이지</title>
<%@ include file="top-side.html" %>
</head>
<body>
<form action="patientManageUpdate.do" method="post">
<table border="2">
   		<tr><td>환자번호: </td><td><input type="hidden" name="patient_no" min="10" max="100" value="${list.patient_no}"></td></tr>
		<tr><td>환자이름: </td><td><input type="text" name="patient_name" required="required" value="${list.patient_name}"></td></tr>
		<tr><td>성별:	</td><td><input type="text" name="gender" required="required" value="${list.gender }"></td></tr>
		<tr><td>생년월일: </td><td><input type="text" name="birth" required="required" value="${list.birth }"></td></tr>
		<tr><td>주소: </td><td><input type="text" name="address" value="${list.address }"></td></tr>
		<tr><td>연락처: </td><td><input type="text" name="contact" value="${list.contact}"></td></tr>
		<tr><td>보호자연락처: </td><td><input type="text" name="protector_contact" value="${list.protector_contact }"></td></tr>
		<tr><td>주민번호: </td><td><input type="text" name="social_number" 
		pattern="[0-9]{13}" required="required" value="${list.social_number }"></td></tr>
		<td><input type="submit" value="수정"></td>
		<td><input type="button" onclick="location.href='patientManageDelete.do?patient_no=${list.patient_no}'" value="삭제"></td>
</table>
</form>
</body>
</html>