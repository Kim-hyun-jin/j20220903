<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환자관리</title>
<link type="text/css" href="main.css" rel="stylesheet">
</head>
<%
String context = request.getContextPath();
%>
<body>
  	<div id="header">
  		<a href="<%=context%>/mainView.do" class="header_logo"><i class="fa-solid fa-hand-holding-medical"></i> CareBare</a>
  		<span class="header_page">환자관리</span>
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

	<div id="contents">
  		
  		<table class="patient_manage_table" border="2">
  		<caption>환자관리</caption>
	  		<tr><th>환자번호</th><th>환자이름</th><th>생년월일</th><th>성별</th><th>상세정보</th><th>진단내역</th><th>수정/삭제</th></tr>
	  		
	  		<c:forEach var="list" items="${patient_list}">
	  			<tr><td>${list.patient_no}</td><td>${list.patient_name}</td><td>${list.birth}</td><td>${list.gender}</td>
	  			<td><input type="button" onclick="location.href='patientManage/patientManageDetail.jsp?patient_no=${list.patient_no}'" value="상세정보"></td>
	  			<td><input type="button" onclick="location.href='diaHistroyView.do?patient_no=${list.patient_no}'" value="진단내역"></td>
	  			<td><input type="button" onclick="location.href='patientManage/patientManageDetail.jsp?patient_no=${list.patient_no}'" value="수정/삭제"></td></tr>

	  		</c:forEach>
   		
  		</table>

  		
  		<div class="button">
	  		<div class="patient_manage_button">
	  			<input type="button" onclick="location.href='myPatientListView.do'" value="내환자목록">
	  		</div>
	  		
	  		<div class="patient_manage_button">
	  			<input type="button" onclick="location.href='patientRegView.do'" value="환자등록">
	  		</div>

  		</div>
  		
  	</div>
</div>
<%@ include file="../footer-side.jsp" %>
