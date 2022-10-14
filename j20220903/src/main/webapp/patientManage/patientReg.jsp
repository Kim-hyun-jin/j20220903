<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환자 등록 페이지</title>
<%@ include file="../top-side.jsp" %>
<style type="text/css">
table {
	background-color: white;
	border: 1px solid black;
	color: black;
	border-collapse: collapse;
	position: relative;
	width: 90%;
	height: 60%;
	margin: 5% 5% 1% 5%;
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

.sub {
	display: inline-block;
	margin: 5px;
	margin-left : 930px;
}

</style>
</head>
<body>
<form action="patientRegAct.do" method="post">
	<input type="hidden" name="doctor_no" value="2">
	<%-- <input type="hidden" name="doctor_no" value="${patient.doctor_no}"> --%>
<%--지우기? 	<input type="hidden" name="patient_no" value="${patient.patient_no }"> --%>
	
	<table border="2">
   <!-- <tr><td>환자번호: </td><td><input type="number" name="patient_no" min="10" max="100"></td></tr> -->
		<tr><td>환자이름: </td><td><input type="text" class="line" name="patient_name" required="required" placeholder="이름을 입력하세요" value="${list.patient_name }"></td></tr>
		<%-- <tr><td>성별:	</td><td><input type="radio" class="line" name="gender"  placeholder="예) 남 / 여" value="${list.gender }"></td></tr> --%>
		
		<tr><td>성별:	</td><td><input type="radio"  name="gender"  value="남" id="male"><label for="male">male</label>
						<input type="radio" name="gender"  value="여" id="female"><label for="female">female</label></td></tr>
		
		
		<tr><td>생년월일: </td><td><input type="text" class="line" name="birth" required="required" placeholder="예) 19991111" value="${list.birth }"></td></tr>
		<tr><td>주소: </td><td><input type="text" class="line" name="address" placeholder="주소를 입력하세요" value="${list.address }"></td></tr>
		<tr><td>연락처: </td><td><input type="text" class="line" name="contact" placeholder="예) 01022222222" value="${list.contact}"></td></tr>
		<tr><td>보호자연락처: </td><td><input type="text" class="line" name="protector_contact" placeholder="예) 01012345678" value="${list.protector_contact }"></td></tr>
		<tr><td>주민번호: </td><td><input type="tel" class="line" placeholder="예) 991111-1234567" name="social_number" 
		pattern="[0-9]{6}-[0-9]{7}" required="required" value="${list.social_number }"></td></tr>
		
		<!-- patientDto 에서 담당의만 제외한 정보 -->
	</table>
	<input type="submit" class = "sub" value="제출">
</form>
<%@ include file="../footer-side.jsp" %>