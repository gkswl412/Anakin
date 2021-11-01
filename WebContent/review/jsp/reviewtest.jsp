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
<h1>리뷰</h1>
<a href="reviewinserttest.jsp">리뷰작성</a>
<br>


<table border="1">
  <tr>
    <td>no</td> 
    <td>작성자</td>
    <td>제목</td>
    <td>내용</td>
    <td>작성날짜</td>
    <td>삭제<td>
  </tr>


<c:forEach items="${reviewlist}" var="rev">
	  <tr>
	    <td>${rev.review_id}</td>
	    <td>${rev.review_writer }</td>
	    <td>${rev.review_title }</td>
	    <td>${rev.review_description }</td>
	    <td>${rev.review_date }</td>
	    <td><a href="reviewdelete.jsp">삭제</a><td>
	  </tr>
</c:forEach>


</table>

</body>
</html>