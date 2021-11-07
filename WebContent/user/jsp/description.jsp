<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	${description}
	<br>
	<br>
	<div id="map" style="width:500px;height:400px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5c81e7431dbb2bd1ff2b9efe4091a459"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(${y}, ${x}),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
		
		var markerPosition = new kakao.maps.LatLng(${y}, ${x}); 
	
		var marker = new kakao.maps.Marker({
	   	 	position: markerPosition
		});
	
		marker.setMap(map);
	</script>
</body>

</html>