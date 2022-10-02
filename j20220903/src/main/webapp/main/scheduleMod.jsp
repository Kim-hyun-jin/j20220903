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

	table {
		background-color: lightsteelblue;
		border-color: cornflowerblue;
	}
	
	#in1 {	background-color: white;
		 
		     }
	
	
</style>
</head>

	<link href='../css/fullcalendar/main.css' rel='stylesheet' />
   	<script src='../css/fullcalendar/main.js'></script> 
   	<script type="../css/fullcalendar/ko.js"></script>  <!-- 한글변환 -->
   	<script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
   	<script type="text/javascript">
    	$(document).ready(function() {
    		var calendarEl = document.getElementById('calendar');
    	       var calendar = new FullCalendar.Calendar(calendarEl, {
    	    	   locale: 'ko', //한글변환
    	    	   headerToolbar: {
    	    	        right: 'dayGridMonth' //달력 화면으로 돌아가기
    	    	  },
    	    	  
    	    	 initialView: 'dayGridMonth', //초기날짜설정
    	     
    	         select: function(date,jsEvent){
    	        
    	        	 var title = prompt("Event Title:");
    	     		 if (title) {
    	     			calendar.addEvent({
    	     				title: title,
    	     				start: arg.start,
    	     				end: arg.end,
    	     				allDay: arg.allDay
    	        	 
    	        	 
    	        	 
    	         },
    	       
    		       });
    		       calendar.render();
    		     });
    	   
    	  
    	}
   	
   	</script>
<body>
	<form action="mainCalendarModAct.do" method="post">
	<table border="1" id="sc11">스케줄 수정
	<tr><td>제목 <input type="text" name="schedule_title" required="required"></td></tr>
	<tr><td>시작일 <input type="date" name="schedule_startdate" required="required"></td></tr>
	<tr><td>종료일 <input type="date" name="schedule_enddate" required="required"></td></tr>
	<tr><td>내용 <input type="text" name="schedule_content" required="required"></td></tr>
	</table>
		<p>
	    <input id="in1" type="submit" value="등록">
		<input id="in1" type="reset" value="취소">
	</form>
</body>
</html>