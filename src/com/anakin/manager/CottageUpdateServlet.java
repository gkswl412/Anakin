package com.anakin.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/cotupdata")
public class CottageUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("manager/jsp/cottageUpdate.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		CottageService cs = new CottageService();
		HttpSession session = request.getSession();
		
		String cnm = request.getParameter("cottage_name");
		String cl = request.getParameter("cottage_location");
		String cpn = request.getParameter("cottage_phone_number");
		String cd = request.getParameter("cottage_description");
		String cc = request.getParameter("cottage_cat");
		String clx = request.getParameter("cottage_longitude_x");
		String cly = request.getParameter("cottage_latitude_y");
		
		CottageVO c = new CottageVO(cnm, cl, cpn, cd, cc, clx, cly);
		int result = cs.CottageUpdateService(c);
		System.out.println("여기1");
		request.setAttribute("message", result>0?"입력 성공":"입력 실패");
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("manager/jsp/result3.jsp");
		rd.forward(request, response);
	}

}
