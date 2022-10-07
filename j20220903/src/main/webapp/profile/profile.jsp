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
	
</style>
</head>
<body>
  	<%@ include file="../top-side.jsp" %>
  	
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
  			
  			<div>이름: ${doctor_s.doctor_name}</div>
  			<div>사번: ${doctor_s.doctor_no}</div>
  			<div>담당과:${doctor_s.department}</div>
  			<div></div>
  			
  			<input type="button" onclick="location.href='<%=context %>/profileModForm.do'" value="정보수정">
  			<%-- <input type="button" value="수정" onclick="location.href='profileModForm.do?doctior_no=${doctor.doctor_no}'"> --%>
  		</div>
  		
  		</div>
  	</article>
  	

<%@ include file="../footer-side.jsp" %>