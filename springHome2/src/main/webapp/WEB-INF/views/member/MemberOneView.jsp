<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt'%>	
<!DOCTYPE html>
<html>
<head>
<title>회원정보 상세페이지</title>

<script type="text/javascript">
	function pageMoveListFnc() {
		location.href = './list.do';
	}

</script>

</head>
	
<body>

	<jsp:include page="../Header.jsp" />
	
	<h1>회원정보 상세</h1>
	<form action='./update.do' method='get'>
		<input type='hidden' name='no' value='${memberDto.no}'><br>
		이름: <input type='text' name='name' id='memberName'
			value='${memberDto.name}' id='name' readonly="readonly"><br>
		이메일: <input type='text' name='email' 
			value='${memberDto.email}' id='email' readonly="readonly"><br>
		가입일: <fmt:formatDate value="${memberDto.createDate}"
			pattern="yyyy-MM-dd hh:mm:ss" /><br>						
		<input type='submit' value='수정하기' id='submitBtn'>
		<input type='button' value='이전페이지' onClick='pageMoveListFnc();'>	
	</form>
	
	<jsp:include page="../Tail.jsp" />
</body>
</html>