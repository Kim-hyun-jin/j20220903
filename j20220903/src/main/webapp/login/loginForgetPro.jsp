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
	<c:choose>
		<c:when test="${password == '' }">
			<script type="text/javascript">
				alert("사번 또는 이름이 일치하지 않습니다.");
				location.href="login/loginForget.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("당신의 암호는 ${password} 입니다.")
				location.href="login/loginForget.jsp";
			</script>
		</c:otherwise>
	</c:choose>
</html>