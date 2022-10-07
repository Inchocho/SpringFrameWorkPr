<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- MVC패턴중 VIEW(9.16) -->	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>회원정보 수정페이지</title>

<script type="text/javascript">
	function pageMoveListFnc(){
		var url = './list';
		location.href = url;		
	}
	
	function pageMoveDeleteFnc(no){
		var url = "./delete?no=" + no;
		location.href = url;
	}	
	
</script>

</head>

<body>

	<jsp:include page="../Header.jsp"/>
	<h1>회원정보</h1>
	 
		<form action='update' method='post'>
		번호:  <input type='text' name='no'
			 value='${requestScope.memberDto.no}' readonly><br>
		이름:  <input type='text' name='name'
			 value='${requestScope.memberDto.name}'><br>
		이메일: <input type='text' name='email'
			 value='${requestScope.memberDto.email}'><br>
		가입일: ${requestScope.memberDto.createDate} <br>
			  <input type='submit' value='저장'>
			  <input type='reset' value='취소' onclick='pageMoveListFnc();'>
			  <input type='button' value='삭제'
			  	 onclick='pageMoveDeleteFnc(${memberDto.no});'>
		</form>	
		
		<!-- onclick='location.href="./delete?no=${memberDto.getNo()}"'> 자바스크립트 함수를 작성해서 처리해줌 -->
		
		<!-- 세션타는지 확인용 -->
		${sessionScope.memberDto.getEmail()}
		${sessionScope.memberDto.getName()}
	
	<jsp:include page="../Tail.jsp"/>
</body>

</html>