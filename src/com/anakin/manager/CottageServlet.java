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


@WebServlet("/CottageServlet")
public class CottageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * HttpSession session = request.getSession();
		 * request.setCharacterEncoding("utf-8"); String path =
		 * getServletContext().getRealPath("."); System.out.println(path); String
		 * manager_id = (String)request.getAttribute("manager_id");
		 * 
		 * CottageService cs = new CottageService(); List<CottageVO> ctlist =
		 * cs.selectAllByManager_idService(manager_id);
		 * 
		 * request.setAttribute("cottagelist", ctlist); RequestDispatcher rd; rd =
		 * request.getRequestDispatcher("manager.jsp"); rd.forward(request, response);
		 */
	
	}

	
	

}
