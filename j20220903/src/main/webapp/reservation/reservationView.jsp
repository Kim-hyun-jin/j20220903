<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 조회</title>
<!-- <link rel="stylesheet" type="text/css" href="revStyle.css">   -->
<style type="text/css">
	table tr td {
		width:150px; 
		height:30px;
		font-size:28px;
	}
	table tr td checkbox {
		width:15px;
		height:15px;
	}
</style>
<%
	String contextLocal = request.getContextPath();
%>
<body>  
<script type="text/javascript">
	location.href = "<%=contextLocal%>/reservationView.do";
</script> 
<%@ include file="../top-side.jsp" %>
<!-- 
	<article id="table-style">

 	 </article> -->
  	</div>
  	
<%@ include file="../footer-side.jsp" %>
