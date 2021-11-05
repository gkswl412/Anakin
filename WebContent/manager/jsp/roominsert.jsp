<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cottage방 등록 화면</title>

</head>

<body>
	<h1>${param.cottage_name}의방 등록</h1>
	<!-- <td><input type="text" name="room_occupancy" value="미등록" onfocus="this.value='';" ></td> -->
	<!-- <form name="IDcheckgo" action="goIDcheck" method="get">
<input type="submit" value="ID중복확인을 위해 먼저 실행">
</form> -->
	<form name="manager_id" action="insertroom" method="post">
		<input type="hidden" name="cottage_id" value="${param.cottage_id}">
		<table>
			<tr>
				<td>Room ID:</td>
				<td><input type="number" name="room_id" required="required"></td>
			</tr>
			<tr>
				<td>Room이름:</td>
				<td><input type="text" name="room_name" required="required"></td>
			</tr>
			<tr>
				<td>Room의 방 갯수:</td>
				<td><input type="text" name="room_count" required="required"></td>
			</tr>
			<tr>
				<td>최대수용인원:</td>
				<td><input type="text" name="room_occupancy"></td>
			</tr>
			<tr>
				<td>예약가:</td>
				<td><input type="text" name="room_price1" value="평일 예약가"
					onfocus="this.value='';"></td>
				<td><input type="text" name="room_price2" value="휴일 예약가"
					onfocus="this.value='';"></td>
				<td><input type="text" name="room_price3" value="성수기 예약가"
					onfocus="this.value='';"></td>
			</tr>
			<tr>
				<td>TV 갯수:</td>
				<td><input type="text" name="room_tv_count"></td>
			</tr>
			<tr>
				<td>화장실 갯수:</td>
				<td><input type="text" name="room_bathroom_count"></td>
			</tr>
			<tr>
				<td>발코니:</td>
				<td><select name="room_balcony_option">
						<option value="유">유</option>
						<option value="무">무</option>
				</select></td>
			</tr>
			<tr>
				<td>예약상태:</td>
				<td><input type="text" name="room_status" value="없음"
					onfocus="this.value='';"></td>
			</tr>
			<tr>
				<td>방 설명:</td>
				<td><input type="text" name="room_description"></td>
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