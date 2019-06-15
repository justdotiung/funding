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
	<section>
		<h1>회원가입</h1>
		<form action="signup" method="post">
			<input type="email" name="email" placeholder="아이디(이메일)"> <br>
			<input type="text" name="Cert_Number" placeholder="인증번호"> <br>
			<input type="submit" value="인증하기"><br>
			<input type="text" name="name" placeholder="이름"><br>
			<c:if test="${!empty error}"> 
				${error}<br>
			</c:if>
			<input type="password" name="pw" placeholder="비밀번호(영문,특문,10-16자리)"><br>
			<input type="password" name="pw1" placeholder="비밀번호확인"><br>
			<input type="text" name="phone" placeholder="휴대폰번호('-'없이 입력)"><br>
			<input type="checkbox" name="eventCheck" value="1"><span>펀딩 소식과 이벤트 안내를 받습니다 (선택)</span><br>
			
			<div>본인은 만15세 이상이며 회원기본약관 동의 합니다.</div>
			<input type="submit" value="동의하고 가입하기">
		</form>
	</section>
</body>
</html>