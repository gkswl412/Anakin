<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cottage 신규 등록 화면</title>

</head>
<!-- onclick="location.href='/manager/jsp/IDCheck.jsp'" -->
<body>
<h1>Cottage 신규 등록</h1>
<form name="IDcheckgo" action="goIDcheck" method="get">
<input type="submit" value="ID중복확인을 위해 먼저 실행">
</form>
<form name="manager_id" action="insertcottage" method="post">
<table border="0">

<tr>
<td>CottageID:</td><td><input type="number" name="cottage_id" maxlength="50" required="required"></td>
</tr>
<tr>
<td>Cottage이름:</td><td><input type="text" name="cottage_name" required="required"></td>
</tr>
<tr>
<td>Cottage주소:</td><td><input type="text" name="cottage_location" required="required"></td>
</tr>
<tr>
<td>Cottage대표전화:</td><td><input type="text" value="010-1111-1111" onfocus="this.value='';" name="cottage_phone_number" ></td>
</tr>
<tr>
<td>Cottage설명:</td><td><input type="text" name="cottage_description" value="미등록" onfocus="this.value='';" width=500, height=300></td>
</tr>

<tr>
<td>CottageCat:</td><td><select name="cottage_cat">
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
<td colspan="2"><input type="submit" value="입력하기">
<input type="reset" value="다시">
<input type="button" value="돌아가기" onclick="location.href='/Anakin/managerinfo'"></td>

</tr>



</table>
</form>
</body>
</html>