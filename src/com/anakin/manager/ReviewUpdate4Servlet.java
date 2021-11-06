package com.anakin.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reviewcommentupdateget")
public class ReviewUpdate4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String mid = request.getParameter("manager_id");
		int cid = Integer.parseInt(request.getParameter("cottage_id"));
		String cn = request.getParameter("cottage_name");
		
		request.setAttribute("manager_id", mid);
		request.setAttribute("cottage_id", cid);
		request.setAttribute("cottage_name", cn);
		
		String rc = request.getParameter("review_comment");
		int rid = Integer.parseInt(request.getParameter("review_id"));
		ReviewService1 rs = new ReviewService1();
		ReviewVO1 rvv = new ReviewVO1(rid, rc); 
		int result = rs.UpdateReview1(rvv);
		request.setAttribute("message", result>0?"입력 성공":"입력 실패");
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("manager/jsp/result5.jsp");
		rd.forward(request, response);
		
	}

}
