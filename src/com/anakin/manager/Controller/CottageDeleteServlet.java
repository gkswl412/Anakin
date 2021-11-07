package com.anakin.manager.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.manager.Service.CottageService;

@WebServlet("/cotdelete")
public class CottageDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher rd = request.getRequestDispatcher("manager/jsp/cottagedelete.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		CottageService cs = new CottageService();
		
		int cid = Integer.parseInt(request.getParameter("cottage_id"));
	    System.out.println(cid);
	
		int result = cs.CottageDeleteService(cid);
		request.setAttribute("message", result>0?"삭제 되었습니다.":"삭제 실패했습니다.");
		RequestDispatcher rd; rd =
		request.getRequestDispatcher("manager/jsp/result3.jsp"); 
		rd.forward(request, response);
		
		
		
	}
}
