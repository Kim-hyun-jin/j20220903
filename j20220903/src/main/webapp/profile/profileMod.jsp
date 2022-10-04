<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>profileMod.jsp</p>
	<form action="../profileModAct.do" method="post">
		<input type="hidden" name="doctor_no" value="${doctor_no}">
		
		<table border="1">
			<caption>내정보 수정</caption>
			<tr><td>이름</td><td><input type="text" name="doctor_name" required="required" value="${doctor.doctor_name}"></td></tr>
			<tr><td>사번</td><td><input type="text" name="doctor_no"  readonly="readonly" value="${doctor_no}"></td></tr>
			<tr><td>진료과</td>
			<td>
				<select name="department">
								<option value="" selected="selected">선택하지 않음</option>
								<option value="간담췌외과" >간담췌외과</option>
								<option value="소화기내과">소화기내과</option>
								<option value="신장내과">신장내과</option>
								<option value="정형외과">정형외과</option>
								<option value="호흡기내과">호흡기내과</option>
								<option value="흉부외과">흉부외과</option>
				</select></td>
			</tr>
			<tr><td colspan="2"><input type="submit" value="수정완료"></td></tr>
		</table>
	</form>
</body>
</html>