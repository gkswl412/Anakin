<%@page import="com.anakin.manager.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
#p {text-overflow:ellipsis;}
</style>
<title>${manager_id}님의Window</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>${manager_id}님환영합니다.</h1>
	<%@ include file="logout.jsp" %>
	<h3>${manager_id}의Cottage ${mlist.manager_name}</h3>
	
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
			<td id="cid"><a href="roomlist?manager_id=${manager_id}&cottage_id=${cot.cottage_id}&cottage_name=${cot.cottage_name}">${cot.cottage_id}</a></td>
			<td>${cot.cottage_name}</td>
			<td>${cot.cottage_location}</td>
			<td>${cot.cottage_phone_number}</td>
			<td id="p">${cot.cottage_description}</td>
			<td>${cot.cottage_cat}</td>
			<td><button onclick="call2(${cot.cottage_id})">수정</button></td>
			<td><button onclick="call1(${cot.cottage_id})">삭제</button></td>
		</tr>
		</c:forEach>
	</table>
	<script>
function call1(cottage_id){
	location.href="cotdelete?cottage_id="+cottage_id;
	
}
function call2(cottage_id){
	location.href="cotupdata?cottage_id="+cottage_id;
}
</script>
</body>
</html>