<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="top-side.jsp" %>

  <article id="schedule">
  	<div id="area" style="width: 500px; height: 50px;">
  	<a href="<%=context %>/mainCalendarView.do">내스케줄</a>
	</div>
	</article>
 
   <article id="patient_info">
  	<div id="area" style="width: 500px; height: 50px;">
  	<a href="<%=context %>/myPatientListView.do">최근 환자</a>
  		<table>
  			<tr><td>차트번호 </td><td>환자명 </td><td>성별 </td><td>증상 </td><td>병명 </td><td>진단일 </td></tr>
  			<tr></tr>
  		</table>
	</div>
		
 </article>
<%@ include file="footer-side.jsp" %>
</body>
</html>