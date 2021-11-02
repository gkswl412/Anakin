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
					System.out.println("��й�ȣ �Է� ����");
					request.setAttribute("message", "��й�ȣ�� �߸� �Ǿ����ϴ�.");
					RequestDispatcher rd;
					rd = request.getRequestDispatcher("manager/jsp/result.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("���̵� Ȯ�� ���ּ���.");
					request.setAttribute("message", "���̵� Ȯ�� ���ּ���.");
					RequestDispatcher rd;
					rd = request.getRequestDispatcher("manager/jsp/result.jsp");
					rd.forward(request, response);
				}
			}
		
	}
}
