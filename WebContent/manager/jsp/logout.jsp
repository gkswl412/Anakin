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
		<form action="logout" method="post">
		<input type="submit" value="로그 아웃" style="width:100px;height:30px">
		</form>
		<br>
		<form action="managerdelete" method="get">
		<input type="submit" value="탈퇴" style="width:100px;height:30px">
		</form><br>
		<form action="managerupdate" method="get">
		<input type="submit" value="내 정보 수정" style="width:100px;height:30px"></form>
	</div>
</body>
</html>