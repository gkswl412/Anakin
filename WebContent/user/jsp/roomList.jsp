<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<b>check in:</b> <input type="date" name="checkinDate" id="checkinDate" value="${scVO.checkinDate}" required="required" readonly="readonly"> 
	<b>check out:</b> <input type="date" name="checkoutDate" id="checkoutDate" value="${scVO.checkoutDate}" required="required" readonly="readonly">
	<c:forEach var="item" items="${roomList}">
		  			<div style="margin-bottom:20px; border:1px solid rgba(0,0,0,0.08); height:300px; padding:20px; border-radius:5px">
		  				<div style="width:48%; height:100%; margin:0; float:left">
							<img src="${contextPath}/${item.room_photo_url}" style="width:100%; height:100%; object-fit:cover; text-align:center">
		  				</div>
		  				<div style="width:4%; height:100%; margin:0; float:left">
		  				</div>
		  				<div style="width:48%; height:100%; margin:0; float:left; text-align:left">
		  					<div style="margin-bottom:40px">
								<strong><span style="font-size:30px">${item.room_name}</span></strong>
							</div>
							<div style="height:15%; border-bottom:1px solid rgba(0,0,0,0.08); margin-bottom:30px">
								<div style="width:50%; height:100%; font-size:17px; text-align:left; float:left"><strong>가격</strong></div>
								<div style="width:50%; height:100%; text-align:right; font-size:25px; float:left">
									<strong><fmt:formatNumber value="${item.room_standard_price}" pattern="#,###" />원</strong>
								</div>
							</div>
							<div>
							  	<button data-bs-toggle="modal" data-bs-target="#myModal" style="border:1px solid white; background-color:white; width:100%; margin-bottom:35px">
   					 				객실 상세 정보
 								</button>
								<div class="modal" id="myModal">
									<div class="modal-dialog modal-dialog-centered">
								    	<div class="modal-content">
								
									      <!-- Modal Header -->
									      <div class="modal-header">
									        <h4 class="modal-title">${item.room_name} 상세정보</h4>
									        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
									      </div>
									
									      <!-- Modal body -->
									      <div class="modal-body">
												<b>최대인원</b>: ${item.room_occupancy}명<br>
												<b>tv</b>: ${item.room_tv_count}대<br>
												<b>화장실</b>: ${item.room_bathroom_count}개<br>
												<b>발코니</b>: ${item.balcony_option}<br>
												<b>방</b>: ${item.room_count}개<br><br>
												<h3>설명</h3>
												<hr>
												${item.room_description}
									      </div>
									
									      <!-- Modal footer -->
									      <div class="modal-footer">
									        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
									      </div>
								
								    	</div>
									</div>
								</div>	
								<form action="/Anakin/reservation" method="post">
									<input type="hidden" value="${cottageDetailInfo.cottage_name}" name="cottageName">
									<input type="hidden" value="${item.room_name}" name="roomName">
									<input type="hidden" value="${scVO.checkinDate}" name="checkInDate">
									<input type="hidden" value="${scVO.checkoutDate}" name="checkOutDate">
									<input type="hidden" value="${item.room_standard_price}" name="price">
									<input type="hidden" value="${cottageDetailInfo.cottage_id}" name="cottageId">
									<button id="selectBtn" class="btn btn-primary btn-block" style="width:100%; padding:7px">예약</button>
								</form>
		  					</div>
		  				</div>
		  			</div>
	</c:forEach>
</body>
</html>