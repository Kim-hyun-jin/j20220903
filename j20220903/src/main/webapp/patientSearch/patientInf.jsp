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
		<form action="">
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
			예약일시<br><c:forEach var="date" items="${pi.reservation_date }" varStatus="stat">
						${date } ${pi.reservation_hour.get(stat.index) }시<br>
						</c:forEach>
		</form>
	<%@ include file="footer.html" %>
</body>
</html>