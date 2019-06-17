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
<a href="../main">로고</a>
	<section>
	<form action="funding" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>프로젝트 분야</td>
				<td>펀딩</td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td>
					<select name="category">
						<option  value="4">사료</option>
						<option  value="5">간식</option>
						<option  value="6">배변용품</option>
						<option  value="7">건강관리</option>
						<option  value="8">미용용품</option>
						<option  value="9">장난감</option>
						<option  value="10">리빙</option>
						<option  value="11">패션</option>
						<option  value="12">야외용품</option>
						<option  value="13">기타</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>프로젝트 제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>프로젝트 이미지</td>
				<td><input type="file" name="img"></td>
			</tr>
			<tr>
				<td>목표 금액</td>
				<td><input type="text" name="amount"></td>
			</tr>
			<tr>
				<td>프로젝트 희망시작일</td>
				<td><input type="date" name="sDate"></td>
			</tr>
			<tr>
				<td>프로젝트 종료일</td>
				<td><input type="date" name="eDate"></td>
			</tr>
			
		</table>
			<input type="submit" value="등록하기">
	</form>
	</section>
	
</body>
</html>