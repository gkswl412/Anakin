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
	<form action="managerupdate" method="post">
		<h2>
			<br>
			<input type="hidden" name="cottage_id" value="${cv.cottage_id}">
			<input type="hidden" name="manager_id" value="${mlist.manager_id}">
			${message}<br>
			${mlist.manager_name}님의 정보를 수정합니다.
		</h2>
		<table>
			<tr>
				<td>Manager이름:</td>
				<td><input type="text" name="manager_name" value="${mlist.manager_name}" required="required"></td>
			</tr>
			<tr>
				<td>Manager비밀번호:</td>
				<td><input type="text" name="manager_pw1" value="${mlist.manager_pw}" required="required"></td>
			</tr>

			<tr>
				<td>Manager비밀번호 확인:</td>
				<td><input type="text" name="manager_pw2" value="${mlist.manager_pw}" required="required"></td>
			</tr>
			<tr>
				<td>Manager핸드폰 번호:</td>
				<td><input type="text" name="manager_phone" value="${mlist.manager_phone}"></td>
			</tr>
			<tr>
				<td>Manager이메일:</td>
				<td><input type="text" name="manager_email" value="${mlist.manager_email}"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="입력하기"> 
				<input type="reset" value="다시"> 
				<input type="button" value="돌아가기" onclick="location.href='/Anakin/managerinfo'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>