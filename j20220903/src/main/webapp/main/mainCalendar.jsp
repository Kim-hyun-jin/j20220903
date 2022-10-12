<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mainCalendar</title>
<%   String contextSrc = request.getContextPath();%><!-- 공통으로 include하는 top-side파일에서 선언한 context 변수명과 겹쳐서 변경 -->
<script src="https://kit.fontawesome.com/54a6153010.js" crossorigin="anonymous"></script>
<link href='<%=contextSrc%>/css/fullcalendar/main.css' rel='stylesheet' /> <!-- 캘린더 css -->
<script src='<%=contextSrc%>/css/fullcalendar/main.js'></script>  <!-- 캘린더 js -->
<script type="<%=contextSrc%>/css/fullcalendar/ko.js"></script>   <!-- 캘린더 한글변환 -->
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
    	  //url : "mainCalendarModView.do?schedule_no=${schedule.schedule_no}"
    	  allDay: true
    	   	  
    	 
   	  };
      schduleList.push(obj);
	</c:forEach>
	
	
	/* fullcalendar render */
	
    document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth', //달 형식으로 캘린더 보이기
          locale: 'ko', //한글변환
          headerToolbar: {
        	  start: '', // will normally be on the left. if RTL, will be on the right
        	  center: 'title',
        	  end: '' // will normally be on the right. if RTL, will be on the left
          },
          //dayMaxEventRows: true,
          events: schduleList, /* 캘린더에 list를 뿌려주는 event */
		  height: 300,
		  eventDataTransform: function(event) {          //롱이벤트 버그 수정                                                                                                                    
		    	 if(event.allDay)  {  
		    		var addDate = new Date(event.end);
		    		addDate.setDate(addDate.getDate() + 1);
		    		  
		    		event.end = addDate.toISOString().substring(0,10);
	        	  }
	        	  return event;  
	       	  },    
		  editable : false
		  //expandRows: true,
		  //contentHeight: 200,
		  //aspectRatio: 5.0,
		 //calendar.setOption('contentHeight', 30),
		 
           
          
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
	
	#calendar {
    max-width: 480px;
    min-height: 50px;
    margin: 0 auto;
    -ms-overflow-style: none;
    /* pointer-events : none; */
  }
  
	  body{  
	 -ms-overflow-style: none;  /* 스크롤바는 숨기고 */
/* 	  width: 500px; */
	 }
	::-webkit-scrollbar {      /* 스크롤 기능은 살림 */
	  	display: none;
	}

  	.fc .fc-daygrid-body-unbalanced .fc-daygrid-day-events {
  		min-height: 1em;
  }	
  
  tr,td,th {
  	font-size: 20px;
  	text-align: center;
  
  }
  
  th,td {
  	text-shadow: lightsteelblue;
  }
	
		
	
</style>
</head>
<body>
	<table  style="width: 100%">
		<tr>
			<td style="width: 230px; padding-left: 10px;">
				<table  id="todoList" style="width: 230px; padding-top: ">
					<tr>
						<th colspan="2"><span style="background-color: #D6F0FF">TODO LIST</span></th>
					</tr>
					<tr>
						<th>오늘일자</th>
						<th>To do</th>
					<tr>
					<c:forEach var="listOf" items="${todoList}">
						<tr>
							<td>${fn:substring(listOf.schedule_startdate,0,10)}</td>
							<td>${listOf.schedule_title}</td>
						</tr>
					</c:forEach>
			 	</table>
		 	</td>
		 	<td rowspan="2">
		 		<div style="width: 400px; padding-left :15px; float: left;" id='calendar'></div>   <!-- 캘린더 view -->
		 	</td>
		</tr>
		<tr>
			<td style="width: 230px; float: right;  padding-left: 10px; ">
				<table id="reservationList" style="width: 230px;">
					<tr>
						<th colspan="2"><span style="background-color: #D6F0FF">TODAY PATIENT</span></th>
					</tr>
					<tr>
						<th>오늘일자</th>
						<th>환자이름</th>
					<tr>
					<c:forEach var="listOf" items="${reservationList}">
						<tr>
							<td>${fn:substring(listOf.reservation_date,0,10)}</td>
							<td>${listOf.patient_name}</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>

</html>