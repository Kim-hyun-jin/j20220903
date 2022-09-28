<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
String context = request.getContextPath();
%>
<body>
	<c:if test="${result == 1 }">
		<script type="text/javascript">
			<%-- location.href="<%=context%>/mainView.do"; --%>
			location.href="<%=context%>/drugView.do?doctor_no=${doctor.doctor_no}";
		</script>
	</c:if>
	<c:if test="${result == 0 }">
		<script type="text/javascript">
			location.href="login/loginNot.jsp";
		</script>
	</c:if>
</body>
</html>