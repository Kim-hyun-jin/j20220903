<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   <link href='../css/fullcalendar/main.css' rel='stylesheet' />
   <script src='../css/fullcalendar/main.js'></script>
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
   <script type="text/javascript">
   document.addEventListener('DOMContentLoaded', function() {
       var calendarEl = document.getElementById('calendar');
       var calendar = new FullCalendar.Calendar(calendarEl, {
    	 initialView: 'dayGridMonth',
         locale: 'ko',
         dateClick: function(info) { /* 클릭해서 날짜 가져오기 */
        	    alert('Clicked on: ' + info.dateStr);   
        	  }
	       });
	       calendar.render();
	     });
   		function registeredSchedule() {
   			window.open("scheduleMod.jsp","팝업 테스트","width=400, height=300, top=10, left=10");
   			
		}
   

	    </script>
	    <script type="text/javascript">
	       
        	document.getElementById('currnetMonth').value= new Date().toISOString().slice(0, 7);
	    
	    </script>
	    
   		 <div id='calendar' style="width: 100; height: 100;" ></div>
   		 <!-- modal 추가 -->
    	<div class="popup_layer" id="popup_layer" style="display: none;">
		  <div class="popup_box">
		      <div style="height: 10px; width: 375px; float: top;">
		        <a href="javascript:closePop();"><img src="/static/img/ic_close.svg" class="m_header-banner-close" width="30px" height="30px"></a>
		      </div>
		      <!--팝업 컨텐츠 영역-->
		      <div class="popup_cont">
		          <h5> POPUP TILTE</h5>
		          <table>
		          <tr><td>제목</td><td><input type="text" name="subject"></td></tr>
		          <tr><td>시작일</td><td><input id="currnetMonth" type="date" name="startdate"></td></tr>
		          <tr><td>종료일</td><td><input type="date" name="enddate"></td></tr>
		          <tr><td>메모</td><td><input type="text" name="memo"></td></tr>		    
		          </table>
		      </div>
		      <!--팝업 버튼 영역-->
		      <div class="popup_btn" style="float: bottom; margin-top: 200px;">
		          <a href="registeredBtn()">등록</a>
		      </div>
		  </div>
		</div>
		
	    <input type="hidden" id="hiddenDate">
	    <input type="button" value="등록" onclick="registeredSchedule()">
	  	<input type="button" value="삭제">
 	 </article>
 	 

  	</div>
  
  	<div id="footer">
  		<h2>CareBare</h2>
  		서울 마포구 신촌로 176 중앙빌딩 / 대표자:정중앙
  		TEL:02-313-1711
  </div>
</body>
</html>