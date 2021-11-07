<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
</head>
<style>
	span{display:inline-block; color:white; background-color:hsla(0, 0%, 0%, 0.3)}
	#sortBtn button{border-radius:4px; padding:5px; border:1px solid rgba(0,0,0,0.28);
	color:rgba(0,0,0,0.28); background-color:rgba(250, 250, 250, 0.6)}
</style>
<script>
	$(function(){
		$('#lowprice').on('click',f1);
		$('#highprice').on('click',f2);
		$('#manyreview').on('click',f3);
		$('#littlereview').on('click',f4);
		$('img').on('click',f5);
		$('img').on('mouseenter',f6);
	})
	
	function f1(){
		var url = "/Anakin/user/search";
		var data = {"sido":$("#sido").val(),
					"gugun":$("#gugun").val(),
					"focus":$("#focus").val(),
					"checkinDate":$("#checkinDate").val(),
					"checkoutDate":$("#checkoutDate").val(),
					"sort":$('#lowprice').val()
					}
		$.ajax({
				url:url,
				data:data,
				type:"post",
				success:function(responseData){
					$("#here").html(responseData);
					$('#lowprice').css({"color":"#0d6efd","border":"1px solid #0d6efd"});
				},
				fail:function(message){
					$('#here').html(message);
				}
			});
	}
	
	function f2(){
		var url = "/Anakin/user/search";
		var data = {"sido":$("#sido").val(),
					"gugun":$("#gugun").val(),
					"focus":$("#focus").val(),
					"checkinDate":$("#checkinDate").val(),
					"checkoutDate":$("#checkoutDate").val(),
					"sort":$('#highprice').val()
					}
		$.ajax({
				url:url,
				data:data,
				type:"post",
				success:function(responseData){
					$("#here").html(responseData);
					$('#highprice').css({"color":"#0d6efd","border":"1px solid #0d6efd"});
				},
				fail:function(message){
					$('#here').html(message);
				}
			});
	}
	
	function f3(){
		var url = "/Anakin/user/search";
		var data = {"sido":$("#sido").val(),
					"gugun":$("#gugun").val(),
					"focus":$("#focus").val(),
					"checkinDate":$("#checkinDate").val(),
					"checkoutDate":$("#checkoutDate").val(),
					"sort":$('#manyreview').val()
					}
		$.ajax({
				url:url,
				data:data,
				type:"post",
				success:function(responseData){
					$("#here").html(responseData);
					$('#manyreview').css({"color":"#0d6efd","border":"1px solid #0d6efd"});
				},
				fail:function(message){
					$('#here').html(message);
				}
			});
	}
	
	function f4(){
		var url = "/Anakin/user/search";
		var data = {"sido":$("#sido").val(),
					"gugun":$("#gugun").val(),
					"focus":$("#focus").val(),
					"checkinDate":$("#checkinDate").val(),
					"checkoutDate":$("#checkoutDate").val(),
					"sort":$('#littlereview').val()
					}
		$.ajax({
				url:url,
				data:data,
				type:"post",
				success:function(responseData){
					$("#here").html(responseData);
					$('#littlereview').css({"color":"#0d6efd","border":"1px solid #0d6efd"});
				},
				fail:function(message){
					$('#here').html(message);
				}
			});
	}
	
	function f5(){
		$(this).parent().parent().submit();
	}
	
	function f6(){
		$(this).css("cursor","pointer");
	}
</script>
<body>
	<div id="sortBtn">
		<button id="lowprice" value="낮은 가격 순">낮은 가격 순</button>
		<button id="highprice" value="높은 가격 순">높은 가격 순</button>
		<button id="manyreview" value="리뷰 많은 순">리뷰 많은 순</button>
		<button id="littlereview" value="리뷰 적은 순">리뷰 적은 순</button>
	</div>
	<ul style="list-style:none">
		<c:forEach var="item" items="${searchList}" varStatus="vs">
			<li>
			<form method="post" action="user/cottageDetail">
					<input type="hidden" value="${item.cottage_id}" name="cottage_id">
					<input type="hidden" value="${item.cottage_cat}" name="cottage_cat">
					<input type="hidden" value="${item.cottage_name}" name="cottage_name">
					<input type="hidden" value="${item.reviewCount}" name="reviewCount">
					<input type="hidden" value="${item.cottage_location}" name="cottage_location">
					<input type="hidden" value="${item.photo_url}" name="photo_url">
					<input type="hidden" value="${scVO.checkinDate}" name="checkInDate">
					<input type="hidden" value="${scVO.checkoutDate}" name="checkOutDate">
					<input type="hidden" value="${item.cottage_longitude_X}" name="cottage_longitude_x">
					<input type="hidden" value="${item.cottage_latitude_Y}" name="cottage_latitude_y">
				<div style="border:solid 1px lightgray; width:43%; height:280px; margin:0 auto; overflow:hidden">
					<div style="margin:140px 0 0 15px; position:absolute; text-align:left; padding:0; display:inline-block">
						<strong><span style="font-size:15px; color:white; background-color:gray; padding:2px">${item.cottage_cat}</span></strong><br>
						<strong><span style="font-size:29px">${item.cottage_name}</span></strong><br>
						<strong><span style="font-size:18px; color:orange; background-color:hsla(0, 0%, 0%, 0.7)">리뷰(${item.reviewCount})</span></strong><br>
						<strong><span style="font-size:19px">${item.cottage_location}</span></strong><br>
					</div>
					<div style="margin:210px 0 0 450px; position:absolute; text-align:left; padding:0; display:inline-block">
						<strong><span style="font-size:15px">
							<c:choose>
								<c:when test="${item.availableRoomCount==0}">
									업체에 직접 문의
								</c:when>
								<c:otherwise>
									남은 객실 ${item.availableRoomCount}
								</c:otherwise>
							</c:choose>
						</span></strong><br>
						
						<strong><span style="font-size:25px">
							<c:choose>
								<c:when test="${item.price==0}">
									<p style="font-size:15px">가격정보 알 수 없음</p>
								</c:when>
								<c:otherwise>
									<fmt:formatNumber value="${item.price}" pattern="#,###" />원
								</c:otherwise>
							</c:choose>
						</span></strong>
					</div>
					<img src="${item.photo_url}" style="width:100%; height:100%; object-fit:cover; text-align:center">
				</div>
			</form>
			</li>
		</c:forEach>
	</ul>
</body>
</html>