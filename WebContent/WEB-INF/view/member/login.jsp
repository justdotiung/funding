<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<span>이메일 로그인</span>
</div>
	<c:if test="${param.error==1}">
	<div>
		아이디또는 비밀번호가 틀립니다.
	</div>
	</c:if>
	<form action="" method="post">
		<input type="text" name="email" placeholder="아이디">
		<input type="password" name="pw" placeholder="비밀번호">
		
		<input type="submit" value="로그인">
	</form>
	<a href="">아이디 찾기</a>
	<a href="">비밀번호 찾기</a>
	<a href="../guest/signup">회원 가입</a>
</body>
</html>