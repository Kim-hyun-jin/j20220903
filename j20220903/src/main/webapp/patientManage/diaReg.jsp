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
	function addList() {
		var html = '<br><select name="drug_list"><c:forEach var="drug" items="${drug }" ><option value=${drug.drug_code }>${drug.drug_name }</option></c:forEach></select>';
		$('#drug_list').append(html);
	}
</script>
<%String context = request.getContextPath();%>
</head>
<body>
<div id="contents">
	  	<article id="schedule">
	  		<p> 진단등록 	  		
		<form action="<%=context %>/diaRegAct.do">
			<input type="hidden" name="patient_no" value="${patient_no }">
			<table border="1">
			<caption><h2>진단 등록</h2></caption>
			<tr><td>증상</td><td><input type="text" id="chart_symptom" name="chart_symptom" required="required"></td></tr>
			<tr> <td> <textarea rows="4"  cols="50" style="width: 150px; height: 50px; resize: none;"></textarea> </td> </tr>
			<tr><td>병명</td><td><input type="text" id="chart_disease" name="chart_disease" required="required"></td></tr>
			<tr><td>처방약</td>
				<td id="drug_list">
					<select name="drug_list">
					<c:forEach var="drug" items="${drug }" >
						<option value=${drug.drug_code }>${drug.drug_name }</option>
					</c:forEach>
					</select>
				</td><td><input type="button" onclick="addList()" value="약품 추가하기"></td>
			</tr>
			</table>
				<p>
			    <input type="submit" value="등록">
				<input type="button" value="취소" onclick="location.href='diaHistroyView.do?patient_no=${patient_no}'">
		</form>
	 	</article>
	</div>
</body>
</html>