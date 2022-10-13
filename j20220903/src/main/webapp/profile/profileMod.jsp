<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보 수정</title>
<script src="https://kit.fontawesome.com/54a6153010.js"
	crossorigin="anonymous"></script>
<script type="text/javascript">
function readURL(input) {
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    reader.onload = function(e) {
	    	document.getElementById("myDIV").style.display = "none";
	    	document.getElementById('preview').src = e.target.result;
	    	document.getElementById("preview").style.width = "100px";
	    };
	    reader.readAsDataURL(input.files[0]);
	  } else {
	    document.getElementById('preview').src = "";
	  }
}

</script>
</head>

<style type="text/css">
#edit_img
	{
		padding: 30px;
	}
	
.main {
	display: flex;
	justify-content: center;
	align-items: center;
	margin: 100px;
}
.profile_update_content {
	margin: 20px;
	padding: 30px;
	border: 1px solid ;
	border-color: gray
}
 .table {
 	border-collapse: collapse;
 	border:none;
 }
 .table_row {
 	margin: 10px;
 	padding: 20px;
 }
.button {
	size: 30px;
}
	
</style>
<body>
	<%@ include file="../top-side.jsp" %>
	
	<form action="<%=context %>/profileModAct.do" method="post" enctype="multipart/form-data">
			<input type="hidden" value="${img_path}" name="img_path">
		
		<div class="main">	
		
			<div class="edit_img" id="myDIV">
				<c:choose>
				<c:when test="${doctor_s.image == null}">
  					<img id="myphoto" class="profile_img" alt="image" src="<%=context %>/images/user.png" style="width: 100px;">
				</c:when>
				<c:otherwise>
  					<img id="myphoto" class="profile_img"  alt="image" src="<%=context %>/images/${doctor_s.image}" style="width: 100px;">
				</c:otherwise>
				</c:choose>
			</div>
			<img id="preview"/>
		<div class="profile_update_content">
		<table border="1" class="table">
			<caption>정보 수정</caption>
			<tr class="table_row"><td>사번</td><td><input type="text" name="doctor_no" required="required" readonly="readonly" value="${doctor_s.doctor_no}"></td>
			</tr>
			<tr class="table_row"><td>이름</td><td><input type="text" name="doctor_name" required="required" value="${doctor_name}"></td></tr>
			<tr class="table_row"><td>비밀번호</td><td><input type="text" name="password" required="required" value="${password}"></td></tr>
			<tr class="table_row"><td>담당과</td><td>
				<select name="department" id="department" style="font: initial;">
					<option selected="selected">${department}</option>
					<option value="간담췌외과" >간담췌외과</option>
					<option value="소화기내과">소화기내과</option>
					<option value="신장내과">신장내과</option>
					<option value="정형외과">정형외과</option>
					<option value="호흡기내과">호흡기내과</option>
					<option value="흉부외과">흉부외과</option>
				</select>	
			</td></tr>
			<tr class="table_row"><td colspan="2">
				<input type="file" name="img_path" onchange="readURL(this);" class="button"> 
				<input type="button"  value="취소" onclick="location.href='<%=context %>/profile.do'" class="button">
				<input type="submit"  value="완료" class="button"></td></tr>
		</table>
		
		</div>
	</div>
	</form>

<%@ include file="../footer-side.jsp" %>