<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">


	
	@font-face {
    font-family: 'GangwonEduSaeeum_OTFMediumA';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/GangwonEduSaeeum_OTFMediumA.woff') format('woff');
    font-weight: normal;
    font-style: normal;
	}
	
	* {
	font-family: 'GangwonEduSaeeum_OTFMediumA';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/GangwonEduSaeeum_OTFMediumA.woff') format('woff');
    font-size: 30px;
	}
	
	#scRe_table {
		background-color: lightsteelblue;	
	}
	
	#scRe_table_btn {
		background-color: cornflowerblue;
		
	}

</style>
</head>
<body>

<form action="mainCalendarRegAct.do" method="post">
<input type="hidden" name="schedule_no" value="${schedule_no}">
<input type="hidden" name="doctor_no" value="${doctor_no}">
	
	<% 
    request.setAttribute("dateType1", "22-01-01");
    %>


	<table border="1" id="scRe_table">
	<caption><h2>스케줄 등록</h2></caption>
	<tr><td>제목</td><td>
	<c:if test="${schedule_no==0}">
	  	<input type="text" name="schedule_title" required="required">
	</c:if></td></tr>
	<tr><td>시작일</td><td><input type="date" name="schedule_startdate" ></td></tr>
	<tr><td>종료일</td><td><input type="date" name="schedule_enddate"></td></tr>
	<tr><td>내용</td><td><textarea rows="10" cols="30" name="schedule_content" required="required"></textarea></td></tr>
	</table>
		<p>
	    <input id="scRe_table_btn" type="submit" value="등록">
		<input id="scRe_table_btn" type="reset" value="취소">
</form>

</body>
</html>