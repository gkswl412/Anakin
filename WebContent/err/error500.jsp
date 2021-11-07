<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>여행과 숙박을 동시에 Anakin</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
	div {text-align:center; margin:30px}
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
	
	<script>
		$(function(){
			setTimeout(gotoMain, 3000);
		});
		
		function gotoMain(){
			$(location).attr('href', 'http://localhost:9999/Anakin');
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
      <a class="nav-link" href="#" style="font-size:25px; margin:15px">내 예약 정보</a>
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
<br>
  
<div class="container-fluid" style="margin-top:150px">

<h2>이 페이지는 현재 이용 불가능 합니다.</h2><br>

<h3>빠른 시일내에 안정된 서비스를 제공하겠습니다.</h3>
<h3>메인페이지로 이동합니다.</h3>
	
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