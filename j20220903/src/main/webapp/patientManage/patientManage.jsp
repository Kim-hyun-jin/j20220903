 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>


<body>
<%@ include file="top-side.html" %>


  	
  	<div id="contents">
  		
  		<table class="patient_manage_table" border="2">
  		<caption>환자관리</caption>
	  		<tr><th>환자번호</th><th>환자이름</th><th>생년월일</th><th>성별</th><th>연락처</th><th>보호자연락처</th><th>주소</th><th>버튼</th></tr>
	  		<tr><td>${patient_no}</td><td>장하영</td><td>생년월일</td><td>여</td><td>010-1111-2222</td><td>010-1111-2222</td><td>주소</td></tr>
	  		<tr><td>${patient_no}</td><td>장하영</td><td>생년월일</td><td>여</td><td>010-1111-2222</td><td>010-1111-2222</td><td>주소</td></tr>
	  		<tr><td>${patient_no}</td><td>장하영</td><td>생년월일</td><td>여</td><td>010-1111-2222</td><td>010-1111-2222</td><td>주소</td></tr>
	  		
   		
  		</table>
  		
	   <c:forEach  var="namelilst" items="${patient_name_list}">
    			
  					<p>${namelist.patient_name}</p>
  				
	   </c:forEach>
  		
  		<div class="button">
	  		<div class="patient_manage_button">
	  			<input type="button" onclick="location.href='myPatientListView.do'" value="내환자목록">
	  			<input type="button" onclick="patientManage/myPatientListView.do" value="내환자목록">
	  			
	  			<!-- 반복문으로 처리할 예정 -->
	  			<input type="button" onclick="location.href='patientManage/patientManageDetail.jsp?patient_no=${patient_no}'" value="자세히보기">
	  			<input type="button" onclick="location.href='patientManage/patientManageDetail.jsp?patient_no=${patient_no}'" value="자세히보기">
	  			<input type="button" onclick="location.href='patientManage/patientManageDetail.jsp?patient_no=${patient_no}'" value="자세히보기">
	  			<input type="button" onclick="location.href='patientManageDetail.jsp?patient_no=${patient_no}'" value="자세히보기">
	  			<input type="button" onclick="location.href='patientManageDetail.jsp?patient_no=${patient_no}'" value="자세히보기">
	  		</div>
	  		
	  		<div class="patient_manage_button">
	  		
	  		</div>
	  		<div class="patient_manage_button">
	  		
	  		</div>
  		</div>
  		
  	</div>
  	
  	
  	<div id="footer">
  		<h2>CareBare</h2>
  		서울 마포구 신촌로 176 중앙빌딩 / 대표자:정중앙
  		TEL:02-313-1711
  	</div>
  	
<%@ include file="footer.html" %>
</body>
</html>