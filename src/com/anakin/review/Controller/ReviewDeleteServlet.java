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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/review/delete")
public class ReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException {
	  
	/*
	 * RequestDispatcher rd = request.getRequestDispatcher("jsp/reviewdelete.jsp");
	 * rd.forward(request, response); }
	 */
	  }
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String review_pw = request.getParameter("review_pw");
		System.out.println(review_pw);
		ReviewService service = new ReviewService();
		
		 request.setAttribute("message", service.DeleteReview(review_pw)>0?"삭제성공":"삭제실패");
		 response.sendRedirect("/Anakin");
		 
		
		
		
	}

}
