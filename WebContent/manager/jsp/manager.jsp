<%@page import="com.anakin.manager.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
tbody tr:nth-child(even)  { background-color: lightgray; }
           /*  tbody tr:nth-child(odd)   { background-color: #d4e9ff; } */
h1 {
	color: lightblue;
	text-align: center;
}
body {
	text-align: center;
}
th{
	font-size: 20px;
}
th {
	border-collapse: collapse;
}
table {
	margin : auto;
	padding: 20px;
}
button{
width:80px;height:40px;font-size:20px;
}
p {
	font-size: 20px;
	/* overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 100px;
	height: 20px; */
}
</style>
<title>${mlist.manager_name}님의Window</title>
<%@ include	file="logout.jsp"%>
</head>
<body>
	<h1>${mlist.manager_name}님 환영합니다.</h1>
	<br>
	<br>
	<br>
	<table>
		<tr>
			<td colspan="2"><p>${mlist.manager_name}의 Cottage</p></td>
			<td></td>
			<td></td>
			<td></td>
			<td colspan="3">
			<form class="1" name="cottage" action="insertcottage" method="get">
			<input type="submit" value="Cottage등록" style="width:250px;height:40px;font-size:20px;">
			</form>
			</td>
		<tr>
			<th>Cottag 코드</th>
			<th>Cottag 이름</th>
			<th>Cottag 위치</th>
			<th>Cottag 대표번호</th>
			<th>Cottag 분류</th>
			<th>상세보기</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${cottagelist}" var="cot">
			<tr>
				<td><a
					href="roomlist?manager_id=${manager_id}&cottage_id=${cot.cottage_id}&cottage_name=${cot.cottage_name}">${cot.cottage_id}</a></td>
				<td>${cot.cottage_name}</td>
				<td>${cot.cottage_location}</td>
				<td>${cot.cottage_phone_number}</td>
				<td>${cot.cottage_cat}</td>
				<td><form action="cotupdata" method="get">
						<input type="hidden" name="cottage_id" value="${cot.cottage_id }">
						<input type="hidden" name="manager_id" value="${mlist.manager_id}">
						<input type="submit" value="상세보기" style="width:100px;height:40px;font-size:20px;">
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