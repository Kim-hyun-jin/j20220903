<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 조회</title>
<link rel="stylesheet" type="text/css" href="reservation/revStyle.css">  
<style type="text/css">
	table tr td {
		width:150px; 
		height:30px;
		font-size:28px;
	}
	table tr td checkbox {
		width:15px;
		height:15px;
	}

	table {
		background: cornflowerblue;
	}
</style>
<%
	String context = request.getContextPath();
%>

<body>  
<script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
<script type="text/javascript">
	function getReturnValue(returnValue) {
		var returnValue = $.parseJSON(returnValue);
		
		console.log(JSON.stringify(returnValue));
	  	var nameStr = JSON.stringify(returnValue.patient_name);
	  	var numStr = JSON.stringify(returnValue.patient_no);
	  	var genderStr = JSON.stringify(returnValue.gender);
	  	var birthStr = JSON.stringify(returnValue.birth);
	  	var addressStr = JSON.stringify(returnValue.address);
/* 	  	var doctornameStr = JSON.stringify(returnValue.doctor_name); */

	  
	
	  
	  	nameStr = nameStr.replaceAll('"', '')
	  	numStr = numStr.replaceAll('"', '')
	  	genderStr = genderStr.replaceAll('"', '')
	  	birthStr = birthStr.replaceAll('"', '')
	  	addressStr = addressStr.replaceAll('"', '')
/*  	  	doctornameStr = doctornameStr.replaceAll('"', '')  */

	  	
	  	$("#name").val(nameStr);
	  	$("#num").val(numStr);
	  	$("#gender").val(genderStr);
	  	$("#birth").val(birthStr);
	  	$("#address").val(addressStr);
/*  	  	$("#doctorname").val(addressStr);  */

	}

</script>
  	<div id="header">
  		<a href="3-layout.html" class="header_logo"><i class="fa-solid fa-hand-holding-medical"></i> CareBare</a>
  		<span class="header_page">예약조회</span>
  		<span class="header_name">김준완</span>
  		<a href="profile.jsp" class="header_image"><img id="myphoto" alt="" src="myphoto.png" style="width: 60px"></a>
  	</div>
  	<div id="left-sidebar">
   	
  			<div class="main_menu_btn">
				<a href="">환자정보검색</a>
			</div>
			<div class="main_menu_btn">
				<a href="reservation.jsp">예약조회</a> 
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
  	
  		

		<form id="table-style" action="<%=context %>/reservationRegAct.do" >
	
			<table border="1">
			 <colgroup>
			 	<col width="8%">
			 	<col width="15%">
			 	<col width="10%">
			 	<col width="15%">
			 	<col width="10%">
			 	<col width="10%">
			 </colgroup>
				<tr>
					<th>이름</th><th>환자번호</th>
					<!-- <th><input id="name" type="text" value=""><input type="button" value="검색" onclick="window.open('reservationSearch.do')"></th> -->
					<th>성별</th><th>생년월일</th>
					
					<%-- <tr><td>제목</td><td>${board.subject}</td></tr>  --%>
				</tr>
				<tr><td><input id="name" name="name" type="text" value="" style="text-align:center; width:160px; "><input type="button" value="조회" onclick="window.open('<%=context%>/reservationSearch.do')"></td>
					<td><input id="num" name="patient_no" type="text" value="" style="text-align:center; width:130px;" ></td>
					<td><input id="gender" name="gender" type="text" value="" style="text-align:center; width:150px;"></td>
					<td><input id="birth" name="birth" type="text" value="" style="text-align:center; width:180px;"></td>
					<!-- <input type="hidden" id="patientno" name="patientno"> -->
				</tr>
				<tr>
					<th colspan="4">주소</th>
				</tr>
				<tr>
					<td colspan="4"><input id="address" type="text" value="" style="text-align:center; width:715px; "></td>
				</tr>
				<tr>
					<th>예약일</th><th>예약시간</th><th colspan="2">의료진</th>
				</tr>
				<tr>
					<td><input id="reservation_date" name="reservation_date" type="text" value="YY/MM/DD"></td>
					<td><input id="reservation_hour" name="reservation_hour" type="text" value="HH" style="width:120px;"></td>
					<td colspan="2" style="text-align:center; width:200px;" ><select name="doctor_no" >
							<option value="" selected="selected" colspan="2" style="text-align:center; width:300px;" >-의료진 선택-</option>
							<c:forEach var="doctor" items="${list_doc }">
								<option  value=${doctor.doctor_no } style="text-align:center; width:200px;">${doctor.doctor_name }</option>
							</c:forEach>
					</select></td>
				</tr>
<%-- 				<tr>
					<th>예약시간</th>
				</tr>
				<tr>
					<td><input id="reservation_hour" name="reservation_hour" type="text" value="HH"></td>									
				</tr>
				<tr>
					<th>의료진</th>
				</tr>
				<tr>
					<td><select name="doctor_no">
							<option value="" selected="selected">-의료진 선택-</option>
							<c:forEach var="doctor" items="${list_doc }">
								<option value=${doctor.doctor_no }>${doctor.doctor_name }</option>
							</c:forEach>
					</select></td>
				</tr> --%>

				<c:if test="${totCnt>0}">
					<c:forEach var="reservation" items="${list}">
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr><p>		
					</c:forEach>
					<c:if test="${totCnt == 0}">
						<tr>
							<td colspan=7>데이터가 없네</td>
						</tr>
					</c:if>
				</c:if>
				
			</table>
			<!-- <input type="button" value="저장" onclick="location.href='../reservationRegAct.do'" style="float: right"> -->
			<input type="submit" value="등록" style="float: right;"> 

	
	 	 </form>
  	</div>
  	
  	<div id="footer">
  		<h2>CareBare</h2>
  		서울 마포구 신촌로 176 중앙빌딩 / 대표자:정중앙
  		TEL:02-313-1711
	</div>
</body>

</html>
  	
 