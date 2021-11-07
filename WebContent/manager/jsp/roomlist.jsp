<%@page import="com.anakin.manager.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table {
	margin : auto;
	padding: 20px;
	border-spacing: 30px;
}
h1 {
	color: lightblue;
	text-align: center;
}
body {
	text-align: center;
}
th {
	border-collapse: collapse;
}
button{
width:80px;height:40px;font-size:20px;
}
span {
margin : auto;
}
  #toc-content {
    display: none;
  }
  #toc-toggle {
 margin: auto;
    cursor: pointer;
    color: #2962ff;
  }
  #toc-toggle:hover {
    text-decoration: underline;
  }
  #toc-content1 {
    display: none;
  }
  #toc-toggle1 {
 margin: auto;
    cursor: pointer;
    color: #2962ff;
  }
  #toc-toggle1:hover {
    text-decoration: underline;
  }
</style>
<title>Insert title here</title>
</head>
<body>
	<h1>${mlist.manager_name}님의 <span id="cottage_name">${param.cottage_name}</span>의 객실 리스트
	</h1>
	<%@ include file="logout.jsp" %>
	<table>
	<tr>
	<td colspan="3">
	<form name="cottage" action="insertroom" method="get">
				<input type="hidden" name="cottage_name" value="${param.cottage_name}"> 
				<input type="hidden" name="cottage_id" value="${param.cottage_id}"> 
				<input type="submit" value="Room 등록"  style="width:200px;height:40px;font-size:20px;">
				</form>
				</td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td colspan="2"><a href="managerinfo"  style='font-size:20px;'>My Cottage List</a></td>
	</tr>
		<tr>
			<th>방_ID</th>
			<th>방이름</th>
			<th>방_갯수</th>
			<th>수용인원</th>
			<th>평일 가격</th>
			<th>휴일 가격</th>
			<th>성수기 가격</th>
			<th>TV_갯수</th>
			<th>화장실 갯수</th>
			<th>발코니 유무</th>
			<th>방 설명</th>
			<th>수정</th>
			<th>삭제</th>
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
			<td>${crv.room_description}</td>
			<td>
			<form action="roomupdateget" method="post">
			<input type="hidden" name="room_id" value="${crv.room_id}">
			<input type="hidden" name="cottage_name" value="${param.cottage_name}"> 
			<input type="submit" value="수정" style="width:80px;height:40px;font-size:20px;">
			</form>
			</td>
			<td><button onclick="call( ${param.cottage_id }, '${param.cottage_name}', ${crv.room_id},'${crv.room_name}')">삭제</button></td>
		</tr>
		</c:forEach>
	</table>
	리뷰 테이블 [<span id="toc-toggle" onclick="openCloseToc()">보이기</span>]
	<table id="toc-content" style="text-align:center;">
	<tr>
	<td>순번</td>
	<td>제목</td>
	<td>작성자</td>
	<td>날짜</td>
	<td>내용</td>
	<td>예약번호</td>
	<td>답변 내용</td>
	<td></td>
	</tr>
	<c:forEach items="${rvlist}" var="rv">
	<tr>
	<td>${rv.review_id}</td>
	<td>${rv.review_title}</td>
	<td>${rv.review_writer}</td>
	<td>${rv.review_date}</td>
	<td>${rv.review_description}</td>
	<td>${rv.reservation_id}</td>
	<td>${rv.review_comment}</td>
	<td>
	<form action="reviewcommentupdate" method="post">
	<input type="hidden" name="cottage_name" value="${param.cottage_name}"> 
	<input type="hidden" name="cottage_id" value="${param.cottage_id}">
	<input type="hidden" name="manager_id" value="${mlist.manager_id}">
	<input type="hidden" name="review_id" value="${rv.review_id }">
	<input type="hidden" name="review_title" value="${rv.review_title}">
	<input type="hidden" name="review_writer" value="${rv.review_writer}">
	<input type="hidden" name="review_date" value="${rv.review_date}">
	<input type="hidden" name="review_description" value="${rv.review_description}">
	<input type="hidden" name="reservation_id" value="${rv.reservation_id}">
	<input type="hidden" name="review_comment" value="${rv.review_comment}">
	<input type="submit" value="답변">
	</form>
	</td>
	</tr>
	</c:forEach>
	</table>
	
	<br>
	
	예약 상태 확인[<span id="toc-toggle1" onclick="openCloseToc1()">보이기</span>]
	<table id="toc-content1">
	<tr>
	<td rowspan="2">예약번호</td>
	<td rowspan="2">예약한 방 이름</td>
	<td rowspan="2">예약자 이름</td>
	<td rowspan="2">예약자 번호</td>
	<td rowspan="2">예약사항</td>
	<td>Check In</td>
	<td rowspan="2">비고</td>
	</tr>
	<tr>
	<td>Check Out</td>
	</tr>
	<c:forEach items="${rvtlist}" var="rvt">
	<tr>
	<td rowspan="2">${rvt.reservation_id }</td>
	<td rowspan="2">${rvt.room_name}</td>
	<td rowspan="2">${rvt.user_name }</td>
	<td rowspan="2">${rvt.user_phone_number }</td>
	<td rowspan="2">${rvt.reservation_description }</td>
	<td>${rvt.reservation_checkin_date }</td>
	<td rowspan="2">${message}</td>
	</tr>
	<tr>
	<td>${rvt.reservation_checkout_date }</td>
	</tr>
	</c:forEach>
	</table>
	<script>
	
	function call(cottage_id, cottage_name, room_id, room_name){
		location.href="roomdelete?cottage_id="+cottage_id+"&cottage_name="+cottage_name+"&room_id="+room_id+"&room_name="+room_name;
	}
	function openCloseToc() {
	    if(document.getElementById('toc-content').style.display === 'block') {
	      document.getElementById('toc-content').style.display = 'none';
	      document.getElementById('toc-toggle').textContent = '보이기';
	      document.getElementById('toc-content').style.textAlign = 'center';
	    } else {
	      document.getElementById('toc-content').style.display = 'block';
	      document.getElementById('toc-toggle').textContent = '숨기기';
	      document.getElementById('toc-content').style.textAlign = 'center';
	    }
	  }
	function openCloseToc1() {
	    if(document.getElementById('toc-content1').style.display === 'block') {
	      document.getElementById('toc-content1').style.display = 'none';
	      document.getElementById('toc-toggle1').textContent = '보이기';
	      document.getElementById('toc-content1').style.textAlign = 'center';
	    } else {
	      document.getElementById('toc-content1').style.display = 'block';
	      document.getElementById('toc-toggle1').textContent = '숨기기';
	      document.getElementById('toc-content').style.textAlign = 'center';
	    }
	  }
	</script>
</body>
</html>