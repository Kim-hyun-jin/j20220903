<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mainCalendar</title>
<%
String context = request.getContextPath();
%>
<script src="https://kit.fontawesome.com/54a6153010.js" crossorigin="anonymous"></script>
<link href='<%=context%>/css/fullcalendar/main.css' rel='stylesheet' /> <!-- 캘린더 css -->
<script src='<%=context%>/css/fullcalendar/main.js'></script>  <!-- 캘린더 js -->
<script type="<%=context%>/css/fullcalendar/ko.js"></script>   <!-- 캘린더 한글변환 -->
<script type="text/javascript">
	var schduleList = new Array(); // Json 데이터를 받기 위한 배열 선언
	<c:forEach var="schedule" items="${list}"> /* JSTL */
	  var obj = new Object();
	  var date_str = "<c:out value="${schedule.schedule_startdate}"/>";
	  var date_end = "<c:out value="${schedule.schedule_enddate}"/>";
	  
	  
	  console.log("######"+JSON.stringify(date_str) + " " + JSON.stringify(date_end));
      obj = { /* 중괄호-->json object */
    	  id : "<c:out value="${schedule.schedule_no}"/>",
    	  title: "<c:out value="${schedule.schedule_title}"/>",
    	  start: date_str.substring(0,10),
    	  end :  date_end.substring(0,10),
    	  url : "mainCalendarModView.do?schedule_no=${schedule.schedule_no}"
    	   	  
    	 
   	  };
      schduleList.push(obj);
	</c:forEach>
	
	
	/* fullcalendar render */
	
      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth', //달 형식으로 캘린더 보이기
          locale: 'ko', //한글변환
          events: schduleList, /* 캘린더에 list를 뿌려주는 event */
		  height: 300,
		  contentHeight: 20,
		  aspectRatio: 0.2
        	   
          
        });
          calendar.render();
      });
      
</script>
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
	
	
		
	
</style>
</head>
<body>


	  			<div style="width: 350px; float: center; padding-left: 50px;" id='calendar'  ></div>   <!-- 캘린더 view -->


</body>
</html>