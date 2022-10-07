<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="top-side.html" %>
</head>
<body>

<table border="2">
	<caption>환자 상세 정보</caption>
	<tr><td>환자번호</td><td>${list.patient_no}</td></tr>
	<tr><td>환자이름</td><td>${list.patient_name }</td></tr>
	<tr><td>주민번호</td><td>${list.social_number }</td></tr>
	<tr><td>생년월일</td><td>${list.birth }</td></tr>
	<tr><td>성별</td><td>${list.gender }</td></tr>
	<tr><td>연락처</td><td>${list.contact }</td></tr>
	<tr><td>보호자 연락처</td><td>${list.protector_contact }</td></tr>
	<tr><td>주소</td><td>${list.address }</td></tr>
	<tr><td colspan="2">
	<input type="button" value="메인으로 돌아가기"
		onclick="location.href='patientManageView.do'"></td></tr>
	
</table>

</body>
</html>