<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/54a6153010.js" crossorigin="anonymous"></script>
<link href='../css/fullcalendar/main.css' rel='stylesheet' /> <!-- 캘린더 css -->
<script src='../css/fullcalendar/main.js'></script>  <!-- 캘린더 js -->
<script type="../css/fullcalendar/ko.js"></script>   <!-- 캘린더 한글변환 -->
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
          
          eventClick:function(info) { 
          },

		  height: 550,
		  contentHeight: 200,
		  aspectRatio: 1.8
        	   
          
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
	
	#container {
		width: 1000px;
		height: 800px;
		margin: 0 auto;
	}
	#header {
		height : 50px;
		background-color: cornflowerblue;
		padding: 20px;
		border-bottom: solid 3px;
		border-bottom-color: white;
		position: relative;
	
	}
	
	#contents {
		width: 770px;
		height : 700px;
		float: left; /* 둘 다 left면 body에서 먼저 있는 애가 left로 잡히고 그 다음이 left로 잡힘 */
		background-color: lightsteelblue;
	}
	
	#left-sidebar {
	
		background-color: cornflowerblue;
		width: 230px;
		height : 700px;
		float: left;
	}
	
	.header_logo {
		font-size: 40px;
		font-weight: bold;
		color: white;
		position: absolute;
		left: 20px;
		bottom: 20px;
	}
	
	.header_image {
		position: absolute;
		bottom: 10px;
		right: 10px;
	}
	
	.header_page {
		position: absolute;
		bottom: 20px;
		left: 250px;
		font-size: 40px;
		color: white;
		font-family: 'GangwonEduSaeeum_OTFMediumA';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/GangwonEduSaeeum_OTFMediumA.woff') format('woff');
	    font-weight: normal;
	    font-style: normal;
		}
	
	.header_name {
		position: absolute;
		bottom: 25px;
		font-weight: bold;
		font-size: 25px;
		color: white;
		right: 100px;
	}
	
	.main_menu_btn {
	
		display: flex;
		background-color: white;
		border: 1px solid black;
		justify-content: center;
		margin: 15px;		
		padding: 20px;
		
	
	}
	
	.main_menu_btn:hover {
		color: cornflowerblue;
		box-shadow: 3px 3px #00008B;
	}
	
	#schedule {
		border: solid 2px;
		border-color: white;
		margin: 15px;
		height: 320px;
		background-color: white;
	  
	}
	
	#patient_info{
	
		border: solid 2px;
		border-color: white;
		margin: 15px;
		height: 320px;
		background-color: white;
	}
	
	
	#footer {
		height : 130px;
		clear : both; /* 나는 flat를 따르지 않을 거란다~ */
		background-color: cornflowerblue;
		border-top: solid 3px;
		border-top-color: white;
		padding-left: 10px;
	}
	
	
	a {
		text-decoration: none;
		color: inherit;
	}
	
	#schedule {
		border: solid 2px;
		border-color: white;
		margin: 15px;
		height: 660px;
		background-color: white;
	  
	}
	
	#patient_info{
	
		border: solid 2px;
		border-color: white;
		margin: 15px;
		height: 320px;
		background-color: white;
	}
	
	
	#footer {
		height : 130px;
		clear : both; /* 나는 flat를 따르지 않을 거란다~ */
		background-color: cornflowerblue;
		border-top: solid 3px;
		border-top-color: white;
		padding-left: 10px;
	}
	
	
	a {
		text-decoration: none;
		color: inherit;
	}
	
	#schedule {
		border: solid 2px;
		border-color: white;
		margin: 15px;
		height: 660px;
		background-color: white;
	  
	}

	
</style>
</head>
<body>
 <div id="container">
  	<div id="header">
  		<a href="3-layout.html" class="header_logo"><i class="fa-solid fa-hand-holding-medical"></i> CareBare</a>
  		<span class="header_page">내정보</span>
  		<span class="header_name">김준완</span>
  		<a href="profile.jsp" class="header_image"><img id="myphoto" alt="" src="myphoto.png" style="width: 60px"></a>
  	</div>
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
			<a href="drug.jsp">의약품조회</a>
		</div>
		<div class="main_menu_btn">
			<a href="">공유게시판</a>
		</div>

		<div class="main_menu_btn">
			<a href="view/todo/list.jsp">list</a>
		</div>
  	</div>
  	
  	<div id="contents">
	  	<article id="schedule">
	  		<p> 내스케줄 	  		
	  			<div style=" size:auto; width: 700px; float: center; padding-left: 10px;" id='calendar' ></div>   <!-- 캘린더 view -->
	 	 </article>
	</div>
  	<div id="footer">
  		<h2>CareBare</h2>
  		서울 마포구 신촌로 176 중앙빌딩 / 대표자:정중앙
  		TEL:02-313-1711
  </div>
</div>
</body>
</html>