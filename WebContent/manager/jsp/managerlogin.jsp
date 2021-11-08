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
table {
font-size:30px; 
margin : auto;
}
</style>
<meta charset="UTF-8">
<title>Manager 로그인창</title>
</head>
<body>
	<h1>관리자 LoginPage</h1>
	<form name="frmLogin1" method="post" action="managerlogin">
		<table>
			<tr>
				<td colspan="2"><input type="text" name="manager_id" placeholder="ManagerID" style="width:300px;height:60px;font-size:20px;" required="required"></td>
			<tr>
				<td colspan="2"><input type="password" name="manager_pw" style="width:300px;height:60px;font-size:20px;" placeholder="ManagerPW"></td>
			<tr>
				<td><input type="submit" style="width:150px;height:50px;font-size:20px;" value="로그인"></td>
				<td><input type="button" style="width:150px;height:50px;font-size:20px;" value="돌아가기" onclick="location.href='/Anakin/' "></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<td>
			<form name="frmlogin2" method="get" action="managerinsert">
					<input type="submit" style="width:200px;height:50px;font-size:20px;" value="회원가입">
				</form>
				
			</td>
		</tr>

	</table>
</body>
</html>