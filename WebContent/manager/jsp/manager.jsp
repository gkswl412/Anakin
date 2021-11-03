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
	<h3>${manager_id}의Cottage</h3>
	<table border="0">
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
		<%
		List<CottageVO> ctlist = (List<CottageVO>) session.getAttribute("cottagelist");
		for (CottageVO cot : ctlist) {%>
		<tr>
			<td><a href="roomlist?cottage_id=<%=cot.getCottage_id()%>"><%=cot.getCottage_id()%></td>
			<td><%=cot.getCottage_name()%></td>
			<td><%=cot.getCottage_location()%></td>
			<td><%=cot.getCottage_phone_number()%></td>
			<td id="p"><%=cot.getCottage_description()%></td>
			<td><%=cot.getCottage_cat()%></td>
			<td><button onclick="call2(<%=cot.getCottage_id()%>);">수정</button></td>
			<td><button onclick="call1(<%=cot.getCottage_id()%>);">삭제</button></td>
		</tr>
		<%
		}
		%>
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