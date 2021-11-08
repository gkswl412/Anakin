<%@page import="com.anakin.manager.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
h1 {
	color: lightblue;
	text-align: center;
}
body {
	text-align: center;
}
table {
margin:auto;
	text-align: center;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Manager 정보 수정 화면</title>
</head>
<body>
	<form action="managerupdate" method="post">
		<h1>
			<br>
			<input type="hidden" name="cottage_id" value="${cv.cottage_id}">
			<input type="hidden" name="manager_id" value="${mlist.manager_id}">
			${message}<br>
			${mlist.manager_name}님의 정보를 수정합니다.
		</h1>
		<table>
			<tr>
				<td><input type="text" name="manager_name" value="${mlist.manager_name}" placeholder="Manager이름" style="width:300px;height:60px;font-size:20px;" required="required"></td>
			</tr>
			<tr>
				<td><input type="password" name="manager_pw1" value="${mlist.manager_pw}" placeholder="Manager비밀번호" style="width:300px;height:60px;font-size:20px;" required="required"></td>
			</tr>
			<tr>
				<td><input type="password" name="manager_pw2" value="${mlist.manager_pw}" placeholder="Manager비밀번호확인" style="width:300px;height:60px;font-size:20px;"required="required"></td>
			</tr>
			<tr>
				<td><input type="text" name="manager_phone" value="${mlist.manager_phone}" placeholder="Manager핸드폰번호" style="width:300px;height:60px;font-size:20px;"></td>
			</tr>
			<tr>
				<td><input type="text" name="manager_email" value="${mlist.manager_email}" placeholder="Manager이메일" style="width:300px;height:60px;font-size:20px;"></td>
			</tr>
			<tr>
				<td>
				<input type="submit" value="수정하기" style="width:100px;height:40px;font-size:15px;"> 
				<input type="reset" value="다시" style="width:100px;height:40px;font-size:15px;"> 
				<input type="button" value="돌아가기" onclick="history.back()" style="width:100px;height:40px;font-size:15px;">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>