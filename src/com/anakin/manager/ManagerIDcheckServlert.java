package com.anakin.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/goIDcheck")
public class ManagerIDcheckServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("manager/jsp/IDCheck.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String mid = request.getParameter("manager_id");
		HttpSession session = request.getSession();
		ManagerService ms = new ManagerService();
		List<ManagerVO> mvo = ms.IDCheck(mid);
		System.out.println(mid);
		if(mvo != null){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script> alert('중복된 아이디 입니다.'); location.href='goIDcheck';</script>");
			
		}else if(mid == ""){
			System.out.println("아이디를 입력 해주세요.");
			request.setAttribute("message", "아이디를 입력 해주세요.");
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("IDCheck.jsp");
			rd.forward(request, response);
		}else{
			session.setAttribute("manager_id", mid);
			System.out.println("사용 가능한 아이디 입니다.");
			request.setAttribute("message", "사용 가능한 아이디 입니다.");
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("manager/jsp/result2.jsp");
			rd.forward(request, response);
		}
	}
}
