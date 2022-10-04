<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	if(${result} > 0){
		
		alert("수정성공");
		
		<% request.getRequestDispatcher("profile/profile.jsp")
			.forward(request, response);%>
	}else{
		
		alert("수정실패");
		
	}
</script>
</body>
</html>