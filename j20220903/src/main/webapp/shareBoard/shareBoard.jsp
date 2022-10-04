<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <style type="text/css">

tr {
	text-align="center"
	
}

</style> -->
</head>
<body>
	<h1>공유게시판 메인페이지</h1>
	공유게시판 게시글 수 
	<p>totCount : ${totCnt}
	<table>
		<tr>
			<td>
				<a href="shareBoardRegView.do?doctor_no=2" class="left">글쓰기</a>
			</td>
		</tr>
	</table>
	<table width="1000" border="1" border-collapse="collapse" border-color="skyblue" align="center" >
		<tr height="50">

			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
		</tr>
		<c:if test="${totCnt > 0 }" />
		<c:forEach var="shareBoard" items="${list}">
			<tr>
				<td>${startNum }</td>
				<td class="left" width=300><a
					href='shareBoardContentView.do?shareboard_no=${shareBoard.shareBoard_no }&pageNum=${currentPage}'>
						${shareBoard.shareBoard_subject}</a></td>
				<td>${shareBoard.doctor_no}</td>
				<td>${shareBoard.shareBoard_date}</td>
			</tr>
			<c:set var="startNum" value="${startNum  -1}" />
		</c:forEach>
		<c:if test="${totCnt ==0 }">
			<tr>
				<td colspan="7">데이터가 없네</td>
			</tr>
		</c:if>
	</table>
	<!--페이지 숫자 보여주는 거  -->
	<div style="text-align: center;">
		<c:if test="${startPage > blockSize }">
			<a href='shareBoardView.do?pageNum=${startPage-blockSize }'>[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<a href='shareBoardView.do?pageNum=${i }'>[${i }]</a>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a href='shareBoardView.do?pageNum=${startPage+blockSize }'>[ 다음]</a>
		</c:if>
	</div>