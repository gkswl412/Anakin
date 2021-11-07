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


<div class="box2">

<h1>리뷰</h1>

<a type="submit" class="btn btn-default"  data-toggle="modal" data-target="#myModal3" 
	     data-reviewreservationid="${reslist.reservation_id}"
	    
	     href="#myModal3" style="float: right;">리뷰 작성</a>

</div>
  <hr>

<br>


<c:forEach items="${reviewlist}" var="rev">



<div class="box">	     
	     
	     
	   <div class="button">
	      
	  
	     <a type="submit" class="btn btn-default"  data-toggle="modal" data-target="#myModal" 
	     data-reviewpw="${rev.review_pw}"  
	     data-reviewid="${rev.review_id}"
	     data-reviewwriter="${rev.review_writer}"  
	     data-reviewdescription="${rev.review_description}"
	     data-reviewdate="${rev.review_date}"  
	     data-reviewtitle="${rev.review_title}" 
	    
	     href="#myModal">수정 </a> 
	 
	      
	     <a type="submit" class="btn btn-default"  data-toggle="modal" data-target="#myModal2" 
	     data-reviewpw="${rev.review_pw}"  
	     href="#myModal2">삭제</a> 
	     
	     </div> 
	     
	     
	<div class="centent">
  <div class="media">
    <div class="media-left">
  </div>
    <div class="media-body">
      <h4 class="media-heading">${rev.review_title }</h4>
      <p>${rev.review_description }</p> 
     <small>${rev.review_writer }</small> <small><i>${rev.review_date }</i></small>    
	   </div>   
	   </div>   
	   </div>   
	     
	     <div class="media">
        <div class="media-left">
        </div>
        <div class="media-body2">
        <div style="background-color:#F5F5F5" >
          <h4 class="media-heading2">매니저</h4>
          <p>${rev.review_comment }</p>
         </div>
	     </div>   
	     </div>   
	    <hr>
	    
</div>	    
	    
</c:forEach>


<!-- 예약번호 조회-->
<div class="modal fade" id="myModal3" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header"> 
        <br><h4 class="modal-title">예약번호 입력</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
         
        </div>
        <div class="modal-body">
           <form id="reservationidfrm" action="/Anakin/review/selectreservationid" method="post">
           
            <div class="form-group">
           <label for="pwd2">예약번호:</label>
         <input type="text"  id="reservation_id" value="" required/>  	
               </div>
            <input type="text" class="form-control"  id="reservation_id2" value="">
            <input type="text" class="form-control"  id="cottage_id2" value="">
   
          </form>
        </div>
         
        <div class="modal-footer">
           <button type="button" class="btn btn-default" onclick="call4()" data-dismiss="modal">확인</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        </div>
      </div>
      
    </div>
  </div>
  





<!-- 작성 -->
  <div class="modal fade" id="myModal_write" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
         <h4 class="modal-title" >리뷰 작성</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
       
        </div>
        <div class="modal-body">
        <form id="writefrm" action="/Anakin/review/write"  method="post">
		<input type="hidden" name="review_id" value="${rev.review_id}">
		<input type="hidden" name="cottage_id" id="cottage_id" value="${cottage_id}">
	  <div class="form-group">
           <label for="usr">작성자:</label>
           <input type="text" class="form-control"  name="review_writer" value="">
       </div>
       <div class="form-group">
           <label for="pwd">비밀번호:</label>
            <input type="text" class="form-control"  name="review_pw" value="" >
       </div>
	  <div class="form-group">
           <label for="title">제목:</label>
            <input type="text" class="form-control"  name="review_title" value="">
       </div>
	        <div class="form-group">
             <label for="description">내용:</label>
             <textarea class="form-control" cols="50" rows="10" name="review_description"></textarea>
            
       </div>
           <input type="submit" class="btn btn-default" onclick="call3()" value="작성" >
           <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
	</form>
        </div>
      </div>
    </div> 
  </div>
  








<!-- 수정2 -->
  <div class="modal fade" id="myModal_update" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
         <h4 class="modal-title">리뷰 수정</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
         
        </div>
        <div class="modal-body">
        <form action="/Anakin/review/updatePost"  method="post">

	<input type="hidden" id="review_id2" name="review_id" value="${rev.review_id}">
	
	
	
	
	  <div class="form-group">
           <label for="usr">작성자:</label>
           <input type="text" class="form-control"  name="review_writer"   id="review_writer2" value="">
       </div>
       <div class="form-group">
           <label for="pwd">비밀번호:</label>
            <input type="text" class="form-control"  name="review_pw"   id="review_pw2" value="">
       </div>
	  <div class="form-group">
           <label for="title">제목:</label>
            <input type="text" class="form-control"  name="review_title"   id="review_title2" value="">
       </div>
	        <div class="form-group">
             <label for="description">내용:</label>
             <textarea name="review_description" class="form-control" id="review_description2" cols="50" rows="10"></textarea>
            
       </div>
           <input type="submit" class="btn btn-default"  value="작성" >
           <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
	</form>
        </div>
      </div>
    </div> 
  </div>
  



<!-- 수정 비밀번호확인-->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
        <h4 class="modal-title">수정</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        
        </div>
        <div class="modal-body">
           <form id="updatefrm" method="post">
           
            <div class="form-group">
           <label for="pwd2">비밀번호:</label>
         <input type="text"  id="review_pw_confirm1" value="">  
               </div>
            <input type="hidden" class="form-control"  id="review_pw_confirm2" value="">
           <input type="hidden"  name="review_id" id="review_id" value=""> 
             
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
          <h4 class="modal-title">삭제</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
           <h4 class="modal-title">삭제</h4>
        </div>
        <div class="modal-body">
           <form id="deletefrm" action="/Anakin/review/delete" method="post" >
            <div class="form-group">
                <label for="pwd2">비밀번호:</label>
                <input type="text" class="form-control"  name="review_pw2" id="review_pw4" value="">
            </div>
              <input type="hidden" name="review_pw" id="review_pw3" value=""> 
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
    		
    		
             $("#review_id").val($(event.relatedTarget).data("reviewid"));
            $("#review_pw_confirm2").val($(event.relatedTarget).data("reviewpw"));
            $("#review_pw2").val($(event.relatedTarget).data("reviewpw"));
            $("#review_id2").val($(event.relatedTarget).data("reviewid"));
            $("#review_title2").val($(event.relatedTarget).data("reviewtitle"));
            $("#review_description2").val($(event.relatedTarget).data("reviewdescription"));
            $("#review_writer2").val($(event.relatedTarget).data("reviewwriter"));
            $("#review_date2").val($(event.relatedTarget).data("reviewdate"));
            $("#cottage_id").val($(event.relatedTarget).data("cottageid"));
            
            
    	});
    	
    	
    	    $("#myModal2").on("show.bs.modal", function(event){
            $("#review_pw3").val($(event.relatedTarget).data("reviewpw"));
          
    	});
    	    $("#myModal3").on("show.bs.modal", function(event){
                $("#reservation_id2").val($(event.relatedTarget).data("reservationid"));
                
               
        	})
    	
  	
    
    });
    

    function call(){
    	var pw1 = $("#review_pw_confirm1").val();
    	var pw2 = $("#review_pw_confirm2").val();
    
    	if(pw1==pw2){
            $("#myModal_update").modal();
    		//$("#updatefrm").submit();
    	   
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
    function call3(){

    	
    		$("#writefrm").submit();
    }
  
    
    function call4(){
    	var id1 = $("#reservation_id").val();
    	var id2 = $("#reservation_id2").val();
    
    	if(id1==id2){
            $("#myModal_write").modal();
    		
    	   
    	}else{
    		alert("예약번호가 틀립니다.");
    	}
    }
    
    
    
  </script>
</body>
</html>