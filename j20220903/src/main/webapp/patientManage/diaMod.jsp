<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../top-side.jsp" %>
	<div>
		<table>
			<tr><th>차트번호</th><td>${patientInf.chart_no }</td></tr>
			<tr><th>이름</th><td>${patientInf.patient_name }</td></tr>
			<tr><th>진료과</th><td>${patientInf.department }</td></tr>
			<tr><td>증상</td><td><textarea rows="10"  cols="100" name="chart_symptom" style="width: 400px; height: 150px; resize: none;" required="required">{diaInf.chart_symptom }</textarea></td></tr>
			<tr><td>병명</td><td><textarea rows="10"  cols="100" name="chart_disease" style="width: 400px; height: 150px; resize: none;" required="required">{diaInf.chart_disease }</textarea></td></tr>
			<tr><td>처방약</td>
				<td id="drug_list">
				<article class="drugCnt"><select name="drug_list" onselect="checkDupl()" multiple="multiple">
						<c:forEach var="drug" items="${drug }">
							<c:if test="${drugList.includes(drug.drug_code) }">
							<option value=${drug.drug_code } selected="selected">${drug.drug_name }</option>
							</c:if>
							<c:if test="${!drugList.includes(drug.drug_code) }">
							<option value=${drug.drug_code } selected="selected">${drug.drug_name }</option>
							</c:if>
							<option value=${drug.drug_code }>${drug.drug_name }</option>
						</c:forEach>
					</select></article>
			<tr><th>진단날짜</th><td>${diaInf.chart_date }</td></tr>
			<tr><th>처방약</th><td>
								<c:forEach var="dd" items="${diaDrug }">
									${dd.drug_name }(${dd.drug_class })<br>
								</c:forEach>
								</td></tr>
		</table>
	</div>
	<%@ include file="../footer-side.jsp" %>
</body>
</html>