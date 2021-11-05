<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cottage방 등록 화면</title>

</head>

<body>
	<h1>${room.room_name}방 수정</h1>
	<!-- <input type="text" id="loginid" palceholder="아이디"> -->
	<!-- <td><input type="text" name="room_occupancy" value="미등록" onfocus="this.value='';" ></td> -->
	<!-- <form name="IDcheckgo" action="goIDcheck" method="get">
<input type="submit" value="ID중복확인을 위해 먼저 실행">
</form> -->
	<form name="manager_id" action="roomupdate" method="post">
		<input type="hidden" name="cottage_id" value="${room.cottage_id}">
		<input type="hidden" name="room_id" value="${room.room_id}">
		<input type="text" name="cottage_name" value="${cottage_name }">
		<table>
		
			<tr>
				<td>Room이름:</td>
				<td><input type="text" name="room_name" value="${room.room_name}" required="required"></td>
			</tr>
			<tr>
				<td>Room의 방 갯수:</td>
				<td><input type="text" name="room_count" value="${room.room_count}" required="required"></td>
			</tr>
			<tr>
				<td>최대수용인원:</td>
				<td><input type="text" name="room_occupancy" value="${room.room_occupancy}"></td>
			</tr>
			<tr>
				<td>예약가:</td>
				<td><input type="text" name="room_price1" value="${room.room_standard_price}"></td>
				<td><input type="text" name="room_price2" value="${room.room_holiday_price}"></td>
				<td><input type="text" name="room_price3" value="${room.room_peak_season_price}"></td>
			</tr>
			<tr>
				<td>TV 갯수:</td>
				<td><input type="text" name="room_tv_count" value="${room.room_tv_count}"></td>
			</tr>
			<tr>
				<td>화장실 갯수:</td>
				<td><input type="text" name="room_bathroom_count" value="${room.room_bathroom_count}"></td>
			</tr>
			<tr>
				<td>발코니:</td>
				<td><select name="room_balcony_option">
						<option value="${room.room_balcony_option}">${room.room_balcony_option}</option>
						<option value="유">유</option>
						<option value="무">무</option>
				</select></td>
			</tr>
			<tr>
				<td>예약상태:</td>
				<td><input type="text" name="room_status" value="${room.room_status}"></td>
			</tr>
			<tr>
				<td>방 설명:</td>
				<td><input type="text" name="room_description" value="${room.room_description}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="입력하기"> <input
					type="reset" value="다시"> <input type="button" value="돌아가기"
					onclick="history.back()"></td>
			</tr>
		</table>
	</form>
</body>
</html>