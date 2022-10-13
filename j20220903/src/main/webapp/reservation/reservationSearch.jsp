<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td select {
   font: initial;
}
	table {
	background: white;
}
@font-face {
    font-family: 'GangwonEduSaeeum_OTFMediumA';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/GangwonEduSaeeum_OTFMediumA.woff') format('woff');
    font-weight: normal;
    font-style: normal;
	}
	
	* {
	font-family: 'GangwonEduSaeeum_OTFMediumA';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/GangwonEduSaeeum_OTFMediumA.woff') format('woff');
    font-size: 30px;
	}
</style>
</head>
<%
   String context = request.getContextPath();
%>


<%-- url:"<%=context%>/ajaxTest1.do", 모델2에서도 앵커태그는 가능하다 --%>
<body>
	<script type="text/javascript">
	function returnFunction() {
		
		
	// 	var returnValue = $('input[name=group1]:checked').val();
	// 	  var returnValue = {
	// 	    key1: 'value1',
	// 	    key2: 'value2',
	// 	    key3: 'value3'
	// 	  };
	
		var radios = document.getElementsByName("group1");
	    var selected = Array.from(radios).find(radio => radio.checked);
	    
	    var arr = new Array();
	    <c:forEach items="${list_pat}" var="item">
	     arr.push({
	    	 patient_no : ${item.patient_no},
    		 patient_name : "${item.patient_name}",
    		 gender : "${item.gender}",
    		 birth : "${item.birth}",
    		 address : "${item.address}"
//     		 contact : "${item.contact}",
//     		 doctor_no : ${item.doctor_no}
	     });
	    </c:forEach>
	    
	    console.log(selected.value);
	    console.log('arr' + arr);
	    console.log('data'+ JSON.stringify(arr[selected.value]));
		    
	    
	    
	    window.opener.getReturnValue(JSON.stringify(arr[selected.value]));
	    window.close();
	  }
	
	</script>
	<form class="searchBox" style="background-color: white; width: 50%;" action="<%=context%>/reservationSearchAct.do" >
		<table border="1">
			<tr>
				<th>환자명</th>
				<td><input type="text" name="patientName" id="patientName"></td>
				<td><input type="submit" value="검색"></td>
			</tr> 
		</table>
	</form>
	<form class="searchResult" style="background-color: white; width: 50%;" action="<%=context%>/reservationSearchAct.do" >
		<table border="1">
			<tr>
				<td></td>
				<td>환자번호</td>

				<td>환자명</td>
				
			</tr>
		  	<c:forEach var="patient" items="${list_pat}" varStatus="stat">
				<tr>
					<td><input type="radio"  name='group1' value="<c:out value="${stat.index}"/>"></td>	
					<td>${patient.patient_no}</td>
					<td>${patient.patient_name}</td>
				</tr>
				
	
			</c:forEach>
		</table>
	</form>
<input type="submit" value="반영" onclick="returnFunction(this.form)">
</body>
</html>