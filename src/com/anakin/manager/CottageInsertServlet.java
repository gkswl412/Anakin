package com.anakin.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/insertcottage")
public class CottageInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("manager/jsp/cottageinsert.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		CottageService cs = new CottageService();
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("manager_id");
		int cid = Integer.parseInt(request.getParameter("cottage_id"));   
		String cnm = request.getParameter("cottage_name");
		String cl = request.getParameter("cottage_location");
		String cpn = request.getParameter("cottage_phone_number");
		String cd = request.getParameter("cottage_description");
		String cc = request.getParameter("cottage_cat");
		String clx = request.getParameter("cottage_longitude_x");
		String cly = request.getParameter("cottage_latitude_y");
		
		CottageVO c = new CottageVO(mid, cid, cnm, cl, cpn, cd, cc, clx, cly);
		int result = cs.CottageInsertService(c);
		System.out.println("����1");
		request.setAttribute("message", result>0?"�Է� ����":"�Է� ����");
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("manager/jsp/result3.jsp");
		rd.forward(request, response);
		
	}

}
