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


<title>Room reservation page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

	<div class="Room_info_box">
		<div class="Room_info_photo_box"></div>
		<div class="Room_info_details_box"></div>
	</div>
	
	
	
	
	<div class="Reservation_info_box">
		<div class="Reservation_date_box">
			<form style="text-align: center; padding: 20px; display: block"
				method="get" action="user/search">
				üũ�� ��¥ : <input type="date" name="Reservation_checkin_date" required="required">
				üũ�ƿ� ��¥ : <input type="date" name="Reservation_checkout_date" required="required">
			</form>
		</div>
		<div class="User_name_box">
			<form style="text-align: center; padding: 20px; display: block"
				method="get" action="user/search">
			<div style="margin-top: 20px">
				�̸� : <input type="text" name="name" required="required">
			</div>
			</form>
		</div>
		<div class="User_phone_number_box">
			<form style="text-align: center; padding: 20px; display: block"
				method="get" action="user/search">
			<div style="margin-top: 20px">
				��ȭ��ȣ : <input type="number" name="User_phone_number" required="required">
			</div>
			</form>
		</div>
		<div class="Reservation_people_count_box">
			<form style="text-align: center; padding: 20px; display: block"
				method="get" action="user/search">
			<div style="margin-top: 20px">
				�Խ��ο� �� : <input type="number" name="Reservation_people_count" required="required">
			</div>
			</form>
		</div>
		
		<button type="submit" class="btn btn-primary btn-block" style="width:50%; margin-top:30px; padding:10px">
		���� Ȯ��</button>
	</div>




	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<!-- Brand -->
		<a class="navbar-brand" href="#"
			style="margin-left: 20%; font-size: 35px">Anakin</a>

		<!-- Links -->
		<ul class="navbar-nav" style="margin-left: 20%">
			<li class="nav-item"><a class="nav-link" href="#"
				style="font-size: 25px; margin: 15px">�� ���� ����</a></li>
			<li class="nav-item"><a class="nav-link" href="#"
				style="font-size: 25px; margin: 15px">I'm Manager</a></li>

			<!-- Dropdown -->
			<li class="nav-item dropdown" style="font-size: 25px; margin: 15px">
				<a class="nav-link dropdown-toggle" href="#" id="navbardrop"
				data-toggle="dropdown"> �� ���� </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">��������</a> <a class="dropdown-item"
						href="#">���� ���� ����</a> <a class="dropdown-item" href="#">��� ��
						��å</a>
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
					style="text-decoration: none; font-size: 12px; color: gray" href="">���Ұ�<span
						style="width: 24px; display: inline-block; text-align: center">|</span></a></li>
				<li style="display: inline"><a
					style="text-decoration: none; font-size: 12px; color: gray" href="">�̿���<span
						style="width: 24px; display: inline-block; text-align: center">|</span></a></li>
				<li style="display: inline"><a
					style="text-decoration: none; font-size: 12px; color: gray" href="">��������ó����ħ<span
						style="width: 24px; display: inline-block; text-align: center">|</span></a></li>
				<li style="display: inline"><a
					style="text-decoration: none; font-size: 12px; color: gray" href="">�����
						����Ȯ��</a></li>
			</ul>
			<p style="padding: 16px 0 16px 0">
				<b>������ 1660-9999</b><br> ���� 9�� - ���� 4��
			</p>
			(��)ANAKIN
			<address>
				�ּ� : ����Ư���� ������ ����̷� 2, CATŸ�� �������<br> ��ǥ�̻� : cat Anakin <span
					style="width: 24px; display: inline-block; text-align: center">|</span>
				���� : �㼱��<br> ����ǸŹ�ȣ : 2021-���︶��-07777 <span
					style="width: 24px; display: inline-block; text-align: center">|</span>
				��������� ��Ϲ�ȣ : ��10000-24ȣ<br> ��ȭ��ȣ : 1660-9999<br> ���ڿ����ּ� :
				anakin@catanakin.com<br> Copyright GC COMPANY Corp. All rights
				reserved.
			</address>
		</div>
	</footer>
</body>
</html>