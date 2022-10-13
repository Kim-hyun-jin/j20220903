<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글쓰기</title>
<!-- <link type="text/css" href="main.css" rel="stylesheet"> -->
<script src="https://kit.fontawesome.com/54a6153010.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="style.css">
<style type="text/css">
@font-face {
	font-family: 'GangwonEduSaeeum_OTFMediumA';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/GangwonEduSaeeum_OTFMediumA.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

* {
	font-family: 'GangwonEduSaeeum_OTFMediumA';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/GangwonEduSaeeum_OTFMediumA.woff')
		format('woff');
	font-size: 30px;
}

table {
	border-collapse: collapse;
}
</style>
</head>
<body>
<!-- 	<div id="container"> -->

		<%@ include file="../top-side.jsp" %>

	<!-- 	<div id="contents"> -->
			<form action="shareBoardRegAct.do?">

				<input type="hidden" name="pageNum" value="${pageNum }"> <input
					type="hidden" name="doctor_no" value="${doctor_no }">

				<h2 align="center">게시판 글쓰기</h2>

				<table align="center" border="1">
					<tr>
						<td>작성자</td>
						<td></td>
						<td><input type="text" size="80" value="${doctor_name}"
							readonly></td>
					</tr>
					<tr>
						<td>제목</td>
						<td colspan="4"><input type="text" name="shareBoard_subject"
							size="80" required="required" autofocus="autofocus"></td>
					</tr>
					<tr>
						<td>게시글 내용</td>
						<td colspan="4"><textarea rows="10" name="shareBoard_content"
								cols="90" required="required" autofocus="autofocus">
					</textarea></td>
					</tr>
				</table>
				<center>
					<input type="submit" value="확인"> 
					<input type="reset" value="다시작성"> 
					<input type="button" value="목록" onclick="location.href='shareBoardView.do?pageNum=${pageNum }'">
				</center>
			</form>
<!-- 		</div>
	</div> -->

	<%@ include file="../footer-side.jsp"%>
</body>
</html>