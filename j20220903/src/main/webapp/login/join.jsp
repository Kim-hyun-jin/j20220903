<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%   String context = request.getContextPath();%> 
<script src="https://kit.fontawesome.com/54a6153010.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="<%=context %>/js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="<%=context %>/login/login.css" >
<script type="text/javascript">
	function pwChk(){
		var password = $("#password").val();
		var password2 = $("#password2").val();
		
		password *= 1;
		console.log(typeof password);
		
		if(password == ''|| password == null || password2 == null || password2 == ''){
			$("#check").css('color', 'red');
			$("#check").html("\t입력하세요!");
		} else if (password != password2) {
			$("#check").css('color', 'red');
			$("#check").html("\t일치X");
		} else {
			$("#check").css('color', '#1DDB16');
			$("#check").html("\t일치");
		}
	}
	
	function check() {
		var password = $("#password").val();
		var password2 = $("#password2").val();
		
		if (password == '' || password == null) {
			$("#join_not").css('color', 'red');
			$("#join_not").html("암호를 입력하세요!!");
			return false;
		}
		if (password != password2) {
			$("#join_not").css('color', 'red');
			$("#join_not").html("암호를 확인하세요!!");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<!-- 전체 박스 -->
	<div class="log_box" style="height: 900px;">
		<span class="title">
			<h1>
				<i class="fa-solid fa-hand-holding-medical"></i>
				CareBare
			</h1>
			<h2>회원가입</h2>
		</span>
		<!-- 이미지 or 텍스트 사이트 이름 -->
		<!-- 로그인 박스 -->
		<form action="<%=context %>/joinPro.do" onsubmit="return check();">
			<table class="jointable">
				<tr><td class="label">사번</td></tr>
				<tr><td><input type="text" class="in" id="doctor_no" name="doctor_no" placeholder="사번은 자동으로 부여됩니다." readonly="readonly"></td></tr>
				<tr><td class="label">암호</td></tr>
				<tr><td><input type="password" class="in" id="password" name="password" placeholder="숫자 20 이내" required="required" onkeyup="pwChk();"></td></tr>
				<tr><td class="label">암호확인</td></tr>
				<tr><td><input type="password" class="in" id="password2" placeholder="한번 더 입력" required="required" onkeyup="pwChk();"></td><td style="width: 106px;"><span id="check"></span></td></tr>
				<tr><td class="label">이름</td></tr>
				<tr><td><input type="text" class="in" id="doctor_name" name="doctor_name" placeholder="" required="required"></td></tr>
				<tr><td class="label">진료과</td></tr>
				<tr><td><input type="text" class="in" id="department" name="department" placeholder="" required="required"></td></tr>
			</table>
			<input type="submit" class="log2" id="chk" value="회원가입"><p>
			<hr>
			<span class="ment">
				로그인 화면으로 돌아가시려면, <a href="loginForm.jsp">여기</a>를 눌러주세요.
			</span><p>
			<span class="ment" id="join_not">
			</span>
		</form>
	</div>
</body>
</html>