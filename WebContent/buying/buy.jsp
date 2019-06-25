<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form>
			<label>결제할금액</label> <select value="선택">
				<option>금액1</option>
				<option>금액2</option>
			</select>
			<div>펀딩금액 9000원</div>
			<input type="checkbox" name="add" value="기존정보 추가"> 
			<label>기존정보추가하기</label>
			<div>
				배송정보
				<label>이름</label> <input type="text" name="name" placeholder="예)이름"> 
				<label>주소</label>
				<input type="button" name="search" value="주소검색"> 
				<input type="text" name="address" placeholder="기본주소"> 
				<input type="text" name="address" placeholder="상세주소"> 
				
				<label>휴대폰 번호</label> <input type="text" name="phone" placeholder="010-000-0000"> 
				<label>배송시	요청사항</label> <input type="text" name="req" placeholder="예)부재시문앞에두세요">
			
			</div>
		</form>
	</div>

	<section>
		<div>결제할금액 9000원</div>
		<div>
			결제카드
			<input type="button" name="간편결제" value="간편결제">
			<input type="button" name="직접결제" value="직접결제">
			<input type="button" name="등록하기" value="간편결제 등록하기">
		</div>


	</section>


</body>
</html>