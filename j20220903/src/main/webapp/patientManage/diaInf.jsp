<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진단상세정보</title>
</head>
<body>
	<%@ include file="../top-side.jsp" %>
	<div>
		<table>
			<tr><th>차트번호</th><td>${patientInf.chart_no }</td></tr>
			<tr><th>이름</th><td>${patientInf.patient_name }</td></tr>
			<tr><th>진료과</th><td>${patientInf.department }</td></tr>
			<tr><th>진단날짜</th><td>${diaInf.chart_date }</td></tr>
			<tr><th>증상</th><td>${diaInf.chart_symptom }</td></tr>
			<tr><th>병명</th><td>${diaInf.chart_disease }</td></tr>
			<tr><th>처방약</th><td>
								<c:forEach var="dd" items="${diaDrug }">
									${dd.drug_name }(${dd.drug_class })<br>
								</c:forEach>
								</td></tr>
		</table>
	</div>
	<%@ include file="../footer-side.jsp" %>
</body>
</html>