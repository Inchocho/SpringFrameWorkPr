<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>		


<!DOCTYPE html>
<html>
<head>
<title>회원정보 상세페이지</title>
<script type="text/javascript" src="/springHome2/resources/js/jquery-3.6.1.js">

</script>
<script type="text/javascript" src="/springHome2/resources/js/jquery.flexslider.js">

</script>

<script type="text/javascript">
	$(document).ready(function () {
		var prevPageFormObj = document.getElementById('prevPageForm');
		
		$('#beforeBtn').click(function(e){
			prevPageFormObj.submit();
		});
		
		$('#memberName').css('background-color', '#E7E7E7');
	});
	
	function pageMoveListFnc() {
		location.href = './list.do';
	}
	
	//폼의 액션을 바꿈 함수호출할때마다
	function goUpdateFnc(){
		$('#updateForm').attr('action', './update.do');
		$('#updateForm').submit();
	}
	
	function goListFnc(){
		$('#updateForm').attr('action', './list.do');
		$('#updateForm').submit();
	}

</script>

</head>
	
<body>

	<jsp:include page="../Header.jsp" />
	
	<h1>회원정보 상세</h1>
	
	<form action='./update.do' method='get' id='updateForm'>
		<input type='hidden' name='no' value='${memberDto.no}'><br>
		이름: <input type='text' name='name' id='memberName'
			value='${memberDto.name}' id='name' readonly="readonly"><br>
		이메일: <input type='text' name='email' 
			value='${memberDto.email}' id='email' readonly="readonly"><br>
		
		첨부파일:
		<c:choose>
			<c:when test="${empty fileList}">
					첨부파일이 없습니다.<br>			
			</c:when>
		
			<c:otherwise>
				<c:forEach var="row" items="${fileList}">
					<input type="button" value="이미지" name="file">
					${row.ORIGINAL_FILE_NAME}(${row.FILE_SIZE}kb)<br>
					<img alt="image not found" src="<c:url value='/img/${row.STORED_FILE_NAME}'/>">
					<br>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
		
		가입일: <fmt:formatDate value="${requestScope.memberDto.createDate}"
			pattern="yyyy-MM-dd hh:mm:ss" /><br>						
		<input type='submit' value='수정하기' id='submitBtn' onclick="goUpdateFnc();">
		<input type='button' value='이전페이지' id='beforeBtn' onclick="goListFnc();">	
        <input type="hidden" id="curPage" name="curPage"
           value="${memberMap.curPage}">
	    <input type="hidden" name="keyword"
           value="${memberMap.keyword}">
	    <input type="hidden" name="searchOption"
           value="${memberMap.searchOption}">  		
	</form>
	
	<jsp:include page="../Tail.jsp" />
</body>
</html>