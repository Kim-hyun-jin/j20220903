<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
		var drugCnt=0;
	function addList() {
		drugCnt ++;
		var html = '<article class="drugCnt"><select name="drug_list"><c:forEach var="drug" items="${drug }" ><option value=${drug.drug_code }>${drug.drug_name }</option></c:forEach></select></article>';
		$('#drug_list').append(html);
	}
	function delList() {
		$('.drugCnt').last().remove();
	}
</script>
</head>
<body>
	<%@ include file="../top-side.jsp" %>
		<form action="<%=context %>/diaRegAct.do">
			<input type="hidden" name="patient_no" value="${patient_no }">
			<table border="1">
			<caption><h2>진단 등록</h2></caption>
			<tr><td>증상</td><td><textarea rows="10"  cols="100" name="chart_symptom" style="width: 400px; height: 150px; resize: none;" required="required"></textarea></td></tr>
			<tr><td>병명</td><td><textarea rows="10"  cols="100" name="chart_disease" style="width: 400px; height: 150px; resize: none;" required="required"></textarea></td></tr>
			<tr><td>처방약</td>
				<td id="drug_list">
				</td><td><input type="button" onclick="addList()" value="약품 추가"><br>
						 <input type="button" onclick="delList()" value="약품 제거"></td>
			</tr>
			</table>
				<p>
			    <input type="submit" value="등록">
				<input type="button" value="취소" onclick="location.href='diaHistroyView.do?patient_no=${patient_no}'">
		</form>
	<%@ include file="../footer-side.jsp" %>
</body>
</html>