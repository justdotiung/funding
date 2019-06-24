<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>카테고리관리</h1>
	<!-- 헤더 -------------------------------------------- -->
	<div>
		<a href="../main">home</a>

	</div>

	<!-- 바디 ------------------------------------------- -->

	<!--사이드 -------------------------------------------  -->
	<aside>
		<a href="member">회원관리</a> <a href="funding">펀딩관리</a> <a href="event">이벤트관리</a>
		<a href="category">카테고리관리</a>
	</aside>
	<!--메인------------------------------------------------  -->
	<section>
		<form action="category" method="get">
			<dl>
				<c:forEach var="cate" items="${countlist}">
					<dt>${cate.name}</dt>
					<dd>${cate.count}</dd>
				</c:forEach>
				<dt>합계</dt>
				<dd>${sum}</dd>
			</dl>
			<input type="text" name="name"> 
			<input type="submit" value="추가">
		</form>
	</section>
</body>
</html>