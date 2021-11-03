<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="/reservation/css/reservation_style.css" rel="stylesheet">

<title>Room reservation page</title>

</head>
<body>

	<div class="Reservation_info_box">
		<!--   
		<div class="Reservation_date_box">
			<form style="text-align: center; padding: 20px; display: block"
				method="get" action="user/search">
				체크인 날짜 : <input type="date" name="Reservation_checkin_date" required="required">
				체크아웃 날짜 : <input type="date" name="Reservation_checkout_date" required="required">
			</form>
		</div>
		-->
		<div class="User_name_box">
			<form style="text-align: center; padding: 20px; display: block"
				method="get" action="user/search">
					이름 : <input type="text" name="name" required="required">
					전화번호 : <input type="number" name="User_phone_number" required="required">
					입실인원 수 : <input type="number" name="Reservation_people_count" required="required">
			</form>
		</div>

		<button type="submit" class="btn btn-primary btn-block"
			style="width: 50%; margin-top: 30px; padding: 10px">예약 확인</button>
	</div>



	<div class="Room_info_box">
		<div class="Room_info_photo_box">
		</div>
		<div class="Room_info_details_box">
			<p><strong>펜션 이름</strong></p>
			<p><strong>객실 이름</strong></p>
			<p><strong>체크인 날짜</strong></p>
			<p><strong>체크아웃 날짜</strong></p>
			<p><strong>가격</strong></p>  <%-- 기간별 가격차별 --%>
		</div>
		<div class="Room_info_sub_details_box">
			<p><strong>방 갯수</strong></p>
			<p><strong>화장실 숫자</strong></p>
			<p><strong>발코니 여부</strong></p>
			<p><strong>TV 갯수</strong></p>
			<p><strong>추가 정보</strong></p>
		</div>
	</div>


	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<!-- Brand -->
		<a class="navbar-brand" href="#"
			style="margin-left: 20%; font-size: 35px">Anakin</a>

		<!-- Links -->
		<ul class="navbar-nav" style="margin-left: 20%">
			<li class="nav-item"><a class="nav-link" href="#"
				style="font-size: 25px; margin: 15px">내 예약 정보</a></li>
			<li class="nav-item"><a class="nav-link" href="#"
				style="font-size: 25px; margin: 15px">I'm Manager</a></li>

			<!-- Dropdown -->
			<li class="nav-item dropdown" style="font-size: 25px; margin: 15px">
				<a class="nav-link dropdown-toggle" href="#" id="navbardrop"
				data-toggle="dropdown"> 더 보기 </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">공지사항</a> <a class="dropdown-item"
						href="#">자주 묻는 질문</a> <a class="dropdown-item" href="#">약관 및
						정책</a>
				</div>
			</li>
		</ul>
	</nav>



	<footer
		style="line-height: 18px; font-size: 12px; color: gray; position: absolute; width: 100%">
		<div
			style="margin-top: 100px; height: 400px; width: 100%; text-align: center; background-color: rgb(240, 240, 240); display: inline-block; padding-top: 80px">
			<ul style="list-style: none; padding-left: 0">
				<li style="display: inline"><a
					style="text-decoration: none; font-size: 12px; color: gray" href="">팀소개<span
						style="width: 24px; display: inline-block; text-align: center">|</span></a></li>
				<li style="display: inline"><a
					style="text-decoration: none; font-size: 12px; color: gray" href="">이용약관<span
						style="width: 24px; display: inline-block; text-align: center">|</span></a></li>
				<li style="display: inline"><a
					style="text-decoration: none; font-size: 12px; color: gray" href="">개인정보처리방침<span
						style="width: 24px; display: inline-block; text-align: center">|</span></a></li>
				<li style="display: inline"><a
					style="text-decoration: none; font-size: 12px; color: gray" href="">사업자
						정보확인</a></li>
			</ul>
			<p style="padding: 16px 0 16px 0">
				<b>고객센터 1660-9999</b><br> 오전 9시 - 오후 4시
			</p>
			(주)ANAKIN
			<address>
				주소 : 서울특별시 마포구 고양이로 2, CAT타워 꼭대기층<br> 대표이사 : cat Anakin <span
					style="width: 24px; display: inline-block; text-align: center">|</span>
				집사 : 허선영<br> 통신판매번호 : 2021-서울마포-07777 <span
					style="width: 24px; display: inline-block; text-align: center">|</span>
				관광사업자 등록번호 : 제10000-24호<br> 전화번호 : 1660-9999<br> 전자우편주소 :
				anakin@catanakin.com<br> Copyright GC COMPANY Corp. All rights
				reserved.
			</address>
		</div>
	</footer>
</body>
</html>