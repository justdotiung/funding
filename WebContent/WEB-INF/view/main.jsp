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
<c:set var="name" value="admin" />

	<c:if test="${empty sessionScope.email}">
		<a href="member/login">로그인</a>
		<a href="/view/guest/signup">회원가입</a>
	</c:if>
	<c:if test="${!empty sessionScope.email&&sessionScope.email==name}">
	${sessionScope.email}
		<a href="admin/index">관리자 페이지</a>
		<a href="member/logout">로그아웃</a>
	</c:if>
	<c:if test="${!empty sessionScope.email&&sessionScope.email!=name}">
		<a href="member/mypage">마이페이지</a>
		<a href="member/logout">로그아웃</a>
	</c:if>


</body>
</html>