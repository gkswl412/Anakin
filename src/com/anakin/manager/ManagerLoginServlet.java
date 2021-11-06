package com.anakin.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/managerlogin")
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("manager/jsp/managerlogin.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String mid = request.getParameter("manager_id");
		String mpw = request.getParameter("manager_pw");
		ManagerService ms = new ManagerService();
		
		ManagerVO mlist = ms.selectAllByManager_ID(mid);
		session.setAttribute("mlist", mlist);
				
		int check = ms.ManagerLoginCheck(mid, mpw);
		
		if(check==1){
				session.setAttribute("manager_id", mid);
				response.sendRedirect("managerinfo");
			}else{
				if(check==0){
					request.setAttribute("message", "��й�ȣ�� �ٽ� Ȯ�����ּ���.");
					RequestDispatcher rd;
					rd = request.getRequestDispatcher("manager/jsp/result.jsp");
					rd.forward(request, response);
				}else{
					request.setAttribute("message", "���̵� Ȯ�� ���ּ���.");
					RequestDispatcher rd;
					rd = request.getRequestDispatcher("manager/jsp/result.jsp");
					rd.forward(request, response);
				}
			}
		
	}
}
