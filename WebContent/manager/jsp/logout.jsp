<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<style>
.right {
	border: 1px solid gray;
	padding : 10px;
	float: right;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<div class="right">
		<a href="/Anakin/managerlogin">로그아웃</a><br>
		<form action="managerdelete" method="get">
		<input type="submit" value="탈퇴" >
		</form>
	</div>
</body>
</html>