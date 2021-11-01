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
<h1>리뷰 작성</h1>
	<form action="/RentalCottageManager/review/write"  method="post">
		<div>
			<input type="text" name="review_writer" placeholder="닉네임을 입력해주세요.">
		</div>
		<br>
		<div>
			<input type="text" name="review_title" placeholder="제목을 입력해주세요.">
		</div>
		<br>
		<div>
			<input type="text" name="review_pw" placeholder="비밀번호을 입력해주세요.">
		</div>
		<br>
		<div>
			<input type="text" name="review_description" placeholder="내용을 입력해주세요.">
		</div>
		<br>
		<!--  <div>
			<input type="number" name="reservation_id"  placeholder="예약번호을 입력해주세요.">
		</div> 
		<br> -->
		<div>
			<input type="submit" value="전송">
		</div>
	</form>



</body>
</html>