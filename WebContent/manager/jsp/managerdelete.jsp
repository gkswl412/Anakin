<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 탈퇴</h1>
<form name="mid" action="managerdelete" method="post">
<input type="hidden" name="manager_id" value="${manager_id}">
<h3>${mlist.manager_name}님 비밀번호를 입력 해주세요.</h3>
ManagerPW:<input type="text" name="manager_pw" required="required">
<input type="submit" value="탈퇴"><br>
<input type="button" value="돌아가기"	onclick="location.href='/Anakin/managerinfo'">
</form>
</body>
</html>