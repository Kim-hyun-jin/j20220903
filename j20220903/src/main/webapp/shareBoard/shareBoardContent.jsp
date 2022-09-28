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
	<table border="1">
	<caption><h2>게시판 상세내역</h2></caption>
	<tr><td width="50">번호</td><td>${board.num }</td></tr>
	<tr><td>제목</td><td>${board.subject }</td></tr>
		<tr>
			<td>작성자</td>
			<td>${shareboard.의사이름}</td>
		</tr>
		<tr><td>작성일</td><td>${shareboard.shareboard_date }</td></tr>
		<tr><td>IP</td><td>${board.ip }</td></tr>
		<tr><td>이메일</td><td>${board.email}</td></tr>
		<tr><td>내용</td><td>${board.content }</td></tr>
		<tr><td colspan="2">
		<input type="button" value="수정"
				onclick="location.href='updateForm.do?num=${board.num}&pageNum=${pageNum }'">
		<input type="button" value="답변작성"
				onclick="location.href='writeForm.do?num=${board.num}&pageNum=${pageNum }'">
		<input type="button" value="삭제"
				onclick="location.href='deleteForm.do?num=${board.num}&pageNum=${pageNum }'">
		<input type="button" value="목록"
				onclick="location.href='listForm.do?num=${board.num}&pageNum=${pageNum }'">	</td></tr>
	

	</table>

</body>
</html>