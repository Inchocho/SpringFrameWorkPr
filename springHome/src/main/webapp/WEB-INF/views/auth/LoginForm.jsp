<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>사용자 로그인 화면</title>

</head>

<body>
	<jsp:include page="../Header.jsp"/>
	<h2>사용자 로그인</h2>
	<input type="button" onclick='location.href="../member/add"' value="회원가입">
	
	<form action="./login" method="post">
		이메일:	<input type="text" name="email"><br>		
		암호:	 	<input type="password" name="password"><br>		
				<input type="submit" value="로그인">
	</form>	
	<jsp:include page="../Tail.jsp"/>
</body>

</html>