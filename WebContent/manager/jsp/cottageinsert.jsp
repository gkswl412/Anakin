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
table {
	text-align: center;
	margin : auto;
	padding: 20px;
	border-spacing: 30px;
}
</style>
<meta charset="UTF-8">
<title>Cottage 신규 등록 화면</title>
</head>
<body>
	<h1>Cottage 신규 등록</h1>
	<form name="manager_id" action="insertcottage" method="post">
		<table>
			<tr>
				<td><input type="number" name="cottage_id" placeholder="CottageID" style="width:600px;height:50px;font-size:20px;" required="required"></td>
			</tr>
			<tr>
				<td><input type="text" name="cottage_name" placeholder="Cottage이름" style="width:600px;height:50px;font-size:20px;" required="required"></td>
			</tr>
			<tr>
				<td><input type="text" name="cottage_location" placeholder="Cottage주소" style="width:600px;height:50px;font-size:20px;" required="required"></td>
			</tr>
			<tr>
				<td><input type="text" value="010-1111-1111" placeholder="Cottage대표전화" style="width:600px;height:50px;font-size:20px;" onfocus="this.value='';" name="cottage_phone_number"></td>
			</tr>
			<tr>
				<td><textarea name="cottage_description" placeholder="Cottage설명" style="width:1000px;height:300px;font-size:20px;" ></textarea></td>
			</tr>
			<tr>
				<td><select name="cottage_cat" style="width:600px;height:60px;font-size:20px;" >
						<option value="Cottage분류">Cottage분류</option>
						<option value="펜션">펜션</option>
						<option value="콘도">콘도</option>
						<option value="게스트하우스">게스트하우스</option>
						<option value="민박">민박</option>
						<option value="호텔">호텔</option>
						<option value="한옥스테이">한옥스테이</option>
						<option value="모텔">모텔</option>
				</select></td>
			</tr>
			<tr>
				<td>
				<input type="submit" value="입력하기" style="width:100px;height:40px;font-size:15px;"> 
				<input type="reset" value="다시" style="width:100px;height:40px;font-size:15px;"> 
				<input type="button" value="돌아가기" style="width:100px;height:40px;font-size:15px;" onclick="history.back()"></td>
			</tr>
		</table>
	</form>
</body>
</html>