<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Cancel reservation</title>
</head>
<body>

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

	
	<div class="Reservation_info_box">
		<!--   
		<div class="Reservation_date_box">
			<form style="text-align: center; padding: 20px; display: block"
				method="get" action="user/search">
				üũ�� ��¥ : <input type="date" name="Reservation_checkin_date" required="required">
				üũ�ƿ� ��¥ : <input type="date" name="Reservation_checkout_date" required="required">
			</form>
		</div>
		-->
		<div class="User_info_box">
			<form style="text-align: center; padding: 20px; display: block"
				method="get" action="reservationConfirm">
				
				<input type="hidden" name="cottageName" value="${cottageName}">
				<input type="hidden" name="roomName" value="${roomName}">
				<input type="hidden" name="checkInDate" value="${checkInDate}">
				<input type="hidden" name="checkOutDate" value="${checkOutDate}">
				
				�̸� : <input type="text" name="user_name" required="required">
				��ȭ��ȣ : <input type="text" name="User_phone_number" required="required">
				�Խ��ο� �� : <input type="number" name="Reservation_people_count" required="required">
				
				<input type="submit" value="Submit">
			</form>
		</div>
	</div>



	<div class="Room_info_box">
		<div class="Room_info_photo_box"></div>
		<div class="Room_info_details_box">
			<p>
				<strong>��� �̸�</strong> ${cottageName}
			</p>
			<p>
				<strong>���� �̸�</strong> ${roomVO.room_name}
			</p>
			<p>
				<strong>üũ�� ��¥</strong> ${checkInDate}
			</p>
			<p>
				<strong>üũ�ƿ� ��¥</strong> ${checkOutDate}
			</p>
			<p>
				<strong>����</strong> <%-- �Ⱓ�� �������� --%>
			</p>
			
		</div>
		<div class="Room_info_sub_details_box">
			<p>
				<strong>�� ����</strong> ${roomVO.RoomCount}
			</p>
			<p>
				<strong>ȭ��� ����</strong> ${roomVO.room_bathroom_count}
			</p>
			<p>
				<strong>���ڴ� ����</strong> ${roomVO.balcony_option}
			</p>
			<p>
				<strong>TV ����</strong> ${roomVO.tv_count}
			</p>
			<p>
				<strong>�߰� ����</strong> ${roomVO.room_description}
			</p>
		</div>
	</div>


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
				<b>�������� 1660-9999</b><br> ���� 9�� - ���� 4��
			</p>
			(��)ANAKIN
			<address>
				�ּ� : ����Ư���� ������ �����̷� 2, CATŸ�� �������<br> ��ǥ�̻� : cat Anakin <span
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