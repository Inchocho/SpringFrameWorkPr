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
				<a href='./one.do?no=${memberDto.no}'>${memberDto.name}</a>
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
	
	<!-- jsp:include는 forward처럼 데이터를 유지시킨다 -->
	<jsp:include page="/WEB-INF/views/common/Paging.jsp"/>
	
	<form action="./list.do" id="pagingForm" method="post">
		<input type="hidden" id="curPage" name="curPage"
			value="${pagingMap.memberPaging.curPage}">			
	</form>
	
	
	<div hidden="">
		커렌트 블럭: <input type="text" value="${pagingMap.memberPaging.curBlock}">
		블럭 비긴 : <input type="text" value="${pagingMap.memberPaging.blockBegin}">
		블럭 엔드 : <input type="text" value="${pagingMap.memberPaging.blockEnd}">
		커렌트 페이지: <input type="text" value="${pagingMap.memberPaging.curPage}">
		커렌트 블록: <input type="text" value="${pagingMap.memberPaging.curBlock}">
		<br>
		프리브 블록: <input type="text" value="${pagingMap.memberPaging.prevBlock}">
		넥스트 블록: <input type="text" value="${pagingMap.memberPaging.nextBlock}">
		토탈 페이지: <input type="text" value="${pagingMap.memberPaging.totPage}">
		토탈 카운트: <input type="text" value="${pagingMap.totalCount}">
	</div>
	

		
	<jsp:include page="/WEB-INF/views/Tail.jsp"/>
	
</body>

</html>