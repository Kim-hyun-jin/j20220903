<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- <%
   String context = request.getContextPath();
%>
url:"<%=context%>/ajaxTest1.do", 모델2에서도 앵커태그는 가능하다 --%>
<body>
<%@ include file="top-side.html" %>
<form class="searchBox" style="background-color: white; width: 50%;" action="../patientsearchAct.do" >
	<table>
		<tr>
			<th>진료과</th>
			<td><select name="department">
					<option value="*" selected="selected">선택하지 않음</option>
					<option value="간담췌외과" >간담췌외과</option>
					<option value="소화기내과">소화기내과</option>
					<option value="신장내과">신장내과</option>
					<option value="정형외과">정형외과</option>
					<option value="호흡기내과">호흡기내과</option>
					<option value="흉부외과">흉부외과</option>
			</select></td>
		</tr> 
		<tr>
			<th>의사명</th>
			<td><select name="doctor_name">
					<option value="*" selected="selected">선택하지 않음</option>
					<c:forEach var="doctor" items="${list_doc }">
						<option value=${doctor.GetDoctor_Name }>${doctor.GetDoctor_Name }</option>
					</c:forEach>
			</select></td>
		</tr> 
		<tr>
			<th>의사명</th>
			<td><select name="reservation">
					<option value="*" selected="selected">선택하지 않음</option>
					<c:forEach var="reservation" items="${list_res }">
						<option value=${reservation.getReservation_Date }>${reservation.getReservation_Date }</option>
					</c:forEach>
			</select></td>
		</tr> 
		<tr>
			<th>환자명</th>
			<td><input type="text" name="patient_name" id="patient_name"></td>
			<td><input type="submit" value="검색"></td>
		</tr> 
	</table>
</form><p>
<form class="searchResult" style="background-color: white; width: 50%;" action="../patientSearchSelect.do">
	<table>
		<thead><tr>
			<td>환자번호</td>
			<td>환자명</td>
			<td>담당의</td>
			<td>진료과</td>
			<td>예약일</td>
		</tr></thead>
		<%-- <c:forEach var=patient items="${list_pat }">
			<tr><td>${patient.getPatient_Num }</td>
				<td>${patient.getPatient_Num }</td>
				<td>${patient.getPatient_Num }</td>
				<td>${patient.getPatient_Num }</td>
				<td>${patient.getPatient_Num }</td>
			</tr>
		</c:forEach> --%>
	</table>
</form>
<%@ include file="footer.html" %>
<div>
	
</div>
</body>
</html>