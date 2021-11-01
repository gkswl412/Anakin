<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>check your reservation</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<form method="post" action="RentalCottageManager/selectAllReservation">
		<input type="text" name="reservation_id">
		<input type="submit" id="submit" name="submit" value="allReservations">
	</form>
</body>
</html>