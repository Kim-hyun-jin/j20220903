<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%String context0 = request.getContextPath();%>
<style type="text/css">
	table, tr, td, th{
		border: 1px solid black; 
		border-collapse: collapse;"
	}
</style>
<script type="text/javascript">
	if (${result!=null}) {
		if(${result>0}){
			alert("등록에 성공했습니다.")
			location.href="<%=context0%>/diaHistroyView.do?patient_no=${patient_no}";
		}
		if(${result<=0}) {
			alert("등록실패!");
			location.href="<%=context0%>/diaHistroyView.do?patient_no=${patient_no}";
		}
	}
</script>
</head>
<body>
	<%@ include file="../top-side.jsp" %>
	<div>
		<form action="">
			<table>
				<tr><th>차트번호</th><th>병명</th><th>처방약</th><th>진단일</th><th>환자정보보기</th><th>수정/삭제</th></tr>
					<c:if test="${dhl.isEmpty() }"><tr><td>진단내역 : 없음.</td></tr></c:if>
					<c:if test="${!dhl.isEmpty() }">
						<c:forEach var="dh" items="${dhl }" varStatus="stat">
						<tr>
							<td>${dh.chart_no }</td>
							<td>${dh.chart_disease }</td>
							<td>
								<c:if test="${rsdd.isEmpty() }">처방약물 없음<br></c:if>
								<c:if test="${!rsdd.isEmpty() }">
								<c:forEach var="rsdd" items="${rsdd.get(stat.index) }" varStatus="stat2">
									${rsdd.drug_name}(${rsdd.drug_class })/
								</c:forEach></c:if>
							</td>
							<td>${dh.chart_date }</td> 
							<td><input type="button" onclick="location.href='<%=context%>/patientManageDetail.jsp?patient_no=${patient_no}'" value="상세정보"></td>
				  			<td><input type="button" onclick="location.href='<%=context%>/diaMod.do?patient_no=${patient_no}'" value="수정/삭제"></td>
			  			</tr>
						</c:forEach>
					</c:if>
					<tr onclick="location.href='<%=context%>/diaRegView.do?patient_no=${patient_no}'"><td colspan="6">진단등록하기</td></tr>
			</table>
		</form>
	</div>
	<%@ include file="../footer-side.jsp" %>
</body>
</html>