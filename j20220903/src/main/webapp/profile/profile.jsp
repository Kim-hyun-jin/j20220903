<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>
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
	
	.profile_update_img {
		margin: 20px;
	}
	
	.profile_update_content {
		margin: 20px;
	}
</style>
</head>
<body>
  	<%@ include file="../top-side.jsp" %>
  	
  	<article id="profile_update">
  		
  		 
  		 <div class="main">
  		 	
  		 <div class="profile_update_img">

  		 	<img  alt="profile_image" src="<%=context %>/images/${doctor_s.image}" style="width: 100px; border-radius: 50%;">
  		 	

  		 	<form action="" method="post" enctype="multipart/form-data">
 
			</form>
  		 </div>
  		 <div class="profile_update_content">
  			
  			<form action="<%=context %>/profileModView.do" method="post">
  				<input type="hidden" value="${doctor_s.image}" name="doctor_image">
		  		<input type="hidden" value="${doctor_s.doctor_no}" name="doctor_no">
				<input type="hidden" value="${doctor_s.doctor_name}" name="doctor_name">
				<input type="hidden" value="${doctor_s.department}" name="department">
				<input type="hidden" value="${doctor_s.password}" name="password">
				<input type="hidden" value="${img_path}" name="img_path">
		
  			<div>이름: ${doctor_s.doctor_name}</div>
  			<div>사번: ${doctor_s.doctor_no}</div>
  			<div>담당과:${doctor_s.department}</div>
  			<div>비밀번호:****</div>
  			
  			
  			<input type="submit" value="정보수정">
  			</form>
  		</div>
  		
  		</div>
  	</article>
  	

<%@ include file="../footer-side.jsp" %>