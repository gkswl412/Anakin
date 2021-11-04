<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	$(function() {
		var area0 = ["시/도 선택","서울특별시","인천광역시","대전광역시","광주광역시","대구광역시","울산광역시","부산광역시","경기도","강원도","충청북도","충청남도","전라북도","전라남도","경상북도","경상남도","제주도"];
	   	var area1 = ["강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
	    var area2 = ["계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군"];
	    var area3 = ["대덕구","동구","서구","유성구","중구"];
	    var area4 = ["광산구","남구","동구",     "북구","서구"];
	    var area5 = ["남구","달서구","동구","북구","서구","수성구","중구","달성군"];
	    var area6 = ["남구","동구","북구","중구","울주군"];
	    var area7 = ["강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
	    var area8 = ["고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"];
	    var area9 = ["강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
	    var area10 = ["제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
	    var area11 = ["계룡시","공주시","논산시","보령시","서산시","아산시","천안시","금산군","당진군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"];
	    var area12 = ["군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"];
	    var area13 = ["광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
	    var area14 = ["경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
	    var area15 = ["거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"];
	    var area16 = ["서귀포시","제주시","남제주군","북제주군"];

	  	// 시/도 선택 박스 초기화

	  	$("select[name^=sido]").each(function() {
	   	$selsido = $(this);
	   	$.each(eval(area0), function() {
	    $selsido.append("<option value='"+this+"'>"+this+"</option>");
	   	});
	   	$selsido.next().append("<option value=''>구/군 선택</option>");
	  	});

	  	// 시/도 선택시 구/군 설정

	  	$("select[name^=sido]").change(function() {
	   	var area = "area" + $("option", $(this)).index($("option:selected", $(this))); // 선택지역의 구군 Array
	   	var $gugun = $(this).next(); // 선택영역 군구 객체
	   	$("option",$gugun).remove(); // 구군 초기화

	   	if(area == "area0")
	    	$gugun.append("<option value=''>구/군 선택</option>");
	   	else {
	    	$.each(eval(area), function() {
	     	$gugun.append("<option value='"+this+"'>"+this+"</option>");
	    	});
	   	}
	  	});
	  
	  	//숙소찾기 버튼 클릭시 함수 호출
	  	
	  	$("#selectBtn").on('click',getCottageListByAjax);

	 	});
	
	//숙박리스트 Ajax로 가져오는 함수 구현
	function getCottageListByAjax(){
		var url = "/Anakin/user/search";
		var data = {"sido":$("#sido").val(),
					"gugun":$("#gugun").val(),
					"focus":$("#focus").val(),
					"checkinDate":$("#checkinDate").val(),
					"checkoutDate":$("#checkoutDate").val()
					}
		$.ajax({
				url:url,
				data:data,
				type:"get",
				success:function(responseData){
					$("#here").html(responseData)
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
  <a class="navbar-brand" href="#" style="margin-left:20%; font-size:35px">Anakin</a>

  <!-- Links -->
  <ul class="navbar-nav" style="margin-left:20%">
    <li class="nav-item">
      <a class="nav-link" href="#" style="font-size:25px; margin:15px">내 예약 정보</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="managerlogin" style="font-size:25px; margin:15px">I'm Manager</a>
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
  
<div class="container-fluid">

	<div>
		<img src="/Anakin/user/images/main.png" style="width:65%; height:40%; border-radius:10px; margin-top:100px">
	</div>
	  
	<div>
		<select class="form-select form-select-lg" style="display:inline; width:300px" name="sido" id="sido" required="required"></select>
		<select class="form-select form-select-lg" style="display:inline; width:300px" name="gugun" id="gugun" required="required"></select>
		<select class="form-select form-select-lg" style="display:inline; width:300px" name="focus" id="focus" required="required">
			<option>숙박</option>
			<option>관광</option>
		</select>
		<div>
		<b>check in:</b> <input type="date" name="checkinDate" id="checkinDate" required="required"> <b>check out:</b> <input type="date" name="checkoutDate" id="checkoutDate" required="required">
		</div>
		<button id="selectBtn" class="btn btn-primary btn-block" style="width:50%; padding:10px">숙소 검색</button>
	</div>
		
	<div id="here">
		
	</div>       
</div>
	



<footer style="line-height:18px; font-size:12px; color:gray; position:absolute; width:100%">
		<div style="margin-top:100px; height:400px; width:100%; text-align:center; background-color:rgb(240, 240, 240); display:inline-block; padding-top:80px">
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