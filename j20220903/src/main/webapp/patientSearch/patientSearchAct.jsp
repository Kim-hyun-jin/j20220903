<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환자정보검색</title>
<link type="text/css" href="patientSearch/search.css" rel="stylesheet">
<link type="text/css" href="patientSearch/patientSearch.css" rel="stylesheet">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function dateSel(){
		var state = jQuery('#diaDate option:selected').val();
		<c:forEach var="dh" items="${dh }" varStatus="stat">
		var rs = ".rs"+${stat.index};
		if ( state == ${stat.index} ) {
			jQuery(rs).show();
		} else {
			jQuery(rs).hide();
		}
		</c:forEach>
	};
	if (${list_pat.isEmpty() }) {
		alert("검색 결과가 없습니다.")
	}
</script>
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
								<option value="">선택하지 않음</option>
								<c:forEach var="dep" items="${dep }">
									<c:choose>
										<c:when test="${dep==department }"><option value="${dep }" selected="selected">${dep }</option></c:when>
										<c:otherwise><option value="${dep }" >${dep }</option></c:otherwise>
									</c:choose>
								</c:forEach>
<!-- 							<option value="간담췌외과" >간담췌외과</option>
								<option value="소화기내과">소화기내과</option>
								<option value="신장내과">신장내과</option>
								<option value="정형외과">정형외과</option>
								<option value="호흡기내과">호흡기내과</option>
								<option value="흉부외과">흉부외과</option> -->
						</select></td>
					</tr> 
					<tr>
						<th>의사명</th>
						<td><select name="doctorName">
								<option value="">선택하지 않음</option>
								<c:forEach var="name" items="${nam }">
									<c:choose>
										<c:when test="${name==doctorName }"><option value=${name } selected="selected">${name }</option></c:when>
										<c:otherwise><option value=${name }>${name }</option></c:otherwise>
									</c:choose>
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
						<input type="date" name="reservationDate" class="select" value="${reservationDate }"></td>
					</tr> 
					<tr>
						<th>환자명</th>
						<td><input type="text" name="patientName" id="patientName" value="${patientName }"></td>
						<td><input type="submit" value="검색"></td>
					</tr> 
				</table>
			</form>	
			<div class="searchResult">
				<table class="srTable">
					<tr><th style="width:52px ">환자<br>번호</th><th style="width:74px ">환자명</th><th style="width:73px ">담당의</th><th style="width:122px ">진료과</th><th style="width:109px ">예약일</th></tr>
				  	<c:forEach var="patient" items="${list_pat }" varStatus="stat">
						<tr class="patient_search" onclick="location.href='<%=context%>/patientSearchSelect.do?patient_no=${patient.patient_no }'">
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
		<div class="patientInf1">
			<table class="inf">
				<tr> <th>환자번호</th> 	<td>${pi.patient_no }</td> </tr>
				<tr> <th>환자이름</th> 	<td>${pi.patient_name }</td> </tr>
				<tr> <th>성별</th> 		<td>${pi.gender }</td> </tr>
				<tr> <th>생년월일</th> 	<td>${pi.birth }</td> </tr>
				<tr> <th>주소</th> 		<td>${pi.address }</td> </tr>
				<tr> <th>연락처</th> 	<td>${pi.contact }</td> </tr>
				<tr> <th>보호자연락처</th><td>${pi.protector_contact }</td> </tr>
				<tr> <th>주민번호</th> 	<td>${pi.social_number }</td> </tr>	
				<tr> <th>담당의</th> 	<td>${pi.doctor_name }(${pi.department })</td> </tr>
			</table>
		</div>
		<div class="patientInf3">
			<table class="inf">
				<tr><th>예약정보</th><td>
				<c:if test="${pi.reservation_date.get(0)==null }">없음.</td></c:if>
				<c:if test="${pi.reservation_date.get(0)!=null }">
				<c:forEach var="date" items="${pi.reservation_date }" varStatus="stat">
						<fmt:parseDate value = "${date }"  pattern = "yy/MM/dd" var = "dateRs"/>
						<fmt:formatDate value="${dateRs }" pattern="yyyy년 MM월 dd일"/>
						${pi.reservation_hour.get(stat.index) }시<br>
				</c:forEach>
				</c:if></td></tr>
			</table>
		</div>
		<div class="patientInf2">
			<c:if test="${dh.isEmpty() }"><table class="inf"><tr><th>진단내역</th><td>없음.</td></tr></table><br></c:if>
			<c:if test="${!dh.isEmpty() }">
				<select name="diaDate" id="diaDate" onchange="dateSel()">
					<option>진단내역보기</option>
					<c:forEach var="dh" items="${dh }" varStatus="stat">
						<option value="${stat.index }">${dh.chart_date }/${dh.chart_disease }/${dh.doctor_name }</option>
					</c:forEach>
				</select>
	 		<c:forEach var="dh" items="${dh }" varStatus="stat">
	 		<div class="rs${stat.index }" style="display: none;">
	 		<table class="inf">
	 			<tr> <th>차트번호</th> 	<td>${dh.chart_no }</td> </tr>
	 			<tr> <th>진단의사</th> 	<td>${dh.doctor_name } (${dh.department })</td> </tr>
	 			<tr> <th>증상</th> 		<td>${dh.chart_symptom }</td> </tr>
	 			<tr> <th>병명</th> 		<td>${dh.chart_disease }</td> </tr>
	 			<tr> <th>진단일</th> 	<td>${dh.chart_date }</td> </tr>
	 			<tr> <th>처방약</th><td>	
							<c:if test="${rsdd.get(stat.index).isEmpty() }">처방약물 없음<br></c:if>
							<c:if test="${!rsdd.get(stat.index).isEmpty() }">
							<c:forEach var="rsdd" items="${rsdd.get(stat.index) }" varStatus="stat2">
								${stat2.index+1}. ${rsdd.drug_name}(${rsdd.drug_class })<br>
							</c:forEach></c:if>
					</td></tr>
	 		</table>
			</div></c:forEach></c:if>
		</div>
		</div>
	</div>
	<%@ include file="../footer-side.jsp" %>
</body>
</html>