<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../top-side.jsp" %>

<table>
	<tr><td>차트번호</td><td>환자명</td><td>성별</td><td>증상</td><td>병명</td><td>진단일</td></tr>
	<c:foreach var="patientInfo_main" items="${myPatientList}">
		<tr><td>${patientInfo_main.chart_no}</td><td>${patientInfo_main.patient_name}</td>
		<td>${patientInfo_main.gender}</td><td>${patientInfo_main.chart_symptom}</td>
		<td>${patientInfo_main.chart_disease}</td><td>${patientInfo_main.chart_date}</td></tr>
	</c:foreach>
</table>



<%@ include file="../footer-side.jsp" %>
</body>
</html>