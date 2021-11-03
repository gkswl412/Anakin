<%@page import="com.anakin.manager.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${manager_id }
${param.cottage_id }
여기여기
<table>
<tr>
<td>room_id</td>
<td>room_name</td>
<td>room_count</td>
<td>room_occupancy</td>
<td>room_standard_price</td>
<td>room_holyday_price</td>
<td>room_peak_season_price</td>
<td>room_tv_count</td>
<td>room_bathroom_count</td>
<td>room_balcony_option</td>
<td>room_status</td>
<td>room_description</td>
</tr>
<%-- 
<%
List<Cottage_RoomVO> rlist = (List<Cottage_RoomVO>) session.getAttribute("roomlist");
for (Cottage_RoomVO crv : rlist){%>
<tr>
<td><%=crv.getRoom_id %></td>
<td><%=crv.getRoom_name %></td>
<td><%=crv.getRoom_count %></td>
<td><%=crv.getRoom_occupancy %></td>
<td><%=crv.getRoom_standard_price %></td>
<td><%=crv.getRoom_holyday_price %></td>
<td><%=crv.getRoom_peak_season_price %></td>
<td><%=crv.getRoom_tv_count %></td>
<td><%=crv.getRoom_bathroom_count %></td>
<td><%=crv.getRoom_balcony_option %></td>
<td><%=crv.getRoom_status %></td>
<td><%=crv.getRoom_description %></td>
</tr><%}%>--%>
</table> 
</body>
</html>