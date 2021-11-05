<%@page import="com.anakin.manager.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${manager_id}님의 <span id="cottage_name">${param.cottage_name}</span>의 객실 리스트<%@ include file="logout.jsp" %>
	
	<table>
		<tr>
			<td>
				<form name="cottage" action="insertroom" method="get">
				<input type="hidden" name="cottage_name" value="${param.cottage_name}"> 
				<input type="hidden" name="cottage_id" value="${param.cottage_id}"> 
				
				<input type="submit" value="Room 등록">
				</form>
			</td>
			<td>
				<a href="managerinfo">My Cottage List</a>
			</td>
		</tr>
	</table>
	<table border="1">
		<tr>
			<td>방_ID</td>
			<td>방이름</td>
			<td>방_갯수</td>
			<td>수용인원</td>
			<td>평일 가격</td>
			<td>휴일 가격</td>
			<td>성수기 가격</td>
			<td>TV_갯수</td>
			<td>화장실 갯수</td>
			<td>발코니 유무</td>
			<td>예약 상태확인</td>
			<td>방 설명</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		<c:forEach items="${roomlist}" var="crv">
		<tr>
		
			<td>${crv.room_id}</td>
			<td>${crv.room_name}</td>
			<td>${crv.room_count}</td>
			<td>${crv.room_occupancy}</td>
			<td>${crv.room_standard_price}</td>
			<td>${crv.room_holiday_price}</td>
			<td>${crv.room_peak_season_price}</td>
			<td>${crv.room_tv_count}</td>
			<td>${crv.room_bathroom_count}</td>
			<td>${crv.room_balcony_option}</td>
			<td>${crv.room_status}</td>
			<td>${crv.room_description}</td>
			<td>
			<form action="roomupdateget" method="post">
			<input type="hidden" name="room_id" value="${crv.room_id}">
			<input type="hidden" name="cottage_name" value="${param.cottage_name}"> 
			<input type="submit" value="수정">
			</form>
			</td>
			<td><button onclick="call( ${param.cottage_id }, '${param.cottage_name}', ${crv.room_id},'${crv.room_name}')">삭제</button></td>
		</tr>
		</c:forEach>
	</table>
	<script>
	
	function call(cottage_id, cottage_name, room_id, room_name){
		location.href="roomdelete?cottage_id="+cottage_id+"&cottage_name="+cottage_name+"&room_id="+room_id+"&room_name="+room_name;
	}
	</script>
</body>
</html>