<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스케줄등록</title>
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
 <%@ include file="../top-side.jsp" %>
  	<article id="schedule" style="height: 663px;">		
		<form action="mainCalendarRegAct.do?doctor_no=${doctor_s.doctor_no}" method="post" id="mcra">
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
				<input id="scRe_table_btn" type="button" value="취소" onclick="location.href='mainCalendarView.do?doctor_no=${doctor_s.doctor_no}'">
		</form>

	 	 </article>

	<%@ include file="../footer-side.jsp" %>
