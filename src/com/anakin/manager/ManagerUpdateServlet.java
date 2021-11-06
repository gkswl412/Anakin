package com.anakin.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				System.out.println("수정 성공");
				request.setAttribute("message", "수정이 성공했습니다. 다시 로그인 해주세요.");
				RequestDispatcher rd;
				rd = request.getRequestDispatcher("manager/jsp/result.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("수정 실패");
				request.setAttribute("message", "수정이 실패했습니다. 다시 확인해주세요.");
				RequestDispatcher rd;
				rd = request.getRequestDispatcher("manager/jsp/managerUpdate.jsp");
				rd.forward(request, response);
			}
		} else {
			System.out.println("비밀번호 확인 실패");
			request.setAttribute("message", "비밀번호를 다시 확인 바랍니다.");
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("manager/jsp/managerUpdate.jsp");
			rd.forward(request, response);

		}

	}

}
