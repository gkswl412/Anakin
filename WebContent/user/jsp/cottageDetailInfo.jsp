<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html lang="en">
<head>
  <title>여행과 숙박을 동시에 Anakin</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5c81e7431dbb2bd1ff2b9efe4091a459"></script>
  
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>  
  
<script>
	$(function(){
		$('#reservation').on('click',f1);
		$('#cottageInfo').on('click',f2);
		$('#review').on('click',f3);
		$('#reservation').click();
	});
	
	function f1(){
		$(this).css({"border-bottom":"2px solid #0d6efd","color":"#0d6efd"});
		$('#cottageInfo').css({"border-bottom":"0px solid","color":"#0000006F"});
		$('#review').css({"border-bottom":"0px solid","color":"#0000006F"});
		var url = "/Anakin/user/roomListAndDescription";
		var data = {
					"roomList":"${roomList}"
					}
		$.ajax({
			url:url,
			data:data,
			type:"get",
			success: function(responseData){
				$('#here').html(responseData);
			},
			fail: function(message){
				$('#here').html(message);
			}
		});
	}
	
	function f2(){
		$(this).css({"border-bottom":"2px solid #0d6efd","color":"#0d6efd"});
		$('#reservation').css({"border-bottom":"0px solid","color":"#0000006F"});
		$('#review').css({"border-bottom":"0px solid","color":"#0000006F"});
		var url = "/Anakin/user/roomListAndDescription";
		var data = {
					"cottage_id":${cottageDetailInfo.cottage_id},
					"x":${cottageDetailInfo.cottage_longitude_X},
					"y":${cottageDetailInfo.cottage_latitude_Y},
					"cottage_name":"${cottageDetailInfo.cottage_name}"
					}
		$.ajax({
			url:url,
			data:data,
			type:"post",
			success:function(responseData){
				$('#here').html(responseData);
			},
			fail:function(message){
				$('#here').html(message);
			}
		});
	}
	
	function f3(){
		$(this).css({"border-bottom":"2px solid #0d6efd","color":"#0d6efd"});
		$('#cottageInfo').css({"border-bottom":"0px solid","color":"#0000006F"});
		$('#reservation').css({"border-bottom":"0px solid","color":"#0000006F"});
		var url = "/Anakin/review/list";
		var data = {
					"cottage_id":${cottageDetailInfo.cottage_id}
				   	}
		$.ajax({
			url:url,
			data:data,
			type:"get",
			success:function(responseData){
				$("#here").html(responseData);
			},
			fail:function(message){
				$('#here').html(message);
			}
		});
	}
	
</script>

</head>

<body>


<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
  <!-- Brand -->
  <a class="navbar-brand" href="/Anakin" style="margin-left:20%; font-size:35px">Anakin</a>

  <!-- Links -->
  <ul class="navbar-nav" style="margin-left:20%">
    <li class="nav-item">
      <a class="nav-link" href="/Anakin/reservation/jsp/reservationSearch.jsp" style="font-size:25px; margin:15px">내 예약 확인/예약 취소</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/Anakin/managerlogin" style="font-size:25px; margin:15px">I'm Manager</a>
    </li>

    <!-- Dropdown -->
    <li class="nav-item dropdown" style="font-size:25px; margin:15px">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        더 보기
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="#">공지사항</a>
        <a class="dropdown-item" href="#">자주 묻는 질문</a>
        <a class="dropdown-item" href="#">약관 및 정책</a>
      </div>
    </li>
  </ul>
</nav>


<div class="container-fluid">
	<div style="margin:150px 0 0 0; text-height:18px">
		<div style="width:65%; height:500px; margin:0 auto">
			<div style="width:50%; height:100%; margin:0; float:left">
				<img src="${cottageDetailInfo.photo_url}" style="width:100%; height:100%; object-fit:cover; text-align:center">
			</div>
			<div style="width:5%; height:100%; margin:0; float:left">
			</div>
			<div style="width:45%; height:100%; margin:0; float:left; text-align:left">
				<strong><span style="font-size:15px; color:white; background-color:#0d6efd; padding:2px">${cottageDetailInfo.cottage_cat}</span></strong>
				<strong><span style="font-size:25px">${cottageDetailInfo.cottage_name}</span></strong><br>
				<strong><span style="font-size:18px; color:orange">리뷰(${cottageDetailInfo.reviewCount})</span></strong><br>
				<span style="font-size:19px; color:#0000008F">${cottageDetailInfo.cottage_location}</span><br>
			</div>
		</div>
		<div style="width:65%; height:50px; margin:0 auto">
		</div>
		<div style="width:65%; margin:0 auto">
  			<nav style="margin-bottom:30px">
  				<div style="margin:0; text-align:left; border-bottom:1px solid #0000006F">
  					<button id="reservation" style="padding:10px 15px 10px 15px; color:#0d6efd; background-color:white; border:1px solid white; font-size:21px; border-bottom:2px solid #0d6efd">예약</button>
  					<button id="cottageInfo" style="padding:10px 15px 10px 15px; color:#0000006F; background-color:white; border:1px solid white; font-size:21px">숙소 정보</button>
  					<button id="review" style="padding:10px 15px 10px 15px; color:#0000006F; background-color:white; border:1px solid white; font-size:21px">리뷰</button>				
  				</div>
  			</nav>
  			<div id="here">
	  			
  			</div>
		</div>
	</div>
</div>	



<footer style="line-height:18px; font-size:12px; color:gray; position:absolute; width:100%; margin-left:0; margin-bottom:0">
		<div style="margin:100px 0 0 0; height:400px; width:100%; text-align:center; background-color:rgb(240, 240, 240); display:inline-block; padding-top:80px">
			<ul style="list-style:none; padding-left:0">
				<li style="display:inline"><a style="text-decoration:none; font-size:12px; color:gray" href="">팀소개<span style="width:24px; display:inline-block; text-align:center; background-color:rgb(240, 240, 240); color:gray !important">|</span></a></li>
				<li style="display:inline"><a style="text-decoration:none; font-size:12px; color:gray" href="">이용약관<span style="width:24px; display:inline-block; text-align:center; background-color:rgb(240, 240, 240); color:gray; !important">|</span></a></li>
				<li style="display:inline"><a style="text-decoration:none; font-size:12px; color:gray" href="">개인정보처리방침<span style="width:24px; display:inline-block; text-align:center; background-color:rgb(240, 240, 240); color:gray; !important">|</span></a></li>
				<li style="display:inline"><a style="text-decoration:none; font-size:12px; color:gray" href="">사업자 정보확인</a></li>
			</ul>
			<p style="padding:16px 0 16px 0">
				<b>고객센터 1660-9999</b><br>
				오전 9시 - 오후 4시
			</p>
			(주)ANAKIN
			<address>
				주소 : 서울특별시 마포구 고양이로 2, CAT타워 꼭대기층<br>
				대표이사 : cat Anakin <span style="width:24px; display:inline-block; text-align:center; background-color:rgb(240, 240, 240); color:gray; !important">|</span> 집사 : 허선영<br>
				통신판매번호 : 2021-서울마포-07777 <span style="width:24px; display:inline-block; text-align:center; background-color:rgb(240, 240, 240); color:gray; !important">|</span> 
				관광사업자 등록번호 : 제10000-24호<br>
				전화번호 : 1660-9999<br>
				전자우편주소 : anakin@catanakin.com<br>
				Copyright GC COMPANY Corp. All rights reserved.
			</address>
		</div>
</footer>

</body>
</html>