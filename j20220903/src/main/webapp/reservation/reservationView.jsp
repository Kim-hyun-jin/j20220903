<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 조회</title>
<link type="text/css" href="main.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="revStyle.css">  
<style type="text/css">
	table tr td {
		width:150px; 
		height:30px;
		font-size:28px;
	}
	table tr td checkbox {
		width:15px;
		height:15px;
	}
</style>
<%
	String context = request.getContextPath();
%>
<body>  
<script type="text/javascript">
	location.href = "reservationView.do";
</script> 
  <div id="container">  
  	<div id="header">
  		<a href="<%=context%>/mainView.do" class="header_logo"><i class="fa-solid fa-hand-holding-medical"></i> CareBare</a>
  		<span class="header_page">예약조회</span>
  		<span class="header_name">김준완</span>
  		<a href="profile.jsp" class="header_image"><img id="myphoto" alt="" src="myphoto.png" style="width: 60px"></a>
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
  	
  	<div id="contents">

	<article id="table-style">

 	 </article>
  	</div>
  	
  	<div id="footer">
  		<h2>CareBare</h2>
  		서울 마포구 신촌로 176 중앙빌딩 / 대표자:정중앙
  		TEL:02-313-1711
  </div>
</body>

</html>
  	
 