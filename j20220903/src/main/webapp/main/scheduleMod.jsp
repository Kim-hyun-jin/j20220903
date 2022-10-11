<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스케줄 수정</title>

<link type="text/css" href="main.css" rel="stylesheet"> <!-- 공통css -->
<style type="text/css">

	#scRe_table {
		background-color: lightsteelblue;	
	}
	
	#scRe_table_btn {
		background-color: cornflowerblue;
		
	}
	
	
	#mcma{
		float: left;
		position: relative;
		left:27%;
			}
	
	

</style>
</head>
<body>
<%@ include file="../top-side.jsp" %>
	  	<article id="schedule" style="height: 663px;">
	  		<p> 
		<form action="mainCalendarModAct.do" method="post" id="mcma">
			<input type="hidden" name="schedule_no" value="${schedule.schedule_no}">
			<input type="hidden" name="doctor_no" value="${schedule.doctor_no}">
			<table border="1" id="scRe_table">
			<caption><h2>스케줄 수정</h2></caption>
			<tr><td>번호</td><td>${schedule.schedule_no}</td></tr>
			<tr><td>제목</td><td>
			  	<input type="text" id="schedule_title" name="schedule_title" required="required" value="${schedule.schedule_title}">
			</td></tr>
			<tr><td>시작일</td><td><input type="date" name="schedule_startdate"
												value="${schedule.schedule_startdate.substring(0,10)}" ></td></tr>
			<tr><td>종료일</td><td><input type="date" name="schedule_enddate"
													value="${schedule.schedule_enddate.substring(0,10)}"></td></tr>
			<tr><td>내용</td><td><pre><textarea rows="5" cols="25" name="schedule_content" required="required">
														${schedule.schedule_content}</textarea></pre></td></tr>
			</table>
				<p>
			    <input id="scRe_table_btn" type="submit" value="수정">
			    <input id="scRe_table_btn" type="button" value="삭제"
			           onclick="location.href='mainCalendarDelAct.do?schedule_no=${schedule.schedule_no}'">
				<input id="scRe_table_btn" type="button" value="취소" onclick="location.href='mainCalendarView.do?doctor_no=${doctor_s.doctor_no}'">
		</form>
	 	</article>

	<%@ include file="../footer-side.jsp" %>
