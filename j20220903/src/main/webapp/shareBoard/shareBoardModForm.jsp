<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="shareBoardModAct.do">
		<input type="hidden" name="shareboard_no" value="${shareBoard.shareBoard_no}">
		<input type="hidden" name="pageNum" value="${pageNum}">
		
		<h2 align="center">게시판 수정</h2>
		
		<table align="center" border="1">
			<tr>
				<td>작성자</td>
			    <td colspan="4">
			    	<input type="text" name="doctor_no" required="required" 
		                           value="${shareBoard.doctor_no}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="4">
					<input type="text" name="shareboard_subject"
					size="80" required="required" value="${shareBoard.shareBoard_subject }">
				</td>
			</tr>
			<tr>
				<td>게시글 내용</td>
				<td colspan="4">
					<textarea rows="20" name="shareboard_content"
						cols="90" >${shareBoard.shareBoard_content }
					</textarea>
				</td>
			</tr>
		</table>
			<center>
				<input type="submit" value="확인">
			</center>
	</form>
</body>
</html>