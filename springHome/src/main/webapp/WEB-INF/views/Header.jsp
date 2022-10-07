<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>			
	

<div style="background-color: #00008b; color: #ffffff; height: 20px;
	padding: 5px;">
	
	<c:if test='${memberDto.getEmail() eq null}'>
		<span style="float: right;">
			게스트 로그인 중입니다.		
		</span>	
	</c:if>


	<c:if test='${memberDto.getEmail() ne null}'>
		<span style="float: right;">
			${memberDto.name}
			<a style="color:white;"
				href="<%=request.getContextPath()%>/auth/logout">
				로그아웃
			</a>
		</span>
	</c:if>

		
<!-- 	<!-- memberDto가 empty면으로 판단 -->
<%-- 	<c:if test='${empty memberDto}'> --%>
<!-- 		<span style="float: right;"> -->
<!-- 			게스트 로그인 중입니다.		 -->
<!-- 		</span>	 -->
<%-- 	</c:if> --%>

<!-- 	<!-- memberDto가 empty가 아니면 --> 
<%-- 	<c:if test='${!(empty memberDto)}'> --%>
<!-- 		<span style="float: right;"> -->
<%-- 			${memberDto.name} --%>
<!-- 			<a style="color:white;" -->
<%-- 				href="<%=request.getContextPath()%>/auth/logout"> --%>
<!-- 				로그아웃 -->
<!-- 			</a> -->
<!-- 		</span> -->
<%-- 	</c:if>		 --%>
	
	
	
SPMS(Simple Project Management System)
</div>