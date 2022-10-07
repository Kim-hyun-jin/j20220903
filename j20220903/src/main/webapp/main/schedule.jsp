<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내스케줄</title>
<%
String context = request.getContextPath();
%>
<link type="text/css" href="main.css" rel="stylesheet"> <!-- 공통css -->
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
	  //moment(end_date, 'YYYY-MM-DD').add(1, 'days').format('YYYY-MM-DD HH:mm:SS');
	  //console.log("######"+JSON.stringify(date_str) + " " + JSON.stringify(date_end));
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
          headerToolbar: {
        	  start: "addEventButton",
        	  center: "prev title next",
        	  end: "today",
       	  },
          selectable: true,
          
          events: schduleList, /* 캘린더에 list를 뿌려주는 event */
          customButtons: {
              addEventButton: { // 추가한 버튼 설정
                  text : "일정 추가",  // 버튼 내용
                  click : function(){ // 버튼 클릭 시 이벤트 추가
                	  		window.location.href = "mainCalendarRegView.do";
                  }
              }
          },   
          timeZone: 'Asia/Seoul',
          eventClick:function(info) { 
          },

		  height: 550,
		  contentHeight: 230,
		  aspectRatio: 1.6
        	   
          
        });
          calendar.render();
      });
      
</script>


</head>

<body>
  	<div id="header">
  		<a href="<%=context%>/mainView.do" class="header_logo"><i class="fa-solid fa-hand-holding-medical"></i> CareBare</a>
  		<span class="header_page">내스케줄</span>
  		<span class="header_name">${doctor_s.doctor_name}</span>
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
	  	<article id="schedule">
	  		<p> 내스케줄 	  		
	  			<div style=" size:auto; width: 700px; float: center; padding-left: 10px;" id='calendar' ></div>   <!-- 캘린더 view -->
	 	 </article>