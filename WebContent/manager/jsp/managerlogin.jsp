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
	<form name="frmLogin1" method="post" action="managerlogin">
		<table>
			<tr>
				<td>아이디:</td>
				<td><input type="text" name="manager_id" required="required"></td>
			<tr>
				<td>비밀번호:</td>
				<td><input type="password" name="manager_pw"></td>
			<tr>
				<td><input type="submit" value="로그인"></td>
				<td></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<td>
				<form name="frmlogin2" method="get" action="managerinsert">
					<input type="submit" value="회원가입">
				</form>
			</td>
		</tr>

	</table>
</body>
</html>