<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/54a6153010.js"
        crossorigin="anonymous"></script>
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
	
	.popup_layer {position:fixed;top:0;left:0;z-index: 10000; width: 100%; height: 100%; background-color: rgba(0, 0, 0, 0.4); }
	
	/*팝업 박스*/
	.popup_box{position: relative;top:50%;left:50%; overflow: auto; height: 600px; width:375px;transform:translate(-50%, -50%);z-index:1002;box-sizing:border-box;background:#fff;box-shadow: 2px 5px 10px 0px rgba(0,0,0,0.35);-webkit-box-shadow: 2px 5px 10px 0px rgba(0,0,0,0.35);-moz-box-shadow: 2px 5px 10px 0px rgba(0,0,0,0.35);}
	
	
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
  		<p> 내스케줄 </p>
<%--   		<jsp:include page="innerSchedule.jsp"></jsp:include> --%>
   <!-- 	<link href='../css/fullcalendar/main.css' rel='stylesheet' />
   	<script src='../css/fullcalendar/main.js'></script> 
   	<script type="../css/fullcalendar/ko.js"></script>  한글변환
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
         navLinks: true, // 날짜 텍스트 클릭시 이벤트 실행
         selectable: true, //날짜 칸 클릭시 이벤크 실행 
         selectMirror: true,      
         select: function(arg){
        	 //window.open("mainCalendarModView.do","팝업 테스트","width=400, height=300, top=10, left=10");
        	 //document.getElementById("popup_layer").style.display = "block";  	 
        	 var title = window.open("mainCalendarModView.do");
        	 if(title){
        		 calendar.addEvent({
     						title: title,
     						start: arg.start,
     						end: arg.end,
     						allDay: arg.allDay
     			})
        	 }
        	 
        	 
         },
       
	       });
	       calendar.render();
	     });
   
  
	    </script>
	  
	    
   		 <div id='calendar' >
   		 <div id="fc-daygrid-day-events"></div>
   		 </div> 캘린더 뷰
   		 
  
	    <input type="hidden" id="hiddenDate">
	    <input type="button" value="등록" onclick="arg()">
	  	<input type="button" value="삭제"> -->
	  	<form action="mainCalendarRegView.do">
	  	<table>
	  	<tr>
			<th>글번호</th><th>의사번호</th><th>제목</th><th>시작일</th><th>종료일</th><th>내용</th>
		</tr>
		
	 <c:forEach var="schedule" items="${list}">
		
		<tr><td> ${schedule.schedule_no}</td>
			<td> ${schedule.doctor_no}</td>
			<td> ${schedule.schedule_title}</td>
			<td> ${schedule.schedule_startdate}</td>
			<td> ${schedule.schedule_enddate}</td>
			<td> ${schedule.schedule_content}</td>
			</tr>
			
		</c:forEach> 
		</table>
			<input type="submit" value="등록">  	
		</form>
 
 	 </article>
</div>
  	
  	<div id="footer">
  		<h2>CareBare</h2>
  		서울 마포구 신촌로 176 중앙빌딩 / 대표자:정중앙
  		TEL:02-313-1711
  </div>
</body>
</html>