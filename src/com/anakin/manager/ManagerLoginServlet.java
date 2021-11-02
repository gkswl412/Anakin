package com.anakin.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/managerlogin")
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("manager/jsp/managerlogin.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String mid = request.getParameter("manager_id");
		String mpw = request.getParameter("manager_pw");
		
		ManagerService ms = new ManagerService();
		int check = ms.ManagerLoginCheck(mid, mpw);
		HttpSession session = request.getSession();
		if(check==1){
				session.setAttribute("manager_id", mid);
				response.sendRedirect("managerinfo");
			}else{
				if(check==0){
					System.out.println("비밀번호 입력 실패");
					request.setAttribute("message", "비밀번호가 잘못 되었습니다.");
					RequestDispatcher rd;
					rd = request.getRequestDispatcher("manager/jsp/result.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("아이디 확인 해주세요.");
					request.setAttribute("message", "아이디를 확인 해주세요.");
					RequestDispatcher rd;
					rd = request.getRequestDispatcher("manager/jsp/result.jsp");
					rd.forward(request, response);
				}
			}
		
	}
}
