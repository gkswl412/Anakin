
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.anakin.manager.*" %>

<%
	request.setCharacterEncoding("utf-8");

	String mid = request.getParameter("manager_id");
	String mpw = request.getParameter("manager_pw");
	
	ManagerService ms = new ManagerService();
	int check = ms.ManagerLoginCheck(mid, mpw);
	
	if(check==1){
			session.setAttribute("manager_id", mid);
			response.sendRedirect("manager.jsp");
		}else{
			if(check==0){
				System.out.println("비밀번호 입력 실패");
				request.setAttribute("message", "비밀번호가 잘못 되었습니다.");
				RequestDispatcher rd;
				rd = request.getRequestDispatcher("result.jsp");
				rd.forward(request, response);
			}else{
				System.out.println("존재하는 아이디가 아닙니다.");
				request.setAttribute("message", "존재하는 아이디가 아닙니다.");
				RequestDispatcher rd;
				rd = request.getRequestDispatcher("result.jsp");
				rd.forward(request, response);
			}
		}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
</body>
</html>