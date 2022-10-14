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

<style>
#contents{
	overflow: scroll ;
	overflow-x:hidden;
}
table {
	width: 700px;
}
td {
	padding: 10px;
	border-color: white;
}
th {
	background-color: #D4F4FA;
}
patient_info_table {
  border-collapse: collapse;
  padding: 50px;
}

#area {
  position: relative; /* absolute는 부모가 relative일 때 부모를 따라간다. */
  width: 100%;
 padding-bottom: 56.25%; /* 16:9 비율 */ 
}

#calendar_iframe {
  position: absolute;
  width: 100%; /* 부모에 맞게 꽉 채운다. */
  height: 100%;
  border: none;
  align-content:center;
}
.seperator {
	border: 1px solid gray ;
	width: 700px;
}

.main_content {
	padding-left: 50px;
	padding-top: 5px;
}
#second_title {
	padding: 10px;
}

</style>
</head>
<body>
  	<%@ include file="top-side.jsp" %>

  		<div class="main_content">
	<article id="schedule">
		<div class="area" style="width: 500px; height: 50px;">
	  		<div>
	  			<a href="<%=context %>/mainCalendarView.do?doctor_no=${doctor_s.doctor_no}">내스케줄  </a><i class="fa-solid fa-arrow-left fa-sm" class="arrow_icon"></i>
	  		</div>
	  		<div>
		      	<iframe id="calendar_iframe" src="mainCalendarMini.do?doctor_no=${doctor_s.doctor_no}" style="width: 720px;"></iframe>
	  		</div>
		</div>
	</article>
 
   <article id="patient_info">
  	<div class="area" style="width: 500px; height: 50px;">
  	<div id="second_title">최근 환자</div>
  		<table border="2" id="patient_info_table">
	<tr><th>차트번호</th><th>환자명</th><th>성별</th><th>병명</th><th>증상</th><th>진단일</ths></tr>
<%-- 	<c:foreach var="patientInfo_main" items="${myPatientList}"> --%>
	<c:forEach var="patientInfo_main" items="${myPatientList}">
		<tr><td>${patientInfo_main.chart_no}</td><td>${patientInfo_main.patient_name}</td>
		<td>${patientInfo_main.gender}</td><td>${patientInfo_main.chart_disease}</td>
		<td>${patientInfo_main.chart_symptom}</td><td>${patientInfo_main.chart_date}</td></tr>
	</c:forEach>
	
	</table>
	</div>
	</article>
	</div>
		

<%@ include file="footer-side.jsp" %>
