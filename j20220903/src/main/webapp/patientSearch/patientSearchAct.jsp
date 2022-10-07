<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환자 정보 검색</title>
<style type="text/css">
	.mainContents{
		min-width: 1000px;
		background-color: lightsteelblue;
		display: inline-block;
		height: 100%;
		width: 100%;
		position: relative;
	}
	.leftContents {
		width : 43%;
		height: 90%;
		float: left;
		margin-top: 2%;
		margin-left: 5%;
		margin-bottom: 5%;
		position: relative;
	}
	.searchBox {
		border: 3px solid black;
		height: 29%;
		margin-bottom: 1%;
		background-color: white;
	}
	.searchResult {
		border: 3px solid black;
		height: 70%;
		overflow: scroll;
		background-color: white;
	}
	.patientInf {
		border: 3px solid black;
		width: 43%;
		height: 90%;
		float: right;
		margin-top: 2%;
		margin-right: 5%;
		margin-bottom: 5%;
		overflow: scroll;
		background-color: white;
	}
	td select {
		font: initial;
	}
	.searchResult table, .searchResult td, .searchResult th {
		min-width:100%;
		border: 1px solid black;
		border-collapse:collapse;
		font-size: 22pt;
		width: auto;
	}
</style>
</head>
<body>
	<%@ include file="../top-side.jsp" %>
		<div class="mainContents">
		<div class="leftContents">
			<form class="searchBox" action="<%=context %>/patientsearchAct.do">
				<table>
					<tr>
						<th>진료과</th>
						<td><select name="department">
								<option value="" selected="selected">선택하지 않음</option>
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
						<td><select name="doctorName">
								<option value="" selected="selected">선택하지 않음</option>
								<c:forEach var="doctor" items="${list_doc }">
									<option value=${doctor.doctor_name }>${doctor.doctor_name }</option>
								</c:forEach>
						</select></td>
					</tr> 
					<tr>
						<th>예약일</th>
						<td><%-- <select name="reservationDate">
								<option value="" selected="selected">선택하지 않음</option>
								<c:forEach var="reservationDate" items="${list_res_date }">
									<option value=${reservationDate }>${reservationDate }</option>
								</c:forEach>
						</select> --%>
						<input type="date" name="reservationDate"></td>
					</tr> 
					<tr>
						<th>환자명</th>
						<td><input type="text" name="patientName" id="patientName"></td>
						<td><input type="submit" value="검색"></td>
					</tr> 
				</table>
			</form>	
			<div class="searchResult">
				<table class="srTable">
					<tr><td>환자<br>번호</td><td>환자명</td><td>담당의</td><td>진료과</td><td>예약일</td></tr>
				  	<c:forEach var="patient" items="${list_pat }" varStatus="stat">
						<tr onclick="location.href='<%=context%>/patientSearchSelect.do?patient_no=${patient.patient_no }'">
							<td>${patient.patient_no }</td>
							<td>${patient.patient_name }</td>
							<td>${searchSet.get(stat.index).get(2)}</td>
							<td>${searchSet.get(stat.index).get(3)}</td>
							<td>
								<c:if test="${searchSet.get(stat.index).get(4)==null }">-</c:if>
								<c:if test="${searchSet.get(stat.index).get(4)!=null }">${searchSet.get(stat.index).get(4)}</c:if>
							</td>
								
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="patientInf">
			환자번호 : ${pi.patient_no }<br>
			환자이름 : ${pi.patient_name }<br>
			성별 : ${pi.gender }<br>
			생년월일 : ${pi.birth }<br>
			주소 : ${pi.address }<br>
			연락처 : ${pi.contact }<br>
			보호자연락처 : ${pi.protector_contact }<br>
			주민번호 : ${pi.social_number }<br>
			담당의 : ${pi.doctor_no }<br>
			비밀번호 : ${pi.password }<br>
			의사이름 : ${pi.doctor_name }<br>
			진료과 : ${pi.department }<br>
			의사사진 : ${pi.image }<br>
			<br>
			<c:if test="${dh.isEmpty() }">진단내역 : 없음.<br></c:if>
			<c:if test="${!dh.isEmpty() }">
			<c:forEach var="dh" items="${dh }" varStatus="stat">
			<h1> 진단내역 : ${stat.index+1 } </h1>
					차트번호 : ${dh.chart_no }<br>
					진단의사 : ${dh.doctor_name } (${dh.department })<br>	
					증상 : ${dh.chart_symptom }<br>
					병명 : ${dh.chart_disease }<br>
					진단일시 : ${dh.chart_date }<br>
					<h3>처방약</h3>
							<c:if test="${rsdd.isEmpty() }">처방약물 없음<br></c:if>
							<c:if test="${!rsdd.isEmpty() }">
							<c:forEach var="rsdd" items="${rsdd.get(stat.index) }" varStatus="stat2">
								${stat2.index+1}. ${rsdd.drug_name}(${rsdd.drug_class })<br>
							</c:forEach></c:if>
			</c:forEach></c:if><p>
			예약일시<br>
			<c:if test="${pi.reservation_date.get(0)==null }">예약정보 없음.</c:if>
			<c:if test="${pi.reservation_date.get(0)!=null }">
			<c:forEach var="date" items="${pi.reservation_date }" varStatus="stat">
					${date } ${pi.reservation_hour.get(stat.index) }시<br>
			</c:forEach></c:if>
		</div>
	</div>
	<%@ include file="../footer-side.jsp" %>
</body>
</html>