<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<%
String context = request.getContextPath();
%>
<body>
  	<div id="header">
  		<a href="<%=context %>/mainView.do" class="header_logo"><i class="fa-solid fa-hand-holding-medical"></i> CareBare</a>
  		<span class="header_page">의약품조회</span>
  		<span class="header_name">${doctor_s.doctor_name }</span>
  		<c:choose>
			<c:when test="${doctor_s.image == null}">
  				<a href="profile.jsp" class="header_image"><img id="myphoto" alt="" src="<%=context %>/images/user.png" style="width: 60px; border-radius: 50%;"></a>
			</c:when>
			<c:otherwise>
  				<a href="profile.jsp" class="header_image"><img id="myphoto" alt="" src="<%=context %>/images/myphoto.png" style="width: 60px; border-radius: 50%;"></a>
			</c:otherwise>
		</c:choose>
  	</div>
	<div id="container">
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
				<a href="<%=context%>/drugView.do?doctor_no=${doctor.doctor_no}">의약품조회</a>
			</div>
			<div class="main_menu_btn">
				<a href="">공유게시판</a>
			</div>
  	</div>
  	
  	<div id="contents">
  		<form action="<%=context%>/drugSearch.do">
	  		<input type="hidden" name="doctor_no" value="${doctor.doctor_no }">
	  		
	  		<span class="drug_search">약품분류</span>
	  		<select name="drug_class">
	  			<option value="empty"></option>
	  			<option value="shot">주사제</option>
	  			<option value="soft">경질캡슐</option>
	  			<option value="liquid">액제</option>
	  		</select><p>
	  		
	  		<span class="drug_search">약품명</span>
	  		<input type="text" name="drug_name" style="margin-left: 33px; border-radius: 5px; vertical-align: middle;">
	  		<input type="submit" id="search_btn" alt="search_btn" value="">
  		</form>
  		
  		<table border="1">
  			<tr><th>번호</th><th>약품코드</th><th>약품분류</th><th width="250px;">약품명</th></tr>
  			<c:forEach var="drug" items="${list }">
  				<tr><td>${startRow }</td><td>${drug.drug_code }</td><td>${drug.drug_class }</td><td>${drug.drug_name }</td></tr>
  				<c:set var="startRow" value="${startRow + 1 }"/>
  			</c:forEach>
  		</table>
  		<div style="text-align: center;">
			<c:if test="${startPage > blockSize }">
				<a href="<%=context%>/drugSearch.do?pageNum=${startPage-blockSize }">[이전]</a>
			</c:if>
			<c:if test="${totCnt > 0 }">
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<a href="<%=context%>/drugSearch.do?pageNum=${i}&drug_class=${drug_class}&drug_name=${drug_name}&doctor_no=${doctor.doctor_no}">[${i}]</a>
				</c:forEach>
			</c:if>
			<c:if test="${endPage < pageCnt }">
				<a href="<%=context%>/drugSearch.do?pageNum=${startPage+blockSize }">[다음]</a>
			</c:if>
		</div>
	</div>
  	
  	<div id="footer">
  		<h2>CareBare</h2>
  		서울 마포구 신촌로 176 중앙빌딩 / 대표자:정중앙
  		TEL:02-313-1711
  	</div>
  	</div>
</body>
</html>