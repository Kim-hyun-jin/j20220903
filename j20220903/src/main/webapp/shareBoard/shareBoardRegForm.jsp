<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		
	
	}	
</style>
</head>
<body>
<form action="shareBoardRegView.do" ></form>
<h2 align="center">게시판 글쓰기</h2>
<table align="center" border="1">
	<tr>
		<td>작성자</td><td>${shareBoard.shareBoard_no}</td>
			<td>	
					<input type="text" name="writer" size="80">
			</td>
	</tr>
	<tr>
		<td>제목</td><td>${shareBoard.shareBoard_subject }</td>
			<td colspan="4">
				<input type="text" size="80" required="required">
			</td>
   </tr>
 	<tr>
		<td>게시글 내용</td><td>${shareBoard.shareBoard_content }</td>
			<td colspan="4">
			<textarea rows="20" cols="90" required="required">
			</textarea>
		</td>
	</tr>
	</table>
	<center>
				<input type="submit" value="확인"  >
				<input type="reset" value="다시작성">
			
				
	</center>


</body>
</html>