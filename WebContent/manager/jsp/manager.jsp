<%@page import="com.anakin.manager.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
#p {overflow: hidden; 
  text-overflow: ellipsis;
  white-space: nowrap; 
  width: 100px;
  height: 20px;}
</style>
<title>${mlist.manager_name}님의Window</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>${mlist.manager_name}님 환영합니다.</h1>
	<%@ include file="logout.jsp" %>
	<h3>${mlist.manager_name}의Cottage </h3>
	
	<table >
		<tr>
			<td>
				<form name="cottage" action="insertcottage" method="get">
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
		<c:forEach items="${cottagelist}" var="cot">
		<tr>
			<td><a href="roomlist?manager_id=${manager_id}&cottage_id=${cot.cottage_id}&cottage_name=${cot.cottage_name}">${cot.cottage_id}</a></td>
			<td>${cot.cottage_name}</td>
			<td>${cot.cottage_location}</td>
			<td>${cot.cottage_phone_number}</td>
			<td id="p">${cot.cottage_description}</td>
			<td>${cot.cottage_cat}</td>
			<td><form action="cotupdata" method="get">
			<input type="hidden" name="cottage_id" value="${cot.cottage_id }">
			<input type="hidden" name="manager_id" value="${mlist.manager_id}">
			<input type="submit" value="수정">
			</form></td>
			<td><button onclick="call1(${cot.cottage_id})">삭제</button></td>
		</tr>
		</c:forEach>
	</table>
	<script>
function call1(cottage_id){
	location.href="cotdelete?cottage_id="+cottage_id;
	
}
</script>
</body>
</html>