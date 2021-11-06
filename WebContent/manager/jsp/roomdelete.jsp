<%@page import="com.anakin.manager.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="roomdelete" method="post">
<h2>${mlist.manager_name}님<br>
<input type="hidden" name="room_id" value="${param.room_id}">${param.room_id}코드인 ${param.room_name} 방을 삭제 합니까?</h2>
<input type="hidden" name="cottage_name" value="${param.cottage_name}">
<input type="hidden" name="cottage_id" value="${param.cottage_id}">
<table>
<tr>
<td><input type="button" value="돌아가기" onclick="history.back()"></td>
<td>
<input type="submit" value="삭제하기">
</td>
</tr>
</table></form>
</body>
</html>