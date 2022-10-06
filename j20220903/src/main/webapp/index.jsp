<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://kit.fontawesome.com/54a6153010.js"
	crossorigin="anonymous"></script>
<!-- <link type="text/css" href="test.css" rel="stylesheet"> -->
<link type="text/css" href="test.css" rel="stylesheet">
</head>

<body>
<%@ include file="top-side.jsp" %>

  <article id="schedule">
  	<div id="area" style="width: 500px; height: 50px;">
  	<p><a href="<%=context %>/mainCalendarView.do">내스케줄</a>
	</div>
	</article>
 <article id="patient_info">
  	<div id="area" style="width: 500px; height: 50px;">
  	<p><a href="<%=context %>/myPatientListView.do">내환자</a>
	</div>
		
 </article>
<%@ include file="footer-side.jsp" %>
</body>
</html>