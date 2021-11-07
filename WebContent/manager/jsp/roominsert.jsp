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
th{
	font-size: 20px;
}
table, tr, th {
	border-collapse: collapse;
}
table {
text-align: center;
	margin : auto;
	padding: 20px;
	border-spacing: 30px;
}
button{
width:80px;height:40px;font-size:20px;
}
</style>
<meta charset="UTF-8">
<title>Cottage방 등록 화면</title>

</head>

<body>
	<h1>${param.cottage_name}의방 등록</h1>
	<form name="manager_id" action="insertroom" method="post">
		<input type="hidden" name="cottage_id" value="${param.cottage_id}">
		<table>
			<tr>
				<td colspan="3"><input type="number" name="room_id" placeholder="Room ID" style="width:300px;height:60px;font-size:20px;" required="required"></td>
			</tr>
			<tr>
				<td colspan="3"><input type="text" name="room_name" placeholder="Room이름" style="width:300px;height:60px;font-size:20px;" required="required"></td>
			</tr>
			<tr>
				<td colspan="3"><input type="text" name="room_count" placeholder="방 갯수" style="width:300px;height:60px;font-size:20px;" required="required"></td>
			</tr>
			<tr>
				<td colspan="3"><input type="text" name="room_occupancy" placeholder="최대 수용인원" style="width:300px;height:60px;font-size:20px;"></td>
			</tr>
			<tr>
				<td><input type="text" name="room_price1" placeholder="평일 예약가" style="width:150px;height:60px;font-size:20px;"></td>
				<td><input type="text" name="room_price2" placeholder="휴일 예약가" style="width:150px;height:60px;font-size:20px;"></td>
				<td><input type="text" name="room_price3" placeholder="성수기 예약가" style="width:150px;height:60px;font-size:20px;"></td>
			</tr>
			<tr>
				<td colspan="3"><input type="text" name="room_tv_count" placeholder="TV 갯수" style="width:300px;height:60px;font-size:20px;"></td>
			</tr>
			<tr>
				<td colspan="3"><input type="text" name="room_bathroom_count" placeholder="화장실 갯수" style="width:300px;height:60px;font-size:20px;"></td>
			</tr>
			<tr>
				<td colspan="3"><select name="room_balcony_option" style="width:300px;height:60px;font-size:20px;">
						<option value="발코니 유/무">발코니 유/무</option>
						<option value="유">유</option>
						<option value="무">무</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="3"><textarea  name="room_description" placeholder="방 설명" style="width:500px;height:80px;font-size:20px;"></textarea></td>
			</tr>
			<tr>
				<td colspan="4">
				<input type="hidden" name="room_status" value="없음" >
				<input type="submit" value="입력하기" style="width:150px;height:40px;font-size:20px;"> 
				<input type="reset" value="다시" style="width:150px;height:40px;font-size:20px;"> 
				<input type="button" value="돌아가기" 	onclick="history.back()" style="width:150px;height:40px;font-size:20px;"></td>
			</tr>
		</table>
	</form>
</body>
</html>