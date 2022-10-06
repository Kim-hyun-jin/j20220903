<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" href="test.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/54a6153010.js"
	crossorigin="anonymous"></script>

</head>

<%   String context = request.getContextPath();%> 
<body>  
   <div id="container">
  	<div id="header">
  		<a href="<%=context%>/mainView.do" class="header_logo"><i class="fa-solid fa-hand-holding-medical"></i> CareBare</a>
  		<span class="header_page">메인페이지</span>
  		<span class="header_name">김준완</span>
  		<a href="<%=context%>/profile.do" class="header_image"><img id="myphoto" alt="" src="images/myphoto.png" style="width: 60px"></a>
  	</div> 
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
