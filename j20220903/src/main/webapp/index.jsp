<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<script src="https://kit.fontawesome.com/54a6153010.js"
	crossorigin="anonymous"></script>
<link type="text/css" href="main.css" rel="stylesheet">
<style>
table, td, th {
  border: 1px solid black;
  
}
table {
	width: 700px;
}
td {
	padding: 10px;
	border-color: white;
}
patient_info_table {
  border-collapse: collapse;
}

#area {
  position: relative; /* absolute는 부모가 relative일 때 부모를 따라간다. */
  width: 100%;
 /*  padding-bottom: 56.25%; /* 16:9 비율 */ */
}

#calendar_iframe {
  position: absolute;
  width: 100%; /* 부모에 맞게 꽉 채운다. */
  height: 100%;
  border: none;
  align-content:center;
}

#schedule {
	
}
#patient_info {

}

</style>
</head>
<body>
  	<%@ include file="top-side.jsp" %>

	<article id="schedule">
		<div class="area" style="width: 500px; height: 50px;">
	  		<div>
	  			<a href="<%=context %>/mainCalendarView.do?doctor_no=${doctor_s.doctor_no}">내스케줄</a>
	  		</div>
	  		<div>
		      	<iframe id="calendar_iframe" src="mainCalendarMini.do?doctor_no=${doctor_s.doctor_no}" style="width: 720px;"></iframe>
	  		</div>
		</div>
	</article>
 
   <article id="patient_info">
  	<div class="area" style="width: 500px; height: 50px;">
  	<div>최근 환자</div>
  		<table border="2" id="patient_info_table">
	<tr><td>차트번호</td><td>환자명</td><td>성별</td><td>병명</td><td>증상</td><td>진단일</td></tr>
<%-- 	<c:foreach var="patientInfo_main" items="${myPatientList}"> --%>
	<c:forEach var="patientInfo_main" items="${myPatientList}">
		<tr><td>${patientInfo_main.chart_no}</td><td>${patientInfo_main.patient_name}</td>
		<td>${patientInfo_main.gender}</td><td>${patientInfo_main.chart_symptom}</td>
		<td>${patientInfo_main.chart_disease}</td><td>${patientInfo_main.chart_date}</td></tr>
	</c:forEach>
	
	</table>
	</div>
	</article>
		
 </div>

<%@ include file="footer-side.jsp" %>
