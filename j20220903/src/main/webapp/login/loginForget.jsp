<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사번/암호 찾기</title>
<script src="https://kit.fontawesome.com/54a6153010.js" crossorigin="anonymous"></script>
<link type="text/css" rel="stylesheet" href="login.css" >
</head>
<%
String context = request.getContextPath();
%>
<body>
	<div class="log_box">
		<span class="title">
			<h1>
				<i class="fa-solid fa-hand-holding-medical"></i>
				CareBare
			</h1>
		</span>
		
		<span class="forget"><b>사번</b>은 인사팀에 문의하여 주세요.</span>
		<span class="forget">인사팀📞 : 02-xxx-xxxx</span>
		
		<h2>암호 찾기</h2>
		<form action="<%=context %>/loginForget.do" method="get">
			<input type="text" class="id" id="doctor_no" name="doctor_no" placeholder="사번" required="required"><p>
			<input type="text" class="id" id="doctor_name" name="doctor_name" placeholder="이름" required="required"><p>
			<input type="submit" class="log" id="chk" value="찾기"><p>
		</form>
		<hr>
		<span class="ment">
				로그인 화면으로 돌아가시려면, <a href="loginForm.jsp">여기</a>를 눌러주세요.
		</span>
	</div>	
</body>
</html>