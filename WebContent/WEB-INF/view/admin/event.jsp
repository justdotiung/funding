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
	<h1>이벤트관리</h1>
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
	<form action="event" method="get">
		<table>
			<tr>
				<td>이벤트상태</td>
				<td>
					<input type="radio" name="state" value="0" checked><label>전체</label>
					<input type="radio" name="state" value="1"><label>심사</label>
					<input type="radio" name="state" value="2"><label>진행</label>
					<input type="radio" name="state" value="3"><label>종료</label>
				</td>
			</tr>
			<tr>
				<td>이벤트기간</td>
				<td>
					
					<input type="date" name="sdate">
					
					<span>~</span>
					<input type="date" name="edate">
				</td>
			</tr>
			<tr>
				<td>업체명</td>
				<td><input type="text" name="title"></td>
			</tr>
		</table>
		<input type="hidden" name="page" value="${param.page}"> 
		<input type="hidden" name="old_title" value="${param.title}">
		<input type="hidden" name="old_edate" value="${param.edate}">
		<input type="hidden" name="old_sdate" value="${param.sdate}">
		<input type="hidden" name="old_state" value="${param.state}">
		<input type="submit" value="검색">
	</form>
	</section>
	
	<c:if test="${not empty count}">
		<div>검색결과:총${count}건(진행중:${scount})</div>
	</c:if>
	
	
	<section>
		<table>
			<thead>
				<tr>
					<td>번호</td>
					<td>업체명</td>
					<td>신청일</td>
					<td>시작일</td>
					<td>종료일</td>
					<td>상태</td>
				</tr>
			</thead>
			<tbody>
			<c:if test=""></c:if>
			<c:forEach var="e" items="${event}">
			<c:set var="sta" value="${e.state}"/>
				<tr>
					<td>${e.id}</td>
					<td><a href="eventedit?id=${e.id}">${e.title}</a></td>
					<td>${e.regdate}</td>
					<td>${e.sdate}</td>
					<td>${e.edate}</td>
					<c:if test="${sta==1}">
						<td>심사</td>
					</c:if>
					<c:if test="${sta==2}">
						<td>진행</td>
					</c:if>
					<c:if test="${sta==3}">
						<td>종료</td>
					</c:if>
						
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div>
			<a href="reg">이벤트 등록</a>
		</div>
	  
		<c:set var="p" value="${(empty param.page) ? 1 : param.page}"/>	
		<c:set var="start" value="${p - (p-1)%5}"/>	

		<section>
			<h1>페이지</h1>
			<div>
				<div>
					<a href="event?page=${(p < 6)? p : p -5}&state=${param.state}&sdate=${param.sdate}&edate=${param.edate}&title=${param.title}">이전</a>
				</div>
				<ul>
					<c:forEach var="n" begin="${start}" end="${start+4}" varStatus="s">
						<li><a href="event?page=${n}&state=${param.state}&sdate=${param.sdate}&edate=${param.edate}&title=${param.title}">${n}</a></li>
					</c:forEach>
				</ul>
				<div>
					<a href="event?page=${start+5}&state=${param.state}&sdate=${param.sdate}&edate=${param.edate}&title=${param.title}">다음</a>
				</div>
			</div>
		</section>
	</section>
</body>
</html>