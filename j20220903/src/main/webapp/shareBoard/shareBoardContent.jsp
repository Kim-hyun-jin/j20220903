<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세페이지</title>
<link type="text/css" href="main.css" rel="stylesheet">
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
	width: 300;
	height: 400;
	border-collapse: collapse;
}

td {
	border-collapse: collapse;
}

.f1 {
	border-collapse: collapse;
}
</style>

</head>

<body>
	<!-- <div id="container"> -->
	
		<%@ include file="../top-side.jsp" %>

	<!-- 	<div id="contents"> -->
			<form action="shareBoardContentView.do">
				<h2 align="center">게시판 상세내역</h2>
				<div class="f1">
					<table align="center" border="1">
						<tr>
							<th>작성자</th>
							<td colspan="7"><input type="text" name="doctor_name"
								required="required" value="${shareBoard.doctor_name}"
								readonly="readonly"></td>
						</tr>
						<tr>
							<th>등록일</th>
							<td colspan="7"><input type="text" name="Regdate"
								required="required" value="${shareBoard.shareBoard_date}"
								readonly="readonly"></td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="4"><input type="text" name="shareboard_subject"
								size="80" required="required" readonly="readonly"
								value="${shareBoard.shareBoard_subject }"></td>
						</tr>
						<tr>
							<th>게시글 내용</th>
							<td colspan="4"><textarea rows="10"
									name="shareboard_content" readonly="readonly" cols="90">${shareBoard.shareBoard_content }
						</textarea></td>
						</tr>

					</table>
				</div>
				
				<center>
					<c:if test="${doctor.doctor_no == shareBoard.doctor_no}">
						<input type="button" value="수정"
							onclick="location.href='shareBoardModView.do?shareboard_no=${shareBoard.shareBoard_no}&pageNum=${pageNum }'">
						<input type="button" value="삭제"
							onclick="location.href='shareBoardDelAct.do?shareBoard_no=${shareBoard.shareBoard_no}&pageNum=${pageNum }'">
					</c:if>
					<input type="button" value="목록"
						onclick="location.href='shareBoardView.do?pageNum=${pageNum }'">
					</td>
				</center>
			</form>
	<!-- 	</div> -->

	<%@ include file="../footer-side.jsp"%>

</body>
</html>