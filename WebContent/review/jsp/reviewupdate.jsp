<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="reviewupdate" method="post">
<table border="1">
  <tr>
    <td>No</td>
    <td><input type="text" name="review_id" value="${review_id}"></td>
    <td>닉네임</td>    
    <td><input type="text" name="review_writer" value="${review_writer}"></td>
    <td>제목</td>
     <td><input type="text" name="review_title" value="${review_title}"></td>
    <td>내용</td>
     <td><input type="text" name="review_description" value="${review_description}"></td>
    <td>날짜</td>
     <td><input type="text" name="review_date" value="${review_date}"></td>
    <td>수정</td>
    
  </tr>
  </table>
  
 </form>
 

 
 
 
 
</body>
</html>