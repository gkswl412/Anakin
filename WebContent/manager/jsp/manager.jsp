<%@page import="com.anakin.manager.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${manager_id}님의 Window</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h1>${manager_id}님 환영합니다.</h1>
<h3>${manager_id}의 Cottage</h3>
<table border="0">
<tr>
<td>
<form action="">
<input type="submit" value="Cottage등록">
</form>
</td>
</tr>
</table>
<table border="1">
<tr>
<td>Cottag코드</td>
<td>Cottag이름</td>
<td>Cottag위치</td>
<td>Cottag대표번호</td>
<td>Cottag설명</td>
<td>Cottag_Cat</td>
<td>수정</td>
<td>삭제</td>
</tr>
<%-- <%List<CottageVO> clist = (List<CottageVO>) request.getAttribute("");
for (CottageVO cot : clist) {%>

<tr>
<td><a href="cottageDetail?cottage_id=<%=cot.getCottage_id()%>"><%=cot.getCottage_id() %></a></td>
<td>Cottag이름</td>
<td>Cottag위치</td>
<td>Cottag대표번호</td>
<td>Cottag설명</td>
<td>Cottag_Cat</td>
<td>수정</td>
<td><button onclick="call();">삭제</button></td>
</tr><%}%> --%>
</table>
</body>
</html>