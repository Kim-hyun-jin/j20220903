<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">


</style>
</head>
<body>
<%-- <form action="writePro.do?pageNum=${schedule_no}"> --%>
<form action="">
<table border="1">스케줄등록
<tr><td>제목 <input type="text" name="subject"></td></tr>
<tr><td>시작일 <input type="date" name="startdate"></td></tr>
<tr><td>시작일 <input type="date" name="enddate"></td></tr>
<tr><td>내용 <input type="text" name="content"></td></tr>
</table>
<input type="submit" value="등록">
	<input type="reset" value="취소">


</form>
</body>
</html>