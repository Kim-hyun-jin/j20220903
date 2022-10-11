<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진단상세정보</title>
<link type="text/css" href="patientManage/dia.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../top-side.jsp" %>
	
	<div class="mainContents">
	<div class="resultBox">
		<table class="inf">
			<tr><th>차트번호</th><td>${diaInf.chart_no }</td></tr>
			<tr><th>환자명</th><td>${patientInf.patient_name }</td></tr>
			<tr><th>진료자</th><td>${diaInf.doctor_name }(${diaInf.department })</td></tr>
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
	</div>
	<%@ include file="../footer-side.jsp" %>
</body>
</html>