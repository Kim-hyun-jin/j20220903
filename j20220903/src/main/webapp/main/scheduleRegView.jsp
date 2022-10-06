<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$("#addCalendar_btn").on("click",function(){  // 일정버튼 클릭시 실행.
	  
		  var title = $("#schedule_title").val();
          var content = $("#schedule_content").val();
          var start_date = $("#schedule_startdate").val();
          var end_date = $("#schedule_enddate").val();
          
          
          //내용 입력 여부 확인
          if(content == null || content == ""){
              alert("내용을 입력하세요.");
              return;
          }else if(start_date == "" || end_date ==""){
              alert("날짜를 입력하세요.");
              return;
          }else if(new Date(end_date)- new Date(start_date) < 0){ // date 타입으로 변경 후 확인
              alert("종료일이 시작일보다 먼저입니다.");
              return;
          }else{ // 정상적인 입력 시
              var obj = {
                  "title" : content,
                  "start" : start_date,
                  "end" : end_date
              }//전송할 객체 생성
              
              console.log(obj); //서버로 해당 객체를 전달해서 DB 연동 가능
              
                    }
                 }
              
        		});	
          }
      }

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
		height: 600px;
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
	
	
	#scRe_table {
		background-color: lightsteelblue;	

	}
	
	#scRe_table_btn {
		background-color: cornflowerblue;
		
	}
	
	#addCalendar_btn{
		background-color: cornflowerblue;
	}
	
	#mcra{
		float: left;
		position: relative;
		left:27%;
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
		<form action="mainCalendarRegAct.do" method="post" id="mcra">
		<input type="hidden" name="schedule_no" value="${schedule_no}">
		<input type="hidden" name="doctor_no" value="${doctor_no}">	
			<table border="1" id="scRe_table">
			<caption><h2>스케줄 등록</h2></caption>
			<tr><td>제목</td><td>
			<c:if test="${schedule_no==0}">
			  	<input type="text" id="schedule_title" name="schedule_title" required="required">
			</c:if></td></tr>
			<tr><td>시작일</td><td><input type="date" id="schedule_startdate" name="schedule_startdate" ></td></tr>
			<tr><td>종료일</td><td><input type="date" id="schedule_enddate" name="schedule_enddate"></td></tr>
			<tr><td>내용</td><td><textarea rows="5" cols="25" id="schedule_content" name="schedule_content" required="required"></textarea></td></tr>
			</table>
				<p>
			    <input id="addCalendar_btn" type="submit" value="등록">
				<input id="scRe_table_btn" type="button" value="취소" onclick="location.href='mainCalendarView.do'">
		</form>

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