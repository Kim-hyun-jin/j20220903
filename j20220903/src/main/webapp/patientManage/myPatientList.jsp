<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내환자목록</title>
<link type="text/css" href="main.css" rel="stylesheet">
</head>
<body>
<%
String context = request.getContextPath();
%>
<body>
  	<div id="header">
  		<a href="<%=context%>/mainView.do" class="header_logo"><i class="fa-solid fa-hand-holding-medical"></i> CareBare</a>
  		<span class="header_page">내환자목록</span>
  		<span class="header_name">${doctor_s.doctor_name }</span>
  		<c:choose>
			<c:when test="${doctor_s.image == null}">
  				<a href="profile.jsp" class="header_image"><img id="myphoto" alt="" src="<%=context %>/images/user.png" style="width: 60px; border-radius: 50%;"></a>
			</c:when>
			<c:otherwise>
  				<a href="profile.jsp" class="header_image"><img id="myphoto" alt="" src="<%=context %>/images/myphoto.png" style="width: 60px; border-radius: 50%;"></a>
			</c:otherwise>
		</c:choose>
  	</div>
	<div id="container">
  	<div id="left-sidebar">
   	
  			<div class="main_menu_btn">
				<a href="<%=context%>/patientSearch.do">환자정보검색</a>
			</div>
			<div class="main_menu_btn">
				<a href="<%=context %>/reservationView.do">예약조회</a>
			</div>
			<div class="main_menu_btn">
				<a href="<%=context %>/patientManageView.do">환자관리</a>
			</div>
			<div class="main_menu_btn">
				<a href="<%=context%>/drugView.do?doctor_no=2">의약품조회</a>
			</div>
			<div class="main_menu_btn">
				<a href="<%=context %>/shareBoardView.do">공유게시판</a>
			</div>
  	</div>

<table border="2">
	<tr><td>차트번호</td><td>환자명</td><td>성별</td><td>증상</td><td>병명</td><td>진단일</td></tr>
<%-- 	<c:foreach var="patientInfo_main" items="${myPatientList}"> --%>
	<c:forEach var="patientInfo_main" items="${myPatientList}">
		<tr><td>${patientInfo_main.chart_no}</td><td>${patientInfo_main.patient_name}</td>
		<td>${patientInfo_main.gender}</td><td>${patientInfo_main.chart_symptom}</td>
		<td>${patientInfo_main.chart_disease}</td><td>${patientInfo_main.chart_date}</td></tr>
	</c:forEach>
</table>

</div>


<%@ include file="../footer-side.jsp" %>
</body>

</html>