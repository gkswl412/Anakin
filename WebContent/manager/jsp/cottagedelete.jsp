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
<form action="cotdelete"  method="post">
<h2>${manager_id}님 <br>
${param.cottage_id}코드의 Cottage를 삭제 합니까?</h2>
<table>
<tr>
<td><input type="button" value="돌아가기" onclick="location.href='/Anakin/managerinfo'"></td>
<td>
<input type="submit" value="삭제하기">
</td>
</tr>
</table>
</form>
</body>
</html>