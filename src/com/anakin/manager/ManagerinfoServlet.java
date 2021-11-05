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

@WebServlet("/managerinfo")
public class ManagerinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("manager_id");
		session.getAttribute("managerlist");
		CottageService cs = new CottageService();
		List<CottageVO> ctlist = cs.selectAllByManager_idService(mid);
		session.setAttribute("cottagelist", ctlist);
		RequestDispatcher rd = request.getRequestDispatcher("manager/jsp/manager.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
	}

}
