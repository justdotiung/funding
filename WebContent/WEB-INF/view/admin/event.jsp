<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form action="" method="post">
		<table>
			<tr>
				<td>이벤트상태</td>
				<td>
					<input type="radio" name="state" value="0"><label>전체</label>
					<input type="radio" name="state" value="1"><label>종료</label>
					<input type="radio" name="state" value="2"><label>진행</label>
					<input type="radio" name="state" value="3"><label>대기</label>
				</td>
			</tr>
			<tr>
				<td>이벤트기간</td>
				<td>
					<input type="date"><span>~</span><input type="date">
					
				</td>
			</tr>
			<tr>
				<td>대상</td>
				<td>
					<select>
						<option value="전체">전체</option>
						<option value="강아지">강아지</option>
						<option value="고양이">고양이</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>업체명</td>
				<td><input type="text" name="name"></td>
			</tr>
		</table>
		<input type="submit" value="검색">
	</form>
	</section>
	<div>
		검색결과:총1건(진행중:0)
	</div>
	
	
	<section>
		<table>
			<thead>
				<tr>
					<td>번호</td>
					<td>업체명</td>
					<td>대상</td>
					<td>신청일</td>
					<td>시작일</td>
					<td>종료일</td>
					<td>상태</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>분야</td>
					<td>업체</td>
					<td>이미지</td>
					<td>노출기간</td>
					<td>고</td>
					<td>고</td>
					<td>고</td>
				</tr>
			</tbody>
		</table>
		<div>
			<a href="">이벤트 등록</a>
		</div>
	</section>
</body>
</html>