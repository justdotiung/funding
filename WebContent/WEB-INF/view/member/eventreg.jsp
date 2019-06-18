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
	<!-- 헤더 -->
	<!-- 바디 -->
	<section>
		<form action="eventreg" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>업체명</td>
					<td>${funding.title}</td>
				</tr>
				<tr>
					<td>이벤트 기간</td>
					<td><input type="date" name="sDate"></td>
					<td>~</td>
					<td><input type="date" name="eDate"></td>
				</tr>
				<tr>
					<td>파일 이미지 등록</td>
					<td><input type="file" name="file"></td>
				</tr>
				<tr>
					<td>이미지 링크 등록</td>
					<td><input type="text" name="rink"></td>
				</tr>
				<tr>
					<td>담당자 연락처</td>
					<td><input type="text" name="manager"></td>
				</tr>
				<tr>
					<td>담당자 이메일</td>
					<td><input type="email" name="man_eamil"></td>
				</tr>
			</table>
			<input type="submit" value="신청">
		</form>
		<a href="mypage">취소</a>
	</section>


	<!--풋터  -->
</body>
</html>