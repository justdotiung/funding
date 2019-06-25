<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../../js/category.js"></script>
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
	<section id="category">
		<form action="category" method="get">
			<template class="list-template">
				<tr>
					<td class="name"></td>
					<td class="count"></td>
				</tr>
			</template>
			<template class="sum-template">
				<tr>
					<td class="summ">합계</td>
					<td class="sum"></td>
				</tr>
			</template>
			<table>
				<thead>
					<tr>
						<td>
							카테고리 이름
						</td>
						<td>
							업체 수
						</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cate" items="${countlist}">
					<tr>
						<td class="name">
							${cate.name}
						</td>
						<td class="sum">
							${cate.count}
						</td>
					</tr>
				</c:forEach>
					<tr>
						<td class="summ">합계</td>
						<td class="sum">${sum}</td>
					</tr>
				</tbody>
			</table>
		</form>
		<input type="text" name="name"> 
		<input type="button" value="추가">
		<!-- <div>
			<dl>
				<c:forEach var="cate" items="${countlist}">
					<dt class="name">${cate.name}</dt>
					<dd class="count">${cate.count}</dd>
				</c:forEach>
				<dt class="summ">합계</dt>
				<dd class="sum">${sum}</dd>
			</dl>
		</div> -->
	</section>
</body>
</html>