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
<h1>펀딩관리</h1>
<!-- 헤더 -------------------------------------------- -->
<div>
	<a href="../main">home</a>
	
</div>

<!-- 바디 ------------------------------------------- -->

<!--사이드 -------------------------------------------  -->
	<aside>
		<a href="member">회원관리</a>
		<a href="funding">펀딩관리</a>
		<a href="event">이벤트관리</a>
		<a href="category">카테고리관리</a>
	</aside>
<!--메인------------------------------------------------  -->	
	<section>
	<h1>최근 신청 펀딩<a href="">더보기</a></h1>
		<form action="" method="post">
		<table>
			<tbody>
				<tr>
					<td>업체명</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>펀딩기간</td>
					<td>
						<input type="date" name="sdate">
						<span>~</span>
						<input type="date" name="edate">
					</td>
				</tr>
				<tr>
					<td>펀딩상태</td>
					<td>
						<input type="radio" name="state" value="start"><label>진행중</label>
						<input type="radio" name="state" value="end"><label>종료</label>	
						<input type="radio" name="state" value="stay"><label>대기</label>
					</td> 
				</tr>
			</tbody>
		</table>
		<input type="submit" value="검색">
		</form>		
	</section>
	<div>
		검색결과: 총 2건(진행중 1건)
	</div>
	<section>
	<form action="">
		<select name="category">
			<option>신청일</option>
			<option>업체명</option>
			<option>전체</option>
		</select>
		<table>
			<thead>
				<tr>
					<td>No.</td>
					<td>업체명</td>
					<td>신청일</td>
					<td>펀딩기간</td>
					<td>참여율</td>
					<td>목표금액</td>
					<td>상태</td>
					<td>관리</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var ="v" items="${items}">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><a href="">관리</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	<div>
		<span><a href="">이전</a></span>
	</div>
	<ul>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
	<div>
		<span><a href="">다음</a></span>
	</div>
	</section>
</body>
</html>