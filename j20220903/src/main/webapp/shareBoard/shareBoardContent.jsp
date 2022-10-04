<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<h1>ShareBordContent.jsp</h1>
	
	<form action="shareBoardContentView.do" >
<h2 align="center">게시판 상세내역</h2>
<table align="center" border="1">
	<tr>
		<td>작성자</td>
		<td>${shareBoard.doctor_no}</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${shareBoard.shareBoard_subject }</td>
   </tr>
 	<tr>
		<td>게시글 내용</td>
		<td>${shareBoard.shareBoard_content }</td>
	</tr>
	</table>
	<center>
		<input type="button" value="수정"
				onclick="location.href='shareBoardModView.do?shareboard_no=${shareBoard.shareBoard_no}&pageNum=${pageNum }'">
		<input type="button" value="삭제"
				onclick="location.href='shareBoardDelAct.do?shareBoard_no=${shareBoard.shareBoard_no}&pageNum=${pageNum }'">
		<input type="button" value="목록"
				onclick="location.href='shareBoardView.do?pageNum=${pageNum }'">	</td></tr>
				
	</center>
</form>
</body>
</html>