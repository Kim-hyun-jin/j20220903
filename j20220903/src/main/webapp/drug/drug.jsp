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
<link type="text/css" href="drug/drug.css" rel="stylesheet">
</head>
<body>
	<div id="container">
  	<div id="header">
  		<a href="3-layout.html" class="header_logo"><i class="fa-solid fa-hand-holding-medical"></i> CareBare</a>
  		<span class="header_page">의약품조회</span>
  		<span class="header_name">${doctor.doctor_name }</span>
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
  	</div>
  	
  	<div id="contents">
  		<form action="../drugSearch.do">
	  		<span class="drug_search">약품분류</span>
	  		<select>
	  			<option></option>
	  			<option>주사제</option>
	  			<option>경질캡슐</option>
	  			<option>액제</option>
	  		</select><p>
	  		
	  		<span class="drug_search">약품명</span>
	  		<input type="text" name="drug_name" style="margin-left: 33px; border-radius: 5px; vertical-align: middle;">
	  		<input type="submit" id="search_btn" alt="search_btn" value="">
  		</form>
  		
  		<table border="1">
  			<tr><th>약품코드</th><th>약품분류</th><th width="250px;">약품명</th></tr>
  			<tr><td>약품코드</td><td>약품분류</td><td>포도당가엔에이케이12</td></tr>
  		</table>
	</div>
  	
  	<div id="footer">
  		<h2>CareBare</h2>
  		서울 마포구 신촌로 176 중앙빌딩 / 대표자:정중앙
  		TEL:02-313-1711
  </div>
</body>
</html>