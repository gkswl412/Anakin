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
body {
	text-align: center;
}
</style>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	<h1>ID 체크</h1>
	<form name="mid" action="goIDcheck" method="post">
		<input type="text" name="managerid" placeholder="ManagerID" style="width:300px;height:60px;font-size:20px;" required="required"	required="required"><br><br>
		<input type="submit" style="width:150px;height:50px;font-size:20px;" value="중복확인"><br>
	</form>
</body>
</html>