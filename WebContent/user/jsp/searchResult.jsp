<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
</head>
<script>
	$(function(){
		$('#lowprice').on('click',f1);
		$('#highprice').on('click',f2);
		$('#manyreview').on('click',f3);
		$('#littlereview').on('click',f4);
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
					$("#here").html(responseData)
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
					$("#here").html(responseData)
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
					$("#here").html(responseData)
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
					$("#here").html(responseData)
				},
				fail:function(message){
					$('#here').html(message);
				}
			});
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
				<div style="border:solid 1px lightgray; width:43%; height:350px; margin:0 auto; overflow:hidden">
					<strong><span style="position:absolute; font-size:27px; color:white; background-color:hsla(0, 0%, 0%, 0.3); padding:5px">${item.cottage_name}</span></strong>
					<a href="#"><img src="${item.photo_url}" style="width:100%; height:100%; object-fit:cover; text-align:center"></a>
				</div>
			</li>
		</c:forEach>
	</ul>
</body>
</html>