<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!-- MVC패턴중 VIEW(9.16) -->	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>회원목록</title>

</head>

<body>

	<jsp:include page="../Header.jsp"/>
	<h1>회원목록</h1>
	
	<p>
		<a href="./add">신규 회원 추가</a>
		<a href="../auth/login">로그인 화면</a>
	</p>	
	
	
<!-- taglib을 통해 java Bean도 대체함 -->	
	<c:forEach var="memberDto" items="${memberList}">
	
		${memberDto.getNo()},
		<a href='./update?no=${memberDto.no}'>${memberDto.name}</a>,
		${memberDto.email},
		${memberDto.createDate},	
		${memberDto.modifyDate},
		<a href='./delete?no=${memberDto.no}'>[삭제]</a><br>
	
	</c:forEach>
	<!-- 세션타는지 확인용 -->
	${sessionScope.memberDto.email}
	${sessionScope.memberDto.name}
	<jsp:include page="/WEB-INF/views/Tail.jsp"/>
</body>

</html>