<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진단등록</title>
<link type="text/css" href="patientManage/dia.css" rel="stylesheet">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
/*  	function addList() {
		var html = `<article class="drugCnt"><select name="drug_list" onselect="checkDupl()">
						<c:forEach var="drug" items="${drug }" >
							<option value=${drug.drug_code }>${drug.drug_name }</option>
						</c:forEach>
					</select></article>`;
		$('#drug_list').append(html);
	};
	function delList() {
		$('.drugCnt').last().remove();
	};

	function checkDupl() {
		if ($(this).val()==$("select[name=drug_list] option:selected").val()) {
			alert("중복된 값을 입력 할 수 없습니다.");
		}
	} */
</script>
</head>
<body>
	<%@ include file="../top-side.jsp" %>
	<div class="mainContents">
	<div class="resultBox">
		<form action="<%=context %>/diaRegAct.do">
			<input type="hidden" name="patient_no" value="${patient_no }">
			<table border="1">
			<caption><h2>진단 등록</h2></caption>
			<tr><td>증상</td><td><textarea rows="10"  cols="100" name="chart_symptom" style="width: 400px; height: 150px; resize: none;" required="required"></textarea></td></tr>
			<tr><td>병명</td><td><textarea rows="10"  cols="100" name="chart_disease" style="width: 400px; height: 150px; resize: none;" required="required"></textarea></td></tr>
			<tr><td>처방약</td>
				<td id="drug_list">
<!--  				<article class="drugCnt"><select name="drug_list" onchange="checkDupl()">
					<option disabled="disabled" selected="selected">약물을 선택하세요</option> -->
				<article class="drugCnt"><select name="drug_list" onchange="checkDupl()" multiple="multiple">
						<c:forEach var="drug" items="${drug }" >
							<option value=${drug.drug_code }>${drug.drug_name }</option>
						</c:forEach>
					</select></article>
<!--  				</td><td><input type="button" onclick="addList()" value="약품 추가"><br>
						 <input type="button" onclick="delList()" value="약품 제거"></td>
			</tr> -->
			</table>
				<p>
			    <input type="submit" value="등록">
				<input type="button" value="취소" onclick="location.href='diaHistroyView.do?patient_no=${patient_no}'">
		</form>
	</div>
	</div>
	<%@ include file="../footer-side.jsp" %>
</body>
</html>