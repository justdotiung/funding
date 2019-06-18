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
	 <div>
		<a href="mypage?fun=1">참여한 펀딩</a>
		<a href="mypage?fun=2">개설한 펀딩</a>
		<a href="mypage?fun=3">설정</a>
	</div>
	 
	<c:if test="${fun == 1}">
		<form> 
			<div>
				<input type="date"><span>~</span>
				<input type="date">
				<input type="submit" value="검색">
			</div>
			<input type="button" value="교환/환불"><br>
			<input type="button" value="펀딩취소"><br>
			<input type="button" value="배송조회">
		</form>
	</c:if>
	<c:if test="${fun == 2}">
		<form>
			<div>
				<input type="date"><span>~</span>
				<input type="date">
				<input type="submit" value="검색">
			</div>
		</form>
	<c:forEach var="f" items="${funding}">
		<div>
			${f.sDate}~
			${f.eDate}
			${f.title}
			<a href="/upload/${f.intro_img}">${f.intro_img}</a>
			<img src="/upload/${f.intro_img}" style="width: 300px">
			${f.amount}
			${f.category_id}
			심사  중 입니다.
		</div>
	</c:forEach>
		<a href="funding">펀딩신청</a>
		<a href="eventreg">이벤트 신청</a><br>
		<a href="">펀딩 수정</a><br>
		<a href="">펀딩 삭제</a>
	</c:if>
	<c:if test="${fun == 3}">
		<form enctype="multipart/form-data">
		<dl>
			<dt>이름</dt>
			<dd><input type="file"></dd>
			<dt>이름</dt>
			<dd>변경이름</dd>
			<dt>이메일</dt>
			<dd>변경이름</dd>
			<dt>전화번호</dt>
			<dd>변경이름</dd>
		</dl>		
		</form>	
	</c:if>
	
</body>
</html>