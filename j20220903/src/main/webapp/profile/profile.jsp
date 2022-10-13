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
		position: realative;
	}
	
	.main
	{
		display: flex;
		justify-content: center;
		align-items: center;
		margin-top: 100px;
	}

	.profile_img {
		margin: 20px;
		border: 30px;
	}
	
	.profile_update_content {
		margin: 20px;
		padding-top: 30px;
		padding-bottom: 30px;
		padding-left: 50px;
		padding-right: 100px;
		border: 1px solid ;
		border-color: gray;
	}
	.table_row {
		margin: 10px;
	}
	
	#mod_button {
		margin-left: 100px;
	}
</style>
</head>
<body>
  	<%@ include file="../top-side.jsp" %>
  	
  	<article id="profile_update">
  		
  		 
  		 <div class="main">
  		 	
  		 <div class="profile_img">

  		 	<c:choose>
				<c:when test="${doctor_s.image == null}">
  					<img id="myphoto" class="profile_img" alt="image" src="<%=context %>/images/user.png" style="width: 100px;">
				</c:when>
				<c:otherwise>
  					<img id="myphoto" class="profile_img"  alt="image" src="<%=context %>/images/${doctor_s.image}" style="width: 100px;">
				</c:otherwise>
			</c:choose>
  		 </div>
<!--   		 	<form action="" method="post" enctype="multipart/form-data">
 
			</form> -->
  		 <div class="profile_update_content">
  			
  			<form action="<%=context %>/profileModView.do" method="post">
  				<input type="hidden" value="${doctor_s.image}" name="doctor_image">
		  		<input type="hidden" value="${doctor_s.doctor_no}" name="doctor_no">
				<input type="hidden" value="${doctor_s.doctor_name}" name="doctor_name">
				<input type="hidden" value="${doctor_s.department}" name="department">
				<input type="hidden" value="${doctor_s.password}" name="password">
				<input type="hidden" value="${img_path}" name="img_path">
		
  			<div class="table_row">이름:      ${doctor_s.doctor_name}</div>
  			<div class="table_row">사번:      ${doctor_s.doctor_no}</div>
  			<div class="table_row">담당과:     ${doctor_s.department}</div>
  			<div class="table_row">비밀번호:    ****</div>
  			
  			
  			<input type="submit" value="정보수정" id="mod_button">
  			</form>
  		</div>
  		
  		</div>
  	</article>
  	

<%@ include file="../footer-side.jsp" %>