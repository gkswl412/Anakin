<%@page import="com.anakin.manager.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	request.setCharacterEncoding("utf-8");

    String mid = request.getParameter("manager_id");
	String mpw1 = request.getParameter("manager_pw1");		
	String mpw2 = request.getParameter("manager_pw2");		
	String mname = request.getParameter("manager_name");
	String mphone = request.getParameter("manager_phone");
	String memail = request.getParameter("manager_email");
    ManagerService service = new ManagerService();
	
	ManagerVO m = new ManagerVO(mid, mpw1, mname, mphone, memail);
	int result = service.ManagerInsertService(m);
	request.setAttribute("message", result>0?"입력 성공":"입력 실패");
	RequestDispatcher rd;
	rd = request.getRequestDispatcher("result.jsp");
	rd.forward(request, response);
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