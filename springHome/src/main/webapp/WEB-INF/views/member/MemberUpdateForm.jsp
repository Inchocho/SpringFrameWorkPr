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
	
	window.onload = function(){

		nameObj = document.getElementById('name');
		emailObj = document.getElementById('email');
		hiddenNameObj = document.getElementById('hiddenName');
		hiddenEmailObj = document.getElementById('hiddenEmail');
		passwordObj = document.getElementById('password');
		submitBtnObj = document.getElementById('submitBtn');
		updateFormObj = document.getElementById('updateForm');
		
		submitBtnObj.addEventListener('submit', function(e){
			e.preventDefault();

			if(nameObj.value == null || nameObj.value == ""){
				alert('이름은 반드시 입력해야합니다');
				nameObj.focus();
				return;
			} else if(emailObj.value == null || emailObj.value == ""){
				alert('이메일은 반드시 입력해야합니다');
				emailObj.focus();
				return;
			}else if(passwordObj.value == null || passwordObj.value == ""){
				alert('비밀번호는 반드시 입력해야합니다');
				passwordObj.focus();
				return;
			}else if(nameObj.value == hiddenNameObj.value && emailObj.value == hiddenEmailObj.value){
				alert('이메일과 이름이 같습니다. 수정해주세요~')
				return;
			}else{
				updateFormObj.submit();
			}
			
		});
		
	}	
</script>

</head>
	
<body>

	<jsp:include page="../Header.jsp" />
	
	<h1>회원정보</h1>
	<form action='./updateCtr.do' method='post' id='updateForm'>
		번호: <input type='text' name='no' 
			value='${memberDto.no}' readonly><br>
		이름: <input type='text' name='name' id='name'
			value='${memberDto.name}' ><br>
		이메일: <input type='text' name='email' id='email'
			value='${memberDto.email}' ><br>
		가입일: <fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" 
				 value="${memberDto.createDate}"/><br>	
		<input type='hidden' value='${memberDto.name}' id='hiddenName'>					
		<input type='hidden' value='${memberDto.email}' id='hiddenEmail'>					
		<input type='submit' value='저장' id='submitBtn'>
		<input type='button' value='삭제' 
			onclick='pageMoveDeleteFnc(${memberDto.no});'>
		<input type='button' value='뒤로가기' onClick='pageMoveListFnc();'>	
	</form>
	
	<jsp:include page="../Tail.jsp" />
</body>
</html>