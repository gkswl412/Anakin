package com.anakin.manager.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reviewcommentupdate")
public class ReviewUpdate3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String rc = request.getParameter("review_comment");
		int rid = Integer.parseInt(request.getParameter("review_id"));
		
		String rt = request.getParameter("review_title");
		String rw = request.getParameter("review_writer");
		String rd1 = request.getParameter("review_date");
		String rdc = request.getParameter("review_description");
		String rrid = request.getParameter("reservation_id");
		
		String mid = request.getParameter("manager_id");
		int cid = Integer.parseInt(request.getParameter("cottage_id"));
		String cn = request.getParameter("cottage_name");
		
		request.setAttribute("manager_id", mid);
		request.setAttribute("cottage_id", cid);
		request.setAttribute("cottage_name", cn);
		
		request.setAttribute("review_title", rt);
		request.setAttribute("review_writer", rw);
		request.setAttribute("review_date", rd1);
		request.setAttribute("review_description", rdc);
		request.setAttribute("reservation_id", rrid);
		
		
		
		
		request.setAttribute("review_comment", rc);
		request.setAttribute("review_id", rid);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("manager/jsp/ReviewCommentUpdate.jsp");
		rd.forward(request, response);
		/* ReviewService1 rs = new ReviewService1();
		 * ReviewVO1 rvv = new ReviewVO1(rid, rc); int result = rs.UpdateReview1(rvv);
		 */
		
		
		
	}

}
