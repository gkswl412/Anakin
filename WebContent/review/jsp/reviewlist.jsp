<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="../review/css/reviewpage.css" rel="stylesheet" >
</head>
<body>
<h1>리뷰</h1>
<a href="write">리뷰작성</a>
<hr>

<br>


<c:forEach items="${reviewlist}" var="rev">

	     <tr>
	      <td><a href="comment?reviewid=${rev.review_id}">답변</a><td>
        <td>
	     <a type="submit" class="btn btn-primary"  data-toggle="modal" data-target="#myModal2" 
	     data-reviewpw="${rev.review_pw}"  
	     href="#myModal2">삭제</a> 
	    <td>
	    <td>
	     <a type="submit" class="btn btn-primary"  data-toggle="modal" data-target="#myModal" 
	     data-reviewpw="${rev.review_pw}"  
	     data-reviewid="${rev.review_id}"
	     href="#myModal">수정 </a> 
	    <td>
	    </tr>
	     
	    
	     
	     
	<div>
  <div class="media">
    <div class="media-left">
  </div>
    <div class="media-body">
      <h4 class="media-heading">${rev.review_title }<small><i>${rev.review_date }</i></small></h4>
      <p>${rev.review_writer }</p>     
      <p>${rev.review_description }</p>     
	   </div>   
	   </div>   
	   </div>   
	     
	     <div class="media">
        <div class="media-left">
        </div>
        <div class="media-body">
          <h4 class="media-heading">관리자</h4>
          <p>${rev.review_comment }</p>
	     </div>   
	     </div>   
	    <hr>
</c:forEach>



<!-- 수정 -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">비밀번호 확인</h4>
        </div>
        <div class="modal-body">
           <form id="updatefrm" action="updateGet" method="post">
             <p>비밀번호: <input type="text" name="review_pw2" id="review_pw2" value=""></p>
             <input type="text" name="review_pw" id="review_pw" value=""> 
             <input type="text" name="reviewid" id="review_id" value="">
          </form>
        </div>
         
        <div class="modal-footer">
           <button type="button" class="btn btn-default" onclick="call()" data-dismiss="modal">확인</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        </div>
      </div>
      
    </div>
  </div>
  
  
  <!-- 삭제 -->
  <div class="modal fade" id="myModal2" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">삭제</h4>
        </div>
        <div class="modal-body">
           <form id="deletefrm" action="delete" method="post" >
             <p>비밀번호: <input type="text" name="review_pw2" id="review_pw4" value=""></p>
              <input type="text" name="review_pw" id="review_pw3" value=""> 
          </form>
        </div>
         
        <div class="modal-footer">
           <button type="button" class="btn btn-default" onclick="call2()" data-dismiss="modal">확인</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        </div>
      </div>
      
    </div>
  </div>
  
  
  
  
  
  
  
  
  
  <script>
    $(function(){
    	$("#myModal").on("show.bs.modal", function(event){
            $("#review_pw").val($(event.relatedTarget).data("reviewpw"));
            $("#review_id").val($(event.relatedTarget).data("reviewid"));
    	});
    	
    	
    	$("#myModal2").on("show.bs.modal", function(event){
            $("#review_pw3").val($(event.relatedTarget).data("reviewpw"));
          
    	});
    });
    

    function call(){
    	var pw1 = $("#review_pw").val();
    	var pw2 = $("#review_pw2").val();
    	if(pw1==pw2){
           
    		$("#updatefrm").submit();
    	   
    	}else{
    		alert("비밀번호가 틀립니다.");
    	}
    }
    
    function call2(){
    	var pw1 = $("#review_pw3").val();
    	var pw2 = $("#review_pw4").val();
    	if(pw1==pw2){
  
    		$("#deletefrm").submit();
    		alert("삭제 성공.");
    	}else{
    		alert("비밀번호가 틀립니다.");
    		
    	}
    	
    }
    
  </script>
</body>
</html>