<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="shareBoardRegAct.do" ></form>
<h2 align="center">게시판 수정</h2>
<table align="center" border="1">
	<tr>
		<td>작성자</td><td>${shareboard.shareboard_no}</td>
	</tr>
	<tr>
		<td>제목</td><td>${shareboard.shareboard_subject }</td>
			<td colspan="4">
				<input type="text" size="80" required="required">
			</td>
   </tr>
 	<tr>
		<td>게시글 내용</td><td>${shareboard.shareboard_content }</td>
			<td colspan="4">
			<textarea rows="20" cols="90" required="required">
			</textarea>
		</td>
	</tr>
	</table>
	<center>
				<input type="reset" value="다시작성">
				<input type="submit" value="확인"  >
				
	</center>




</body>
</html>