<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정결과</title>
<%   String context = request.getContextPath();%>
<script>
	<% int result = (Integer) request.getAttribute("result");
		if(result > 0) {%>
		alert('수정성공');
		location.href="<%=context %>/profile.do";
	<%} else {%>
		alert('수정실패');
		location.href="<%=context %>/profileModForm.do";
	<%}%>
</script>
	
</head>
<body>

</body>
</html>