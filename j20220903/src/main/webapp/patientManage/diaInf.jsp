<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진단상세정보</title>
<style>
.main {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 20px;
	

 }
 .table_content {
		margin: 20px;
		padding: 80px;
		border: 5px solid rgba(100, 149, 237, 0.5);
		border-color: cornflowerblue;
		padding-left: 30px;
		padding-bottom: 60px;
 }
 
.table_row {
		margin: 20px;
		padding: 20px;
}
th {
	padding-right: 50px;
	padding-left: 20px;
}
td {
	padding: 20px;
}
.button {
	flex-direction: column;
	padding: 10px;
}
</style>
</head>
<body>
	<%@ include file="../top-side.jsp" %>
	
	<div class="main">
		<table class="table_content">
			<tr class="table_row"><th>차트번호</th><td>${diaInf.chart_no }</td></tr>
			<tr class="table_row"><th>환자명</th><td>${patientInf.patient_name }</td></tr>
			<tr class="table_row"><th>진료과</th><td>${patientInf.department }</td></tr>
			<tr class="table_row"><th>진단일</th><td>${diaInf.chart_date }</td></tr>
			<tr class="table_row"><th>진단소견</th><td>${diaInf.chart_symptom }</td></tr>
			<tr class="table_row"><th>병명</th><td>${diaInf.chart_disease }</td></tr>
			<tr class="table_row"><th>처방약</th><td>
								<c:forEach var="dd" items="${diaDrug }">
									${dd.drug_name }(${dd.drug_class })<br>
								</c:forEach>
								</td></tr>
			
		</table>
		
		<div class="button"><input type="button" value="진단상세수정"></div>
		<div class="button"><input type="button" value="뒤로가기" onclick="location.href='diaHistroyView.do?patient_no=${patientInf.patient_no}'"></div>
	</div>

	<%@ include file="../footer-side.jsp" %>
</body>
</html>