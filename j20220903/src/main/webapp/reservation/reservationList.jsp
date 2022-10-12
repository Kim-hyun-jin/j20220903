<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 조회</title>
<!-- <link rel="stylesheet" type="text/css" href="reservation/revStyle.css">   -->
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
	#contents {
		overflow: scroll;

	}
	th {
		background: #D4F4FA;
	}
	#chk:hover {
		border-color: #DB9CFF;
		box-shadow: 0 0 10px #DB9CFF;
	}
</style>

<script src="http://code.jquery.com/jquery-1.6.4.js"></script>
<!-- <script type="text/javascript">
	if(document.getElementById("input_check").checked) {
	    document.getElementById("input_check_hidden").disabled = true;
	}

</script> -->
<%
	String contextLocal = request.getContextPath();
%>
<body>  

<%@ include file="../top-side.jsp" %>

	<form action="<%=context%>/reservationDel.do" id="table-style" method="post" >
<!-- 	<article id="table-style"> -->

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
			<th>선택</th><th>예약일</th><th>이름</th><th>의료과</th><th>의료진</th><th>예약시간</th>
			</tr>
			<c:if test="${totCnt>0}">
				<c:forEach var="reservation" items="${list }" varStatus="stat">
				
				<input type="hidden" name="reservation_date" value="${reservation.reservation_date}">
				<input type="hidden" name="reservation_hour" value="${reservation.reservation_hour}">
				<input type="hidden" name="doctor_no" value="${reservation.doctor_no}">

					<tr>
<%-- 						<td align="center"><input type="checkbox" name="chk" value="${reservation}">
						
						</td> --%>
						<td align="center"><input type="checkbox" name="chk" id="chk" value="${stat.index-1 }">
<!-- 						<input type="checkbox" name="chk" value='1' id="input_check"/>
						<input type="hidden" name="chk" value='0' id="input_check_hidden"/> -->
						
						
						</td>
						<td>${reservation.reservation_date}</td>
						<td>${reservation.patient_name}</td>
						<td>${reservation.department}</td>
						<td>${reservation.doctor_name}</td>
						<td>${reservation.reservation_hour}</td>
						
					</tr><p>
				</c:forEach>		
				
				<c:if test="${totCnt == 0}">
					<tr>
						<td colspan=7>데이터가 없네</td>
					</tr>
				</c:if>
			</c:if>
			
		</table>
			<%-- <input type="button" value="삭제" onclick="location.href='<%=context%>/reservationDel.do'" style="float: right"> --%>
			<!-- <input type="button" value="삭제" id="chkdelete" class="delbtn" onclick="deleteValue()" style="float: right"> -->
			<!-- <input type="button" value="삭제" id="chkdelete" class="delbtn" onclick="location.href='reservationDel.do'" style="float: right"> -->
			<input type="submit" value="삭제" style="float: right">
			<input type="button" value="등록" onclick="location.href='reservationReg.do'" style="float: right">

			
<!-- 			<input type="button" value="등록" onclick="alert(1)" style="float: right"> -->

 	 </form>



<!-- 	<article id="table-style">

 	 </article>
  	</div> -->
  	
<%@ include file="../footer-side.jsp" %>