<%@page import="com.anakin.manager.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <% session.setAttribute("cottage_id", ${param.cottage_id}); %> --%>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="cotupdata" method="post">
		<h1>${mlist.manager_name}님<br></h1>
		<h3>
		<input type="hidden" name="manger_id" value="${manager_id}">
		<input type="hidden" name="cottage_id" value="${cv.cottage_id}"> ${cv.cottage_id}코드의 Cottage를 수정합니다.
		</h3>
		<table>
			<tr>
				<td>Cottage이름:</td>
				<td><input type="text" name="cottage_name" value="${cv.cottage_name }" style="width:600px;height:80px;font-size:20px;" required="required"></td>
			</tr>
			<tr>
				<td>Cottage주소:</td>
				<td><input type="text" name="cottage_location" value="${cv.cottage_location }" style="width:600px;height:80px;font-size:15px;" required="required"></td>
			</tr>
			<tr>
				<td>Cottage대표전화:</td>
				<td><input type="text" name="cottage_phone_number" value="${cv.cottage_phone_number }" style="width:600px;height:80px;font-size:20px;"></td>
			</tr>
			<tr>
				<td>Cottage설명:</td>
				<td>
				<textarea cols="50" rows="10" name="cottage_description" style="width:1400px;height:300px;font-size:20px;">${cv.cottage_description }</textarea>
				</td>
			</tr>

			<tr>
				<td>CottageCat:</td>
				<td><select name="cottage_cat" style="width:400px;height:60px;font-size:20px;">
						<option value="${cv.cottage_cat }">${cv.cottage_cat }</option>
						<option value="펜션">펜션</option>
						<option value="콘도">콘도</option>
						<option value="게스트하우스">게스트하우스</option>
						<option value="민박">민박</option>
						<option value="호텔">호텔</option>
						<option value="한옥스테이">한옥스테이</option>
						<option value="모텔">모텔</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="수정하기" style="width:200px;height:40px;font-size:15px;"> 
				<input type="reset" value="다시" style="width:200px;height:40px;font-size:15px;"> 
				<input type="button" value="돌아가기" style="width:200px;height:40px;font-size:15px;" onclick="history.back()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>