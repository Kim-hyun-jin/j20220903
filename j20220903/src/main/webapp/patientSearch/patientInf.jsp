<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.serachBox select {
   font: initial;
}
</style>
</head>
<%   String context = request.getContextPath();%>
<%-- url:"<%=context%>/ajaxTest1.do", 모델2에서도 앵커태그는 가능하다 --%>
<body>
	<%@ include file="top-side.html" %>
		<form action="" style="overflow: scroll; height: 100%;">
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
			
		</form>
	<%@ include file="footer.html" %>
</body>
</html>