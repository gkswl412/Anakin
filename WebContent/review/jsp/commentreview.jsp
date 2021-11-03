<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="comment"  method="post">
	<input type="hidden" name="review_id" value="${rev.review_id}">
	<input type="hidden" name="review_title" value="${rev.review_title}">
	<input type="hidden" name="review_writer" value="${rev.review_writer}">
	<input type="hidden" name="review_pw" value="${rev.review_pw}">
	<input type="hidden" name="review_date" value="${rev.review_date}">
	<input type="hidden" name="review_description" value="${rev.review_description}">

	
	
		<table style="border: solid 1px gray; padding:2px; width:500px" >
	<tr>
		<td colspan="2" align="center"><b>답변</b></td>
	</tr>
	<tr>
		<td align="center">내용</td>
		<td><textarea name="review_comment" cols="50" rows="10"></textarea></td>
	</tr>
    <tr>
		<td colspan="2" align="center">
			<input type="submit" value="작성 완료">
		</td>
	</tr>
	
	 </table>
	</form>






</body>
</html>