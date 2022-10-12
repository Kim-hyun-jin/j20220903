<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공</title>
<script src="https://kit.fontawesome.com/54a6153010.js" crossorigin="anonymous"></script>
<%   String context = request.getContextPath();%> 
<link type="text/css" rel="stylesheet" href="<%=context %>/login/login.css" >
</head>
<body>
	<!-- 전체 박스 -->
	<div class="log_box">
		<span class="title">
			<h1>
				<i class="fa-solid fa-hand-holding-medical"></i>
				CareBare
			</h1>
			<h2>회원 가입을 축하합니다!🎉</h2>
			<h2>당신의 사번은 <span style="color: #3DB7CC">${doctor_no}</span>입니다.</h2>
		</span>
		<!-- 이미지 or 텍스트 사이트 이름 -->
		<!-- 로그인 박스 -->
			<hr>
			<span class="ment">
				로그인 화면으로 돌아가시려면, <a href="<%=context %>/login/loginForm.jsp">여기</a>를 눌러주세요.
			</span><p>
			<span class="ment" id="login_not">
			</span>
		</form>
	</div>
</body>
</html>