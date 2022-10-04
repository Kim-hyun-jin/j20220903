<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
	<c:if test="${result > 0 }">
		<script type="text/javascript">
			alert("입력완료");
			location.href = "shareBoardView.do?pageNum=${pageNum}";
		</script>
	</c:if>
	<c:if test="${result == 0 }">
		<script type="text/javascript">
			alert("입력안됨");
			location.href = "shareBoardRegView.do?shareboard_no=${shareboard_no}&pageNum=${pageNum}";
		</script>
	</c:if>


</body>
</html>