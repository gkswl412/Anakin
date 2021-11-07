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
body{
text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 탈퇴</h1>
	<form name="mid" action="managerdelete" method="post">
		<input type="hidden" name="manager_id" value="${manager_id}">
		<h3>${mlist.manager_name}님비밀번호를 입력 해주세요.</h3>
		<input type="text" name="manager_pw" placeholder="패스워드를 입력바랍니다." style="width:300px;height:50px;font-size:15px;" required="required"><br>
		<input type="submit" style="width:140px;height:50px;font-size:15px;" value="탈퇴"> 
		<input type="button" style="width:140px;height:50px;font-size:15px;" value="돌아가기" onclick="history.back()">
	</form>
</body>
</html>