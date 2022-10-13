<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환자관리</title>
<script src="https://kit.fontawesome.com/54a6153010.js"
	crossorigin="anonymous"></script>
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
	height: 90%;
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
th {
	background-color: #D4F4FA;
}
</style>
</head>

<body>
	<%@ include file="../top-side.jsp"%>
	<input type="button" class="regi"
		onclick="location.href='patientRegView.do'" value="환자등록">
	<div class="mainContents">
		<table class="patient_manage_table" border="2">
			<tr>
				<th>환자번호</th>
				<th>환자이름</th>
				<th>생년월일</th>
				<th>성별</th>
				<th>상세정보</th>
				<th>진단내역</th>
				<th>수정/삭제</th>
			</tr>
			<c:forEach var="list" items="${patient_list}">
				<tr class="line">
					<td>${list.patient_no}</td>
					<td>${list.patient_name}</td>
					<td>${list.birth}</td>
					<td>${list.gender}</td>
					<td><input type="button"
						onclick="location.href='patientManageDetail.do?patient_no=${list.patient_no}'"
						value="상세정보"></td>
					<td><input type="button"
						onclick="location.href='diaHistroyView.do?patient_no=${list.patient_no}'"
						value="진단내역"></td>
					<td><input type="button"
						onclick="location.href='patientManageUpdateDetail.do?patient_no=${list.patient_no}'"
						value="수정/삭제"></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>



<%@ include file="../footer-side.jsp"%>