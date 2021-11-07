<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1 {
	color: lightblue;
	text-align: center;
}

body {
	text-align: center;
}

th {
	font-size: 20px;
}

table, tr, th {
	border-collapse: collapse;
}

table {
	margin: auto;
	padding: 20px;
	border-spacing: 30px;
}

button {
	width: 80px;
	height: 40px;
	font-size: 20px;
}

p {
	font-size: 20px;
	/* overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 100px;
	height: 20px; */
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${review_writer}님의답변을 입력 합니다.</h1>
	<form action="reviewcommentupdateget" method="post">
		<table>
			<tr>
				<td style="font-size:20px;">순번 : ${review_id}</td>
				<td colspan="3" style="font-size:20px;">제목 : ${review_title}</td>
			</tr>
			<tr>
				<td colspan="2" style="font-size:20px;">날짜 : ${review_date}</td>
				<td style="font-size:20px;">작성자 : ${review_writer}</td>
			</tr>
			<tr>
				<td colspan="5" style="font-size:20px;">내용<br>
				<textarea cols="50" rows="10" name="review_comment" style="width:500px;height:150px;font-size:20px;">${review_description}</textarea> 
				</td>
			</tr>
			<tr>
				<td colspan="5"><textarea cols="50" rows="10" name="review_comment" style="width:500px;height:150px;font-size:20px;">여기 입력 하세요.</textarea></td>
			</tr>
			<tr>
				<td colspan="5">
				<input type="hidden" name="review_id" value="${review_id}"> 
				<input type="hidden" name="cottage_name" value="${cottage_name}"> 
				<input type="hidden" name="cottage_id" value="${cottage_id}"> 
				<input type="hidden" name="manager_id" value="${manager_id}"> 
				<input type="submit" value="입력하기" style="width:150px;height:40px;font-size:20px;">
				<input type="reset" value="다시" style="width:150px;height:40px;font-size:20px;">
				<input type="button" value="돌아가기" onclick="history.back()" style="width:150px;height:40px;font-size:20px;"></td>
			</tr>
		</table>
	</form>
</body>
</html>