<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>
<link type="text/css" href="main.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/54a6153010.js"
	crossorigin="anonymous"></script>

<style type="text/css">

	#profile_update {
		border: solid 2px;
		border-color: white;
		margin: 15px;
		height: 520px;
		background-color: white;
	  
	}
	
	.main
	{
		display: flex;
	}
	#edit_img
	{
		padding: 30px;
	}
	
</style>

</head>
<body>
<%   String context = request.getContextPath();%>
 <div id="container">
  	<div id="header">
  		<a href="<%=context%>/mainView.do" class="header_logo"><i class="fa-solid fa-hand-holding-medical"></i> CareBare</a>
  		<span class="header_page"></span>
  		<span class="header_name">${doctor_s.doctor_name}</span>
  		<a href="profile.jsp" class="header_image"><img id="myphoto" alt="" src="../images/myphoto.png" style="width: 60px"></a>
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
  	<article id="profile_update">
  		<div>내정보</div>
  		 
  		 <div class="main">
  		 	
  		 <div class="profile_update_img">
  		 	<div><img id="edit_img" alt="" src="<%=context %>/images/myphoto.png" style="width:100px"></div>
  		 	<form action="" method="post" enctype="multipart/form-data">
 
		  	  <input type="submit" value="이미지편집">
			</form>
  		 </div>
  		 <div class="profile_update_content">
  			
  			<div>이름: ${doctor.doctor_name}</div>
  			<div>사번: ${doctor.doctor_no}</div>
  			<div>담당과:${doctor.department}</div>
  			<div></div>
  			
  			<input type="button" onclick="location.href='<%=context %>/profileModForm.do'" value="정보수정">
  			<%-- <input type="button" value="수정" onclick="location.href='profileModForm.do?doctior_no=${doctor.doctor_no}'"> --%>
  		</div>
  		
  		</div>
  	</article>
  	


  	</div>
  	
<%@ include file="../footer-side.jsp" %>
</body>
</html>