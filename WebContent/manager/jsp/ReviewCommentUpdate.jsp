<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${review_writer}님의 답변을 입력 합니다.</h3>
<form action="reviewcommentupdateget" method="post">
<table>
<tr>
<td >순번 : ${review_id}</td>
<td colspan ="3">제목 : ${review_title}</td>
</tr>
<tr>
<td colspan="2">날짜 : ${review_date}</td>
<td>작성자 : </td>
<td>${review_writer}</td>
</tr>
<tr>
<td colspan = "5"> 내용 : <br>
${review_description}
</td>
</tr>
<tr>
<td colspan ="5"><textarea cols="50" rows="10" name="review_comment"></textarea></td>
</tr>
<tr>
<td colspan = "3">
<input type="hidden" name="review_id" value="${review_id}">
<input type="hidden" name="cottage_name" value="${cottage_name}"> 
<input type="hidden" name="cottage_id" value="${cottage_id}">
<input type="hidden" name="manager_id" value="${manager_id}">
<input type="submit" value="입력하기"></td>
<td><input type="reset" value="다시"></td>
<td><input type="button" value="돌아가기" onclick="history.back()"></td>
</tr>
</table>
</form>
</body>
</html>