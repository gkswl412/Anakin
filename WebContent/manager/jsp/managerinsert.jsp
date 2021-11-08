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
table {
	text-align: center;
	margin : auto;
	padding: 20px;
	border-spacing: 30px;
}
</style>
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
					<input type="submit" style="width:250px;height:50px;font-size:15px;"  value="ID중복확인을 위해 먼저 실행">
				</form>
			</td>
		</tr>
	</table>
	<form name="manager_id" action="managerinsert" method="post">
		<table>
			<tr>
				<td><input type="text" placeholder="ManagerID" style="width:300px;height:60px;font-size:20px;" value="${managerid}" name="manager_id"
					maxlength="50" required="required"></td>
			</tr>
			<tr>
				<td><input type="text" name="manager_pw" placeholder="ManagerPW" style="width:300px;height:60px;font-size:20px;"required="required">
				</td>
			</tr>
			<tr>
				
				<td><input type="text" name="manager_name" placeholder="이름" style="width:300px;height:60px;font-size:20px;"required="required"></td>
			</tr>
			<tr>
				
				<td><input type="text" name="manager_phone" placeholder="핸드폰번호" style="width:300px;height:60px;font-size:20px;" required="required"></td>
			</tr>
			<tr>
				
				<td><input type="text" name="manager_email" placeholder="이메일" style="width:300px;height:60px;font-size:20px;" required="required"></td>
			</tr>
			<tr>
				<td><input type="submit" style="width:100px;height:40px;font-size:15px;" value="입력하기"> 
				<input type="reset" style="width:100px;height:40px;font-size:15px;" value="다시입력"> 
				<input type="button" style="width:100px;height:40px;font-size:15px;" value="돌아가기" onclick="history.back()"></td>
			</tr>
		</table>
	</form>

</body>
</html>