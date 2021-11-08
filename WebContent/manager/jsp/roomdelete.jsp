<%@page import="com.anakin.manager.*"%>
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
h2 {
	text-align: center;
}
table {
	font-size: 30px;
	margin: auto;
}
</style>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Cottage 방 삭제 화면</title>
</head>
<body>
<form action="roomdelete" method="post">
<h1>${mlist.manager_name}님</h1><br>
<h2><input type="hidden" name="room_id" value="${param.room_id}">${param.room_id}코드인 ${param.room_name} 방을 삭제 합니까?</h2>
<input type="hidden" name="cottage_name" value="${param.cottage_name}">
<input type="hidden" name="cottage_id" value="${param.cottage_id}">
<table>
<tr>
<td><input type="submit" style="width: 150px; height: 40px; font-size: 15px;" value="삭제하기"></td>
<td><input type="button" value="돌아가기" style="width: 150px; height: 40px; font-size: 15px;" onclick="history.back()"></td>
</tr>
</table></form>
</body>
</html>