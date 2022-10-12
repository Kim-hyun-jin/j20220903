<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진단수정하기</title>
<link type="text/css" href="patientManage/dia.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../top-side.jsp" %>
	<div class="mainContents">
	<div class="resultBox">
	<form action="diaModAct.do"  onsubmit="">
		<table class="inf">
			<tr><th>차트번호</th><td>${diaInf.chart_no } 
					<input type="hidden" name="chart_no" value="${diaInf.chart_no }">
					<input type="hidden" name="patient_no" value="${patientInf.patient_no }"> 
					</td></tr>
			<tr><th>환자명</th><td>${patientInf.patient_name }</td></tr>
			<tr><th>진료자</th><td>${diaInf.doctor_name }(${diaInf.department })</td></tr>
			<tr><th>증상</th><td><textarea rows="10"  cols="100" name="chart_symptom" style="width: 400px; height: 150px; resize: none;" required="required">${diaInf.chart_symptom }</textarea></td></tr>
			<tr><th>병명</th><td><textarea rows="10"  cols="100" name="chart_disease" style="width: 400px; height: 150px; resize: none;" required="required">${diaInf.chart_disease }</textarea></td></tr>
			<tr><th>처방약</th>
				<td>
				<select name="drug_list" multiple="multiple">
					<c:forEach var="drug" items="${drug }">
						<c:if test="${drugList.contains(drug.drug_code) }">
							<option value=${drug.drug_code } selected="selected">${drug.drug_name }</option></c:if>
						<c:if test="${!drugList.contains(drug.drug_code) }">
							<option value=${drug.drug_code }>${drug.drug_name }</option></c:if>
					</c:forEach>
				</select>
			<tr><th>진단날짜</th><td>${diaInf.chart_date }</td></tr>
		</table>
		<input type="submit" value="수정하기"><input type="button" value="진단목록으로 돌아가기" onclick="location.href='<%=context%>/diaHistroyView.do?patient_no=${patientInf.patient_no}'" >
		
	</form>
	</div>
	</div>
	<%@ include file="../footer-side.jsp" %>
</body>
</html>