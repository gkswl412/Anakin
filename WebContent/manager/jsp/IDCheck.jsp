<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.anakin.manager.*" %>
<%
	request.setCharacterEncoding("utf-8");

	String mid = request.getParameter("manager_id");
	
	ManagerService ms = new ManagerService();
	List<ManagerVO> mvo = ms.CheckID(mid);
		if(mvo != null){
			session.setAttribute("manager_id", mid);
			System.out.println("사용 가능한 아이디 입니다.");
		}else{
			System.out.println("중복된 아이디 입니다.");
			request.setAttribute("message", "중복된 아이디 입니다.");
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);
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