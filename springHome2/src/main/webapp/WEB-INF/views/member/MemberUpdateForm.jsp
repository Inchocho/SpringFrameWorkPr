<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt'%>	
<!DOCTYPE html>
<html>
<head>
<title>회원정보 수정</title>

<script type="text/javascript">
	function pageMoveListFnc() {
		location.href = './list.do';
	}
	
	function pageMoveDeleteFnc(no){
		var url = "./deleteCtr.do?no=" + no;
		location.href = url;
	}
	
// 	window.onload = function(){

// 		nameObj = document.getElementById('name');
// 		emailObj = document.getElementById('email');
// 		passwordObj = document.getElementById('password');
// 		submitBtnObj = document.getElementById('submitBtn');
// 		userAddFormObj = document.getElementById('userAddForm');
		
// 		submitBtnObj.addEventListener('click', function(e){
// 			e.preventDefault();
// 			if(nameObj.value == null || nameObj.value == ""){
// 				alert('이름은 반드시 입력해야합니다');
// 				nameObj.focus();
// 				return;
// 			}else if(emailObj.value == null || emailObj.value == ""){
// 				alert('이메일은 반드시 입력해야합니다');
// 				emailObj.focus();
// 				return;
// 			}else if(passwordObj.value == null || passwordObj.value == ""){
// 				alert('비밀번호는 반드시 입력해야합니다');
// 				passwordObj.focus();
//  				return;
// 			}else{
// 				userAddFormObj.submit();
// 			}
// 		});
		
// 	}	
</script>

</head>
	
<body>

	<jsp:include page="../Header.jsp" />
	
	<h1>회원정보</h1>
	<form action='./updateCtr.do' method='post'>
		번호: <input type='text' name='no' 
			value='${memberDto.no}' readonly><br>
		이름: <input type='text' name='name' id='memberName'
			value='${memberDto.name}' id='name'><br>
		이메일: <input type='text' name='email' 
			value='${memberDto.email}' id='email'><br>
		가입일: <fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" 
				 value="${memberDto.createDate}"/><br>						
		<input type='submit' value='저장' id='submitBtn'>
		<input type='button' value='삭제' 
			onclick='pageMoveDeleteFnc(${memberDto.no});'>
		<input type='button' value='뒤로가기' onClick='pageMoveListFnc();'>	
	</form>
	
	<jsp:include page="../Tail.jsp" />
</body>
</html>