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
	<table>
		<tr>
			<td colspan='2'>
				<form name="IDcheckgo" action="goIDcheck" method="get">
					<input type="submit" value="ID중복확인을 위해 먼저 실행">
				</form>
			</td>

		</tr>
	</table>

	<form name="manager_id" action="managerinsert" method="post">
		<table>
			<tr>
				<td>ManagerID:</td>
				<td><input type="text" value="${manager_id}" name="manager_id"
					maxlength="50" required="required"></td>
			</tr>

			<tr>
				<td>ManagerPW:</td>
				<td><input type="text" name="manager_pw" required="required">
				</td>
			</tr>
			<tr>
				<td>이름:</td>
				<td><input type="text" name="manager_name" required="required"></td>
			</tr>
			<tr>
				<td>핸드폰:</td>
				<td><input type="text" name="manager_phone" required="required"></td>
			</tr>
			<tr>
				<td>이메일:</td>
				<td><input type="text" name="manager_email" required="required"></td>
			</tr>
			<tr>
				<td colspan='2'><input type="submit" value="입력하기"> <input
					type="reset" value="다시"> <input type="button" value="돌아가기"
					onclick="location.href='/Anakin/managerlogin'"></td>
			</tr>
		</table>
	</form>

</body>
</html>