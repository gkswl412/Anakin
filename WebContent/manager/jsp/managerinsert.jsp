<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager 신규 등록 화면</title>

</head>
<!-- onclick="location.href='/manager/jsp/IDCheck.jsp'" -->
<body>
<h1>Manager 신규 등록</h1>
<form name="IDcheckgo" action="goIDcheck" method="get">
<input type="submit" value="ID중복확인을 위해 먼저 실행">
</form>
<form name="manager_id" action="managerinsert" method="post">
ManagerID:<input type="text" value="${manager_id}" name="manager_id" maxlength="50" required="required">
<br>
ManagerPW:<input type="text" name="manager_pw" required="required"><br>
이름:<input type="text" name="manager_name" required="required"><br>
핸드폰:<input type="text" name="manager_phone" required="required"><br>
이메일:<input type="text" name="manager_email" required="required"><br>
<input type="submit" value="입력하기">
<input type="reset" value="다시">
<input type="button" value="돌아가기" onclick="location.href='/Anakin/managerlogin'">
</form>
</body>
</html>