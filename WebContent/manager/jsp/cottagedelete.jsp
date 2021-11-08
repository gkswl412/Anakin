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
h3 {
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
<title>Cottage 삭제 화면</title>
</head>
<body>
	<form action="cotdelete" method="post">
		<h1>
		${mlist.manager_name}님
			<br></h1> <input type="hidden" name="cottage_id"	value="${param.cottage_id}"> 
		<h3>	${param.cottage_id}코드의 Cottage를 삭제 합니까?
		</h3>
		<br>
		<table>
			<tr>
			<td><input type="submit" value="삭제하기"
					style="width: 150px; height: 40px; font-size: 15px;"></td>
				<td><input type="button" value="돌아가기"
					style="width: 150px; height: 40px; font-size: 15px;"
					onclick="history.back()"></td>
				
			</tr>
		</table>
	</form>
</body>
</html>