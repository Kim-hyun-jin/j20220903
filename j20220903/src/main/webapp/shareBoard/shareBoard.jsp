<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공유게시판</title>

<script src="https://kit.fontawesome.com/54a6153010.js"
	crossorigin="anonymous"></script>
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

.a {
	text-decoration: none;
	color: black;
}

th {
	height: 20px;
	background-color: #D4F4FA;
	padding: 20px;
	border-bottom: solid 3px;
	border-bottom-color: white;
	/* 	position: relative; */
	text-decoration-line: none;
}

table {
	border-collapse: collapse;
}
/* 	.header{
		margin-bottom: 50;
	} */
.writebtn {
	background-color: white;
	border: 1px solid black;
	justify-content: center;
	margin: 20px;
	margin-left: 900px;
}
.writebtn:hover {
	background-color: #D4F4FA;
}

.count {
	margin-left: 50px;
}

.non_line {
	text-decoration-line: none;
	text-align: right;
}

.non_line:hover {
	text-decoration: underline;
}

.non_line2 {
	text-decoration-line: none;
}

.pageNum {
	margin-top: 20;
}
</style>

</head>
<body>
		<%@ include file="../top-side.jsp" %>
	
			<h1 align="center" class="header">공유게시판 메인페이지</h1>
			<a class="count">공유게시판 게시글 수 :${totCnt}</a>

			<div class="a">
				<button type="button" class="writebtn"
					onClick="location.href='shareBoardRegView.do?pageNum=${pageNum}&doctor_no=${doctor.doctor_no}'">글쓰기</button>
			</div>


			<table width="1000" border="1" border-collapse="collapse" align="center">
				<tr height="40">
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
				</tr>
				<c:if test="${totCnt > 0 }" />
				<c:forEach var="shareBoard" items="${list}">
					<tr>
						<td align="center">${startNum }</td>
						<td class="left" width=400><a class="non_line"
							href='shareBoardContentView.do?shareboard_no=${shareBoard.shareBoard_no }&pageNum=${currentPage}'>
								${shareBoard.shareBoard_subject}</a></td>
						<td align="center">${shareBoard.doctor_name}</td>
						<td align="center">${shareBoard.shareBoard_date}</td>
					</tr>
					<c:set var="startNum" value="${startNum - 1}" />
				</c:forEach>
				<c:if test="${totCnt == 0 }">
					<tr>
						<td colspan="7">데이터가 없네</td>
					</tr>
				</c:if>
			</table>

			<!--페이지 숫자 보여주는 거  -->
			<div class="pageNum" style="text-align: center;">
				<c:if test="${startPage > blockSize }">
					<a href='shareBoardView.do?pageNum=${startPage-blockSize }'>[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<a class="non_line2" href='shareBoardView.do?pageNum=${i }'>[${i }]</a>
				</c:forEach>
				<c:if test="${endPage < pageCnt }">
					<a class="non_line2"
						href='shareBoardView.do?pageNum=${startPage+blockSize }'>[ 다음]</a>
				</c:if>
			</div>
<!-- 		</div>
	</div> -->
	<%@ include file="../footer-side.jsp" %>
</body>
</html>
