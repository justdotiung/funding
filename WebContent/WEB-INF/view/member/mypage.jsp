<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	 <div>
		<a href="mypage?fun=1">참여한 펀딩</a>
		<a href="mypage?fun=2">개설한 펀딩</a>
		<a href="mypage?fun=3">설정</a>
	</div>
	 
	<c:if test="${fun == 1}">
		<form> 
			<input type="date">
			<input type="submit" value="검색">
			<input type="button" value="교환/환불">
			<input type="button" value="펀딩취소">
			<input type="button" value="배송조회">
		</form>
	</c:if>
	<c:if test="${fun == 2}">
		
	</c:if>
	<c:if test="${fun == 3}">
		
	</c:if>
	
</body>
</html>