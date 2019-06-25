<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>메인</title>
<meta charset="UTF-8">
</head>
<body>


	<c:if test="${empty sessionScope.id}">
		<a href="member/login">로그인</a>
		<a href="/view/guest/signup">회원가입</a>
	</c:if>
	<c:if test="${!empty sessionScope.id&&sessionScope.id==1}">
	
		<a href="admin/index">관리자 페이지</a>
		<a href="member/logout">로그아웃</a>
	</c:if>
	<c:if test="${!empty sessionScope.id&&sessionScope.id!=1}">
		<a href="member/mypage">마이페이지</a>
		<a href="member/logout">로그아웃</a>
	</c:if>
	<c:forEach var="li" items="${list}">
	${li.id}
		<div><a href="member/detail?id=${li.id}">${li.title}</a></div>
	</c:forEach>

</body>
</html>