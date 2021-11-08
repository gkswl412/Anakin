package com.anakin.manager.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.manager.Service.ManagerService;
import com.anakin.manager.VO.ManagerVO;

@WebServlet("/managerupdate")
public class ManagerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("manager/jsp/managerUpdate.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		ManagerService ms = new ManagerService();

		String mid = request.getParameter("manager_id");
		String mn = request.getParameter("manager_name");
		String mp1 = request.getParameter("manager_pw1");
		String mp2 = request.getParameter("manager_pw2");
		String mp = request.getParameter("manager_phone");
		String me = request.getParameter("manager_email");
		if (mp1.equals(mp2)) {
			ManagerVO mv = new ManagerVO(mid, mp2, mn, mp, me);
			int result = ms.ManagerUpdate(mv);
			if (result == 1) {
				System.out.println("���� ����");
				request.setAttribute("message", "������ �����߽��ϴ�. �ٽ� �α��� ���ּ���.");
				RequestDispatcher rd;
				rd = request.getRequestDispatcher("manager/jsp/result.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("���� ����");
				request.setAttribute("message", "������ �����߽��ϴ�. �ٽ� Ȯ�����ּ���.");
				RequestDispatcher rd;
				rd = request.getRequestDispatcher("manager/jsp/managerUpdate.jsp");
				rd.forward(request, response);
			}
		} else {
			System.out.println("��й�ȣ Ȯ�� ����");
			request.setAttribute("message", "��й�ȣ�� �ٽ� Ȯ�� �ٶ��ϴ�.");
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("manager/jsp/managerUpdate.jsp");
			rd.forward(request, response);

		}

	}

}
