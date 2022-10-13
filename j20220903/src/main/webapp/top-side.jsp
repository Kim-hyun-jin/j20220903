<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%   String context = request.getContextPath();%> 
<title>Insert title here</title>
<link type="text/css" href="<%=context %>/main.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/54a6153010.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		if (${doctor_s.doctor_no==null}) {
			alert("잘못 된 접근입니다. \n 로그인정보 없음.");
			location.href="<%=context%>/logout.do"
		}
	})
	function logout() {
		if (confirm("로그아웃을 하시겠습니까?")) {
			location.href="<%=context%>/logout.do";
		}
	}
</script>
</head>

<body>
   <div id="container">
  	<div id="header">
  		<a href="<%=context%>/mainView.do" class="header_logo"><i class="fa-solid fa-hand-holding-medical"></i> CareBare</a>
  		<span class="header_page"><script type="text/javascript">document.write(document.title)</script></span>
  		<span class="header_name">${doctor_s.doctor_name }</span>
  		<input type="button" onclick="logout()" class="header_logout" value="로그아웃">
  		<c:choose>
			<c:when test="${doctor_s.image == null}">
  				<a href="<%=context %>/profile.do" class="header_image"><img id="myphoto" alt="" src="<%=context %>/images/user.png" style="width: 60px; border-radius: 50%;"></a>
			</c:when>
			<c:otherwise>
  				<a href="<%=context %>/profile.do" class="header_image"><img id="myphoto" alt="" src="<%=context %>/images/${doctor_s.image}" style="width: 60px; height:60px; border-radius: 50%;"></a>
			</c:otherwise>
		</c:choose>
  	</div>
  	<div id="left-sidebar">
   		<a href="<%=context%>/patientSearch.do">
  			<div class="main_menu_btn">환자 정보 검색</div>
		</a>
   		<a href="<%=context%>/reservationView.do">
  			<div class="main_menu_btn">예약 조회</div>
		</a>
   		<a href="<%=context%>/patientManageView.do">
  			<div class="main_menu_btn">환자 관리</div>
		</a>
   		<a href="<%=context%>/drugView.do">
  			<div class="main_menu_btn">의약품 조회</div>
		</a>
   		<a href="<%=context%>/shareBoardView.do">
  			<div class="main_menu_btn">공유 게시판</div>
		</a>
  	</div>
	<div id="contents">