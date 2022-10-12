<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환자관리</title>
<script src="https://kit.fontawesome.com/54a6153010.js"
	crossorigin="anonymous"></script>
<link type="text/css" href="patientManage/patientManage.css"
	rel="stylesheet">

<style type="text/css">
.regi {
	display: inline-block; /* margin: 0 5px; */
	margin: 20px;
	margin-left: 900px;
}
</style>
</head>

<body>

	<div class="button">
		<%@ include file="../top-side.jsp"%>
		<div class="patient_manage_button">
			<input type="button" class="regi"
				onclick="location.href='patientRegView.do'" value="환자등록">

			<div class="mainContents">
				<div class="resultBox">


					<table class="patient_manage_table" border="2">
						<%-- <caption>환자관리</caption> --%>
						<tr>
							<th>환자번호</th>
							<th>환자이름</th>
							<th>생년월일</th>
							<th>성별</th>
							<th>상세정보</th>
							<th>진단내역</th>
							<th>수정/삭제</th>
						</tr>

						<c:forEach var="list" items="${patient_list}">

							<tr>
								<div class="middle">
									<td>${list.patient_no}</td>
									<td>${list.patient_name}</td>
									<td>${list.birth}</td>
									<td>${list.gender}</td>
								</div>
								<td><input type="button"
									onclick="location.href='patientManageDetail.do?patient_no=${list.patient_no}'"
									value="상세정보"></td>
								<td><input type="button"
									onclick="location.href='diaHistroyView.do?patient_no=${list.patient_no}'"
									value="진단내역"></td>
								<td><input type="button"
									onclick="location.href='patientManageUpdateDetail.do?patient_no=${list.patient_no}'"
									value="수정/삭제"></td>
							</tr>
						</c:forEach>
					</table>





				</div>
			</div>
		</div>
	</div>
</body>
</html>



<%@ include file="../footer-side.jsp"%>