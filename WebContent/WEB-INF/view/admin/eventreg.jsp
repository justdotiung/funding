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
					<td>우리펀딩</td>
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
			</table>
			<input type="submit" value="확인">
			<a href="event">취소</a>
		</form>
	</section>


	<!--풋터  -->
</body>
</html>