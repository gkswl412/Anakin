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


	<div class="Reservation_result_box">
		<p>
			<strong>������ �̸�</strong> ${integratedVO.getUser_name()}
		</p>
		<p>
			<strong>���� ��ȣ</strong> ${integratedVO.getReservation_id}
		</p>
		<p>
			<strong>��� �̸�</strong> ${integratedVO.getCottage_name}
		</p>
		<p>
			<strong>�� �̸�</strong> ${integratedVO.getRoom_name}
		</p>
		<p>
			<strong>üũ�� ��¥</strong> ${integratedVO.getReservation_chekin_date}
		</p>
		<p>
			<strong>üũ�ƿ� ��¥</strong> ${integratedVO.getReservation_checkout_date}
		</p>
		<p>
			<strong>����</strong> ${price}
		</p>

	</div>

	<!--   -->


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