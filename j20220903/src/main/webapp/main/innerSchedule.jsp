
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<!-- jquery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- bootstrap 4 -->
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <!-- fullcalendar -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.css">
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>


    <script type="text/javascript">
        document.addEventListener('DOMContentLoaded', function () {
            var calendarEl = document.getElementById('calendar');
            var calendar = new FullCalendar.Calendar(calendarEl, {
                timeZone: 'UTC',
                initialView: 'dayGridMonth', // 홈페이지에서 다른 형태의 view를 확인할  수 있다.
                events:[ // 일정 데이터 추가 , DB의 event를 가져오려면 JSON 형식으로 변환해 events에 넣어주면된다.
                    {
                        title:'일정',
                        start:'2021-05-26 00:00:00',
                        end:'2021-05-27 24:00:00' 
                        // color 값을 추가해 색상도 변경 가능 자세한 내용은 하단의 사이트 참조
                    }
                ], headerToolbar: {
                    center: 'addEventButton' // headerToolbar에 버튼을 추가
                }, customButtons: {
                    addEventButton: { // 추가한 버튼 설정
                        text : "일정 추가",  // 버튼 내용
                        click : function(){ // 버튼 클릭 시 이벤트 추가
                            $("#calendarModal").modal("show"); // modal 나타내기

                            $("#addCalendar").on("click",function(){  // modal의 추가 버튼 클릭 시
                                var content = $("#calendar_content").val();
                                var start_date = $("#calendar_start_date").val();
                                var end_date = $("#calendar_end_date").val();
                                
                                //내용 입력 여부 확인
                                if(content == null || content == ""){
                                    alert("내용을 입력하세요.");
                                }else if(start_date == "" || end_date ==""){
                                    alert("날짜를 입력하세요.");
                                }else if(new Date(end_date)- new Date(start_date) < 0){ // date 타입으로 변경 후 확인
                                    alert("종료일이 시작일보다 먼저입니다.");
                                }else{ // 정상적인 입력 시
                                    var obj = {
                                        "title" : content,
                                        "start" : start_date,
                                        "end" : end_date
                                    }//전송할 객체 생성

                                    console.log(obj); //서버로 해당 객체를 전달해서 DB 연동 가능
                                }
                            });
                        }
                    }
                },
                editable: true, // false로 변경 시 draggable 작동 x 
                displayEventTime: false // 시간 표시 x
            });
            calendar.render();
        });
    </script>
    <style>
        #calendarBox{
            width: 70%;
            padding-left: 15%;
        }

    </style>
</head>

<title>Insert title here</title>

</head>
<body>
   <div id="calendarBox">
        <div id="calendar"></div>
    </div>

    <!-- modal 추가 -->
    <div class="modal fade" id="calendarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">일정을 입력하세요.</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="taskId" class="col-form-label">일정 내용</label>
                        <input type="text" class="form-control" id="calendar_content" name="calendar_content">
                        <label for="taskId" class="col-form-label">시작 날짜</label>
                        <input type="date" class="form-control" id="calendar_start_date" name="calendar_start_date">
                        <label for="taskId" class="col-form-label">종료 날짜</label>
                        <input type="date" class="form-control" id="calendar_end_date" name="calendar_end_date">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-warning" id="addCalendar">추가</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal"
                        id="sprintSettingModalClose">취소</button>
                </div>
    
            </div>
        </div>
    </div>

</body>
<%-- ====
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

</html> --%>