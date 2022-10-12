<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환자 수정/삭제</title>
<%@ include file="../top-side.jsp" %>
<style type="text/css">
.regi {
	display: inline-block;
	margin: 20px;
	margin-left: 950px;
}

table {
	background-color: white;
	border: 1px solid black;
	color: black;
	border-collapse: collapse;
	position: relative;
	width: 90%;
	height: 60%;
	margin: 5%;
	margin-top: 3%;
	position: relative;
	border: 3px solid lightsteelblue;
	overflow: scroll;
	overflow-x: hidden;
	text-align: center;
}

tr.line:hover {
	background-color: #DDDDDD;
	cursor: pointer;
	color: white;
}

.line {
	width: 95%;
	height: 36px;
	border : 0;
	
}
</style>
</head>
<body>
<form action="patientManageUpdate.do" method="post">
<table border="2">
   			<input type="hidden" class="line" name="patient_no" min="10" max="100" value="${list.patient_no}">
		<tr><td>환자이름: </td><td><input type="text" class="line" name="patient_name" required="required" value="${list.patient_name}"></td></tr>
		<tr><td>성별:	</td><td><input type="text" class="line" name="gender" required="required" value="${list.gender }"></td></tr>
		<tr><td>생년월일: </td><td><input type="text" class="line" name="birth" required="required" value="${list.birth }"></td></tr>
		<tr><td>주소: </td><td><input type="text" class="line" name="address" value="${list.address }"></td></tr>
		<tr><td>연락처: </td><td><input type="text" class="line" name="contact" value="${list.contact}"></td></tr>
		<tr><td>보호자연락처: </td><td><input type="text" class="line" name="protector_contact" value="${list.protector_contact }"></td></tr>
		<tr><td>주민번호: </td><td><input type="text" class="line"  name="social_number" 
		pattern="[0-9]{13}" required="required" value="${list.social_number }"></td></tr>
		<td><input type="submit" value="수정" ></td>
		<td><input type="button" onclick="location.href='patientManageDelete.do?patient_no=${list.patient_no}'" value="삭제"></td>
</table>
</form>
<%@ include file="../footer-side.jsp" %>