<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정결과</title>
<%   String context = request.getContextPath();%>
<c:if test="${updateResult > 0}">
	<script>
		alert('수정성공');
		location.href='<%=context%>/profile.do';
	</script>
</c:if>
<c:if test="${updateResult == 0}">
	<script>
		alert('수정실패');
		location.href='<%=context%>/profileModView.do';
	</script>
</c:if>
	
</head>
<body>

</body>
</html>