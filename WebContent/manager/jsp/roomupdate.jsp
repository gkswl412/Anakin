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
	<h1>${room.room_name}방 수정</h1>
	<form name="manager_id" action="roomupdate" method="post">
		<input type="hidden" name="cottage_id" value="${room.cottage_id}">
		<input type="hidden" name="room_id" value="${room.room_id}">
		<input type="hidden" name="cottage_name" value="${cottage_name }">
		<table>
			<tr>
				<td>Room이름:</td>
				<td><input type="text" name="room_name" value="${room.room_name}" style="width:300px;height:60px;font-size:20px;" required="required"></td>
			</tr>
			<tr>
				<td>Room의 방 갯수:</td>
				<td><input type="text" name="room_count" value="${room.room_count}" style="width:300px;height:60px;font-size:20px;" required="required"></td>
			</tr>
			<tr>
				<td>최대수용인원:</td>
				<td><input type="text" name="room_occupancy" value="${room.room_occupancy}" style="width:300px;height:60px;font-size:20px;" ></td>
			</tr>
			<tr>
				<td>예약가:</td>
				<td>
				<input type="text" name="room_price1" value="평일:${room.room_standard_price}" style="width:150px;height:60px;font-size:20px;">
				<input type="text" name="room_price2" value="휴일:${room.room_holiday_price}" style="width:150px;height:60px;font-size:20px;">
				<input type="text" name="room_price3" value="성수기:${room.room_peak_season_price}" style="width:150px;height:60px;font-size:20px;">
				</td>
			</tr>
			<tr>
				<td>TV 갯수:</td>
				<td><input type="text" name="room_tv_count" value="${room.room_tv_count}" style="width:300px;height:60px;font-size:20px;"></td>
			</tr>
			<tr>
				<td>화장실 갯수:</td>
				<td><input type="text" name="room_bathroom_count" value="${room.room_bathroom_count}" style="width:300px;height:60px;font-size:20px;"></td>
			</tr>
			<tr>
				<td>발코니:</td>
				<td><select name="room_balcony_option" style="width:300px;height:60px;font-size:20px;">
						<option value="${room.room_balcony_option}">${room.room_balcony_option}</option>
						<option value="유">유</option>
						<option value="무">무</option>
				</select></td>
			</tr>
			<tr>
				<td>예약상태:</td>
				<td><input type="text" name="room_status" value="${room.room_status}" style="width:300px;height:60px;font-size:20px;"></td>
			</tr>
			<tr>
				<td>방 설명:</td>
				<td><textarea  name="room_description" placeholder="방 설명" style="width:500px;height:80px;font-size:20px;">${room.room_description}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="입력하기" style="width:150px;height:40px;font-size:20px;"> 
				<input type="reset" value="다시" style="width:150px;height:40px;font-size:20px;"> 
				<input type="button" value="돌아가기" onclick="history.back()" style="width:150px;height:40px;font-size:20px;"></td>
			</tr>
		</table>
	</form>
</body>
</html>