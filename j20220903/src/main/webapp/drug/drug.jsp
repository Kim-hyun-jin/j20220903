<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>의약품 조회</title>
<script src="https://kit.fontawesome.com/54a6153010.js"
	crossorigin="anonymous"></script>
<link type="text/css" href="drug/drug.css" rel="stylesheet">
  	<%@ include file="../top-side.jsp" %>
</head>
<body>

  		<form action="<%=context%>/drugSearch.do">
	  		<span class="drug_search">약품분류</span>
	  		<select name="drug_class">
	  			<option value="empty" <c:if test="${'empty' eq drug_class }">selected="selected"</c:if>></option>
	  			<option value="shot" <c:if test="${'shot' eq drug_class }">selected="selected"</c:if>>주사제</option>
	  			<option value="soft" <c:if test="${'soft' eq drug_class }">selected="selected"</c:if>>경질캡슐</option>
	  			<option value="liquid" <c:if test="${'liquid' eq drug_class }">selected="selected"</c:if>>액제</option>
	  		</select><p>
	  		
	  		<span class="drug_search">약품명</span>
	  		<input type="text" name="drug_name" value="${drug_name }" style="margin-left: 33px; border-radius: 5px; vertical-align: middle;">
	  		<input type="submit" id="search_btn" alt="search_btn" value="">
  		</form>
  		
  		<table border="1">
  			<tr><th>번호</th><th>약품코드</th><th>약품분류</th><th width="250px;">약품명</th></tr>
  			<c:forEach var="drug" items="${list }">
  				<tr><td>${startRow }</td><td>${drug.drug_code }</td><td>${drug.drug_class }</td><td>${drug.drug_name }</td></tr>
  				<c:set var="startRow" value="${startRow + 1 }"/>
  			</c:forEach>
  		</table>
  		<div style="text-align: center;">
			<c:if test="${startPage > blockSize }">
				<a href="<%=context%>/drugSearch.do?pageNum=${startPage-blockSize }">[이전]</a>
			</c:if>
			<c:if test="${totCnt > 0 }">
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<a href="<%=context%>/drugSearch.do?pageNum=${i}&drug_class=${drug_class}&drug_name=${drug_name}">[${i}]</a>
				</c:forEach>
			</c:if>
			<c:if test="${endPage < pageCnt }">
				<a href="<%=context%>/drugSearch.do?pageNum=${startPage+blockSize }">[다음]</a>
			</c:if>
		</div>

<%@ include file="../footer-side.jsp" %>
