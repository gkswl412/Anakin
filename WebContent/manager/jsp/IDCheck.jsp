<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Manager ID CHECK</h1>
<form name="mid" action="goIDcheck" method="post">
ManagerID:<input type="text" name="manager_id" maxlength="50" required="required">
<input type="submit" value="중복확인"    ><br>
</form>
</body>
</html>