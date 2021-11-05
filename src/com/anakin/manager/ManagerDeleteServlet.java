package com.anakin.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/managerdelete")
public class ManagerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("manager/jsp/managerdelete.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String mid = request.getParameter("manager_id");
		String mpw = request.getParameter("manager_pw");
		
		ManagerService ms = new ManagerService();
		int check = ms.ManagerLoginCheck(mid, mpw);
		System.out.println(mid);
		System.out.println(mpw);
		if(check == 1) {
			int result = ms.ManagerDelete(mid);
			request.setAttribute("message", "이용해주셔서 감사합니다.");
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("manager/jsp/result.jsp");
			rd.forward(request, response);
			
		}else if(check == 0) {
			request.setAttribute("message", "비밀번호가 잘못 되었습니다.");
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("manager/jsp/result6.jsp");
			rd.forward(request, response);
			
		}
		
		
	}

}
