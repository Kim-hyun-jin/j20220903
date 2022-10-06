<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" href="main.css" rel="stylesheet">
<link type="text/css" href="patientManage/patientManage.css" rel="stylesheet">
</head>


<body> 
  	<div id="header">
  		<a href="3-layout.html" class="header_logo"><i class="fa-solid fa-hand-holding-medical"></i> CareBare</a>
  		<span class="header_page">환자관리</span>
  		<span class="header_name">${doctor.doctor_name }</span>
  		<a href="profile.jsp" class="header_image"><img id="myphoto" alt="" src="../images/myphoto.png" style="width: 60px"></a>
  	</div>
<%@ include file="../top-side.jsp" %>


  	
  	
  		
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
  		
 
  	
<%@ include file="../footer-side.jsp" %>
</body>
</html>