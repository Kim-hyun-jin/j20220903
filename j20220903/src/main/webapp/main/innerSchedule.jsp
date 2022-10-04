<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='../css/fullcalendar/main.css' rel='stylesheet' />
<style>

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
	
  body {
    margin: 40px 10px;
    padding: 0;
    font-size: 11px;
    height:100%;
  }
  
  @media screen and (max-width:500px){
	  body {
	    margin: 40px 10px;
	    padding: 0;
	    font-size: 11px;
	    height:100%;
	  }
	  .fc-toolbar-title{
	  	font-size: 10px !important;
	  }
  }
  @media screen and (min-width:501px){
  	  body {
	    margin: 40px 10px;
	    padding: 0;
	    font-size: 14px;
	    height:100%;
	  }
  }

  #calendar {
    max-width: 1400px;
    min-height: 500px;
    margin: 0 auto;
  }
  
  /*요일*/
  .fc-col-header-cell-cushion {
	color: #000;
  }
  .fc-col-header-cell-cushion:hover {
	text-decoration: none;
	color:#000;
  }
  /*일자*/
  .fc-daygrid-day-number{
	color: #000;
	font-size:1em;
  }
  
  /*종일제목*/
  .fc-event-title.fc-sticky{
    
  }
  /*more버튼*/ 
  .fc-daygrid-more-link.fc-more-link{
	color: #000;
  }
  /*일정시간*/
  .fc-daygrid-event > .fc-event-time{
	color:#000;
  }
  /*시간제목*/
  .fc-daygrid-dot-event > .fc-event-title{
    color:#000 !important;
  }
  /*가로 줄 - 월달력 종일 or 복수일자*/
  .fc-h-event{
	
  }
  /*세로 줄 - 주달력, 일달력*/
  .fc-v-event{
	
  }
  /*title 옆에 점*/
  .fc-daygrid-event-dot{
	
  }
  /*month/week/day*/
  .fc-button-active{
	border-color: #ffc107 		!important;
	background-color: cornflowerblue 	!important;
	color: #000 				!important;
	font-weight: bold 			!important;
  }
  /*노란버튼*/
  .btn-warning{
  	font-weight: bold;

  }
  /*모달 푸터*/
  .modal-footer{
  	display:inline-block;
  }
  
</style>
<script src='../css/fullcalendar/main.js'></script> 
<script type="../css/fullcalendar/ko.js"></script>  <!-- 한글변환 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> <!-- 일정 추가용 부트스트랩 팝업 모달 사용 -->
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
        	 var title = prompt("일정을 입력하세요");
        	 if(title){
        		 calendar.addEvent({
     						title: title,
     						start: arg.start
     			})
     			$ajax({
     				type:"post"  ,
     				url : "mainCalendarModView.do"   ,
     				date : {
     					'event_date_give' : dateFormat(arg.start),
     					'event_tittle_give' :title				
     				},
     				succcess : function(respnse) {
						alert("일정이 추가되었습니다.");
					}
     			})
     			calendar.unselect();
        	 }
        	 
        	 
         },
       
	       });
	       calendar.render();
	     });
   
  
	    </script>
</head>
<body>
 <div id='calendar' ></div>
 

          
</body>
</html>