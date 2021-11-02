<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>리뷰 작성</h1>
	<form action="write"  method="post">
	
	
	<table style="border: solid 1px gray; padding:2px; width:500px" >
	<tr>
		<td colspan="2" align="center"><b>글을 적어주세요</b></td>
	</tr>
	<tr>
		<td align="center">작성자</td>
		<td><input type="text" name="review_writer" size="15"></td>
	</tr>
	<tr>
		<td align="center">비밀번호</td>
		<td><input type="password" name="review_pw" size="15"></td>
	</tr>
	<tr>
		<td align="center">제목</td>
		<td><input type="text" name="review_title" size="50"></td>
	</tr>
	<tr>
		<td align="center">내용</td>
		<td><textarea name="review_description" cols="50" rows="10"></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="작성 완료">
			<input type="reset" value="다시 작성">
		</td>
	</tr>
</table>
	</form>



</body>
</html>