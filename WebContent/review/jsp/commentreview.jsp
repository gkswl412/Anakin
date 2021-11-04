<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	<form action="comment"  method="post">
	<input type="hidden" name="review_id" value="${rev.review_id}">
	<input type="hidden" name="review_title" value="${rev.review_title}">
	<input type="hidden" name="review_writer" value="${rev.review_writer}">
	<input type="hidden" name="review_pw" value="${rev.review_pw}">
	<input type="hidden" name="review_date" value="${rev.review_date}">
	<input type="hidden" name="review_description" value="${rev.review_description}">

	
	
	
	
	
	<div class="container">
  <h2>답변 작성</h2>

    <div class="form-group">
      <label for="comment">Comment:</label>
      <textarea class="form-control" rows="5" name="review_comment"></textarea>
      <input type="submit" value="작성 완료">
    </div>
  
</div>
	
	
	</form>
	
	


</body>
</html>