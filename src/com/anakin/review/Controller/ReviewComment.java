package com.anakin.review.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.review.Service.ReviewService;

/**
 * Servlet implementation class ReviewComment
 */
@WebServlet("/ReviewComment")
public class ReviewComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ReviewService service = new ReviewService();
		int reviewid = Integer.parseInt(request.getParameter("reviewid"));
		request.setAttribute("rev", service.SelectById(reviewid));
		RequestDispatcher rd = request.getRequestDispatcher("jsp/commmentreview.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		
		
		
	}

}
