<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>		

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>회원목록</title>

<style type="text/css">
	table, tr, td, th{
		border:1px solid black; 
	}
	
	table {
		border-collapse: collapse;
	}
	

	/* display나 position을 변경시 기존 태그(ul)의 기능을 상실한다 바꾸지 말자 - 연습용으로 바꿈*/
	nav > ul{
		list-style-type: none;
		padding: 0px;
		overflow: hidden;
		background-color: #333333;
/* 		width: 600px; */
		display: table;
		margin-left: auto;
		margin-right: auto; 
	}
	
	nav > ul > li{
		float: left;
	}
	
	nav > ul > li > a{
		display: block;
		color: white;
		text-align: center;
		padding: 16px;
		text-decoration: none;
	}
	
	/* 뭘 선택했는지 알 수 있게 하려고 a에 hover(마우스를 해당 태그에 올렸을때 효과) 효과와 색깔 변화, 글자 굵게 효과를 줌 */
	nav > ul > li > a:hover {
		color: #FFD9EC;
		background-color: #5D5D5D;
		font-weight: bold;	
	}	
</style>

</head>

<body>
	
	<jsp:include page="/WEB-INF/views/Header.jsp"/>
	<h1>회원목록</h1>
	
	<p>
		<a href="./add.do">신규 회원 추가</a>
	</p>
	

	<table>
		<tr>
			<th>번호</th><th>이름</th><th>이메일</th><th>가입일</th><th></th>
		</tr>
		<c:forEach var="memberDto" items="${memberList}">
		<tr>
			<td>${memberDto.no}</td>
			<td>
				<a href='./update.do?no=${memberDto.no}'>${memberDto.name}</a>
			</td>
			<td>${memberDto.email}</td>
			<td>
				<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" 
				 value="${memberDto.createDate}"/>	
			</td>
			<td>
				<a href='./deleteCtr.do?no=${memberDto.no}'>[삭제]</a>	
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<nav>
		<ul>
			<li><a href="#"><span>&laquo;</span></a></li>

			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>

			<li><a href="#"><span>&raquo;</span></a></li>
		</ul>
	</nav>
		
	<jsp:include page="/WEB-INF/views/Tail.jsp"/>
	
</body>

</html>