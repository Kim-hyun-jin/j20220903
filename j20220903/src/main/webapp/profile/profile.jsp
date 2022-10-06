<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/54a6153010.js"
	crossorigin="anonymous"></script>


<link type="text/css" href="main.css" rel="stylesheet">

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
 <div id="container">
  	<div id="header">
  		<a href="3-layout.html" class="header_logo"><i class="fa-solid fa-hand-holding-medical"></i> CareBare</a>
  		<span class="header_page">내정보</span>
  		<span class="header_name">김준완</span>
  		<a href="profile.jsp" class="header_image"><img id="myphoto" alt="" src="../images/myphoto.png" style="width: 60px"></a>
  	</div>
  	<div id="left-sidebar">
   	
  			<div class="main_menu_btn">
				<a href="">환자정보검색</a>
			</div>
			<div class="main_menu_btn">
				<a href="">예약조회</a>
			</div>
			<div class="main_menu_btn">
				<a href="">내환자</a>
			</div>
			<div class="main_menu_btn">
				<a href="drug.jsp">의약품조회</a>
			</div>
			<div class="main_menu_btn">
				<a href="">공유게시판</a>
			</div>

			<div class="main_menu_btn">
				<a href="view/todo/list.jsp">list</a>
			</div>
  	</div>
  	
  	<div id="contents">
  	<article id="profile_update">
  		<div>내정보</div>
  		 
  		 <div class="main">
  		 	
  		 <div class="profile_update_img">
  		 	<div><img id="edit_img" alt="" src="../images/myphoto.png" style="width:100px"></div>
  		 	<form action="" method="post" enctype="multipart/form-data">
 
		  	  <input type="submit" value="이미지편집">
			</form>
  		 </div>
  		 <div class="profile_update_content">
  			
  			<div>이름: ${doctor.doctor_name}</div>
  			<div>사번: ${doctor.doctor_no}</div>
  			<div>담당과:${doctor.department}</div>
  			
  			
  			<input type="button" value="수정" onclick="profileModView.do">
  			<%-- <input type="button" value="수정" onclick="location.href='profileModForm.do?doctior_no=${doctor.doctor_no}'"> --%>
  		</div>
  		
  		</div>
  	</article>
  	


  	</div>
  	
  	<div id="footer">
  		<h2>CareBare</h2>
  		서울 마포구 신촌로 176 중앙빌딩 / 대표자:정중앙
  		TEL:02-313-1711
  </div>
</body>
</html>