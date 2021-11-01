<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager 신규 등록 화면</title>
<script>
function checkValue()
        {
            var form = document.manager_id;
        
            if(!form.manager_id.value){
                alert("아이디를 입력하세요.");
                return false;
            }
            
            if(form.idDuplication.value != "idCheck"){
                alert("아이디 중복체크를 해주세요.");
                return false;
            }
            
            if(!form.manager_pw1.value){
                alert("비밀번호를 입력하세요.");
                return false;
            }
            
            // 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
            if(form.manager_pw1.value != form.manager_pw2.value ){
                alert("비밀번호를 동일하게 입력하세요.");
                return false;
            }    
            
            if(!form.manager_name.value){
                alert("이름을 입력하세요.");
                return false;
            }
            
            if(!form.manager_email.value){
                alert("메일 주소를 입력하세요.");
                return false;
            }
            
            if(!form.manager_phone.value){
                alert("전화번호를 입력하세요.");
                return false;
            }
            
        }


// 아이디 입력창에 값 입력시 hidden에 idUncheck를 세팅한다.
// 이렇게 하는 이유는 중복체크 후 다시 아이디 창이 새로운 아이디를 입력했을 때
// 다시 중복체크를 하도록 한다.
function inputIdChk(){
    document.manager_id.idDuplication.value ="idUncheck";
}




</script>


</head>

<body>
<h1>Manager 신규 등록</h1>
<form name="manager_id" action="minsert.jsp" method="post">
ManagerID:<input type="text" name="manager_id" maxlength="50">
<input type="button" value="중복확인" onclick="location.href='IDCheck.jsp'">
                         
                        <input type="hidden" name="idDuplication" value="idUncheck" >





 <br>
ManagerPW:<input type="text" name="manager_pw1" ><br>
ManagerPW확인:<input type="text" name="manager_pw2" ><br>
이름:<input type="text" name="manager_name"><br>
핸드폰:<input type="text" name="manager_phone"><br>
이메일:<input type="text" name="manager_email"><br>
<input type="submit" value="입력하기">
<input type="reset" value="다시">
<input type="button" value="돌아가기" onclick="location.href='managerlogin.jsp'">
</form>
</body>
</html>