<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 조회</title>
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
	#contents {
		overflow: scroll;

	}
	table {
		background: cornflowerblue;
	}
</style>
<%
	String context = request.getContextPath();
%>


<body>  

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

		<table border="1">
		 <colgroup>
		 	<col width="8%">
		 	<col width="15%">
		 	<col width="10%">
		 	<col width="15%">
		 	<col width="10%">
		 	<col width="10%">
		 </colgroup>
			
			<tr>
			<th>선택</th><th>예약일</th><th>이름</th><th>의료과</th><th>의료진</th><th>예약시간</th>
			</tr>
			<c:if test="${totCnt>0}">
				<c:forEach var="reservation" items="${list }">
					<tr>
						<td align="center"><input type="checkbox" name="chk" value="${reservation}"></td>
						<td>${reservation.reservation_date}</td>
						<td>${reservation.patient_name}</td>
						<td>${reservation.department}</td>
						<td>${reservation.doctor_name}</td>
						<td>${reservation.reservation_hour}</td>
						
					</tr><p>		
				</c:forEach>
				<c:if test="${totCnt == 0}">
					<tr>
						<td colspan=7>데이터가 없네</td>
					</tr>
				</c:if>
			</c:if>
			
		</table>
			<input type="button" value="삭제" onclick="location.href='reservationDel.do'" style="float: right">
			<input type="button" value="등록" onclick="location.href='reservationReg.do'" style="float: right">
<!-- 			<input type="button" value="등록" onclick="alert(1)" style="float: right"> -->

 	 </article>
  	</div>
  	
  	<div id="footer">
  		<h2>CareBare</h2>
  		서울 마포구 신촌로 176 중앙빌딩 / 대표자:정중앙
  		TEL:02-313-1711
  </div>
</body>

</html>
  	
 