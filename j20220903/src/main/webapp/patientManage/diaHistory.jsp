<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진단내역</title>
<link type="text/css" href="patientManage/dia.css" rel="stylesheet">
<%String context0 = request.getContextPath();%>
<style type="text/css">
	table, tr, td, th{
		border: 1px solid black; 
		border-collapse: collapse;
	}
	
	th {
		background-color: #D4F4FA;
	}
</style>
<script type="text/javascript">
	if (${regResult!=null}) {
		if(${regResult>0}){
			alert("등록에 성공했습니다.")
			location.href="<%=context0%>/diaHistroyView.do?patient_no=${patient_no}";
		}
		if(${regResult<=0}) {
			alert("등록실패!");
			location.href="<%=context0%>/diaHistroyView.do?patient_no=${patient_no}";
		}
	}
	if (${modResult!=null}) {
		if(${modResult>0}){
			alert("수정에 성공했습니다.")
			location.href="<%=context0%>/diaHistroyView.do?patient_no=${patient_no}";
		}
		if(${modResult<=0}) {
			alert("수정실패!");
			location.href="<%=context0%>/diaHistroyView.do?patient_no=${patient_no}";
		}
	}
	if (${delResult!=null}) {
		if(${delResult>0}){
			alert("삭제에 성공했습니다.")
			location.href="<%=context0%>/diaHistroyView.do?patient_no=${patient_no}";
		}
		if(${delResult<=0}) {
			alert("삭제실패!");
			location.href="<%=context0%>/diaHistroyView.do?patient_no=${patient_no}";
		}
	}
	function delChk(chart_no) {
		if (confirm("정말 삭제하시겠습니까?")) {
			location.href='<%=context0%>/diaDelAct.do?patient_no=${patient_no}&chart_no='+chart_no;
		} else {
			alert("삭제를 취소하셨습니다.");
		}
	}
</script>
</head>
<body>
	<%@ include file="../top-side.jsp" %>
	<div class="mainContents">
	<div class="resultBox">
		<form action="">
			<table>
				<tr><th>차트<br>번호</th><th>병명</th><th>처방약</th><th>진단일</th><th>진단상세정보</th><th>수정</th><th>삭제</th></tr>
					<c:if test="${dhl.isEmpty() }"><tr><td>진단내역 : 없음.</td></tr></c:if>
					<c:if test="${!dhl.isEmpty() }">
						<c:forEach var="dh" items="${dhl }" varStatus="stat">
						<tr class="diaList">
							<td>${dh.chart_no }</td>
							<td>${dh.chart_disease }</td>
							<td>
								<c:if test="${rsdd.isEmpty() }">처방약물 없음<br></c:if>
								<c:if test="${!rsdd.isEmpty() }">
								<c:forEach var="rsdd" items="${rsdd.get(stat.index) }" varStatus="stat2">
									${rsdd.drug_name}(${rsdd.drug_class })<br>
								</c:forEach></c:if>
							</td>
							<td>${dh.chart_date }</td> 
							<td><input type="button" onclick="location.href='<%=context%>/diaInf.do?patient_no=${patient_no}&chart_no=${dh.chart_no}'" value="상세정보"></td>
							<td><input type="button" onclick="location.href='<%=context%>/diaModView.do?patient_no=${patient_no}&chart_no=${dh.chart_no}'" value="수정"></td>
				  			<td><input type="button" onclick="delChk(${dh.chart_no})" value="삭제"></td>
			  			</tr>
						</c:forEach>
					</c:if>
					<tr class="diaReg"><td colspan="7" onclick="location.href='<%=context%>/diaRegView.do?patient_no=${patient_no}'">진 단 등 록 하 기</td></tr>
			</table>
		</form>
	</div>
	</div>
	<%@ include file="../footer-side.jsp" %>
</body>
</html>