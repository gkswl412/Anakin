<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

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


	<div class="Reservation_result_box">
		<p>
			<strong>예약자 이름</strong> ${integratedVO.getUser_name()}
		</p>
		<p>
			<strong>예약 번호</strong> ${integratedVO.getReservation_id}
		</p>
		<p>
			<strong>펜션 이름</strong> ${integratedVO.getCottage_name}
		</p>
		<p>
			<strong>방 이름</strong> ${integratedVO.getRoom_name}
		</p>
		<p>
			<strong>체크인 날짜</strong> ${integratedVO.getReservation_chekin_date}
		</p>
		<p>
			<strong>체크아웃 날짜</strong> ${integratedVO.getReservation_checkout_date}
		</p>
		<p>
			<strong>가격</strong> ${price}
		</p>

	</div>

	<!--   -->


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