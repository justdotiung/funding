<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="UTF-8">
</head>
<body>
	
	<a href="member/login">로그인</a>
	<c:if test="${sessionScope.id==null}">
	<a href="/view/guest/signup">회원가입</a>
	</c:if>
	<c:if test="${sessionScope.id!=null}">
	<a href="member/mypage">마이페이지</a>
	<a href="member/logout">로그아웃</a>
	</c:if>
	
	
</body>
</html>