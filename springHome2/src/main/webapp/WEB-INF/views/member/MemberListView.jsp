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
   #tableTr > th{
   	width: 200px;
   }
   
   #tableTr2 > td{
   	width: 200px;
   	height: 200px;
   	text-align: center;
   }

   table, tr, td, th{
      border:1px solid black; 
   }
   
   table {
      border-collapse: collapse;
   }
</style>
<script type="text/javascript" src="/springHome2/resources/js/jquery-3.6.1.js">
</script>
<script type="text/javascript">
$(document).ready(function() {
	   
 $('#searchOptionSel').val($('#searchOption').val());

 });
 
function pageMoveDetailFnc(){
	 var memberDetailFormObj = document.getElementById('memberDetailForm');
	 var memberDetailCurPageObj = document.getElementById('memberDetailCurPage');
	 
	 memberDetailCurPageObj.value = document.getElementById('curPage').value;
	 memberDetailFormObj.submit(); 
};

</script>
</head>

<body>
   
   <jsp:include page="/WEB-INF/views/Header.jsp"/>
   <h1>회원목록</h1>
   
   <p>
      <a href="./add.do">신규 회원 추가</a>
   </p>
   
   <form action="./list.do" method="post" id='searchForm'>
      <select name="searchOption" id='searchOption'>
      	<c:choose>
      		<c:when test="${searchMap.searchOption == 'all'}">
      			<option value="all"<c:if test="${searchMap.searchOption eq 'all'}">selected</c:if>>이름+이메일</option>
      			<option value="name">이름</option>
      			<option value="email">이메일</option>     			
     		</c:when>
     		<c:when test="${searchMap.searchOption == 'mname'}">
     			<option value="all">이름+이메일</option>
     			<option value="name" <c:if test="${searchMap.searchOption eq 'mname'}">selected</c:if>>이름</option>     			
     			<option value="email">이메일</option>     	
     		</c:when>
     		<c:when test="${searchMap.searchOption == 'email'}">
     			<option value="all">이름+이메일</option>
     			<option value="name">이름</option>
     			<option value="email"<c:if test="${searchMap.searchOption eq 'email'}">selected</c:if>>이메일</option>
     		</c:when>
		</c:choose>     		
      </select>
      
      <input type="text" name="keyword" value="${searchMap.keyword}" placeholder="회원이름 검색">
      <input id='submitBtn' type="submit" value="검색">
   </form>   
   
   <c:choose>
	 <c:when test="${empty memberList}">
		<table>
	      <tr id = 'tableTr'>
	         <th>번호</th><th>이름</th><th>이메일</th><th>가입일</th><th></th>
	      </tr>
	      <tr id = "tableTr2">
	         <td colspan="5">
	         	회원이 존재하지 않습니다
	         </td>
	      </tr>      
	    </table> 		
     </c:when>
	  <c:otherwise>
	   <table>
	      <tr>
	         <th>번호</th><th>이름</th><th>이메일</th><th>가입일</th><th></th>
	      </tr>
	      <c:forEach var="memberDto" items="${memberList}">
	      <tr>
	         <td>${memberDto.no}</td>
	         <td>
	         	<form id='memberDetailForm' action="./one.do" method="get">
					<a href='#' onclick="pageMoveDetailFnc();">
						${memberDto.name}
					</a>
				<input type="hidden" name="no" value="${memberDto.no}">
				<input type="hidden" id="memberDetailCurPage" name="curPage"
	         		value="">
		  		<input type="hidden" name="keyword"
	         		value="${searchMap.keyword}">
		  		<input type="hidden" name="searchOption"
	         		value="${searchMap.searchOption}">                     				
				</form>
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
	  </c:otherwise>
  </c:choose>
   <!-- jsp:include는 forward처럼 데이터를 유지시킨다 -->
   <jsp:include page="/WEB-INF/views/common/Paging.jsp"/>
   
   <form action="./list.do" id="pagingForm" method="post">
      <input type="hidden" id="curPage" name="curPage"
         value="${pagingMap.memberPaging.curPage}">
	  <input type="hidden" name="keyword"
         value="${searchMap.keyword}">
	  <input type="hidden" name="searchOption"
         value="${searchMap.searchOption}">                     
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