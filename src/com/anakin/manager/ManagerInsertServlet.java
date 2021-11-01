package com.anakin.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/managerinsert.go")
public class ManagerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("managerinsert.jsp");
		 * rd.forward(request, response);
		 */
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿 도착");
		ManagerService service = new ManagerService();
		String mid = request.getParameter("manager_id");
		String mpw = request.getParameter("manager_pw1");		
		String mname = request.getParameter("manager_name");
		String mphone = request.getParameter("manager_phone");
		String memail = request.getParameter("manager_email");
		ManagerVO m = new ManagerVO(mid, mpw, mname, mphone, memail);
		int result = service.ManagerInsertService(m);
		request.setAttribute("message", result>0?"입력 성공":"입력 실패");
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("jsp/result.jsp");
		rd.forward(request, response);
		
	}

	
}
