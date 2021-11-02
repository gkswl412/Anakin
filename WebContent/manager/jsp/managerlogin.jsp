<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Manager 로그인창</title>

</head>
<body> 
<h1>Manager Page</h1>
<table border="0">
<tr><td>
<form name="frmLogin1" method="post" action="managerlogin" encType="UTF-8">
아이디:<input type="text" name="manager_id"><br>
비밀번호:<input type="password" name="manager_pw"><br>
<input type="submit" value="로그인" >
</form></td>
<td>
<form name="frmlogin2" method="get" action="managerinsert" encType="UTF-8">
<input type="submit" value="회원가입" >
</form></td>
</tr>
</table>
</body>
</html>