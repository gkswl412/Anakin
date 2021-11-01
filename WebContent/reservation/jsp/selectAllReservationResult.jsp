<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	${reservation}
	
	<table border='1'>
		<tr>
			<td>Reservation_id</td>
			<td>Cottage_id</td>
			<td>Toom_id</td>
			<td>User_name</td>
			<td>User_phone</td>
			<td>Reservation_chekin_date</td>
			<td>Reservation_checkout_date</td>
			<td>Reservation_people_count</td>
		</tr>
		<c:forEach items="${reservationList}" var="reservation">
			<tr>
				<td>${reservation.reservation_id}</td>
				<td>${reservation.cottage_id}</td>
				<td>${reservation.room_id}</td>
				<td>${reservation.user_name}</td>
				<td>${reservation.user_phone_number}</td>
				<td>${reservation.reservation_checkin_date}</td>
				<td>${reservation.reservation_checkout_date}</td>
				<td>${reservation.reservation_people_count}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>