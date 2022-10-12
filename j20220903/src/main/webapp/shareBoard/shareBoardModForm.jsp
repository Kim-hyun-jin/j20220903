<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 페이지</title>
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
</style>
</head>
<body>
	<!-- <div id="container"> -->
	
		<%@ include file="../top-side.jsp" %>

		<!-- <div id="contents"> -->
		<form action="shareBoardModAct.do">
			<input type="hidden" name="shareboard_no"
				value="${shareBoard.shareBoard_no}"> <input type="hidden"
				name="pageNum" value="${pageNum}">

			<h2 align="center">게시판 수정</h2>

			<table align="center" border="1">
				<tr>
					<td>작성자</td>
					<td colspan="4"><input type="text" name="doctor_name"
						required="required" value="${shareBoard.doctor_name}"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="4"><input type="text" name="shareboard_subject"
						size="80" required="required"
						value="${shareBoard.shareBoard_subject }"></td>
				</tr>
				<tr>
					<td>게시글 내용</td>
					<td colspan="4"><textarea rows="10" name="shareboard_content"
							cols="90">${shareBoard.shareBoard_content }
					</textarea></td>
				</tr>
			</table>
			<center>
				<input type="submit" value="확인">
			</center>
		</form>
<!-- 		</div>
	</div> -->
		
		<%@ include file="../footer-side.jsp"%>
</body>
</html>