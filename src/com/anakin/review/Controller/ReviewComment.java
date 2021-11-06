package com.anakin.review.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.review.Service.ReviewService;
import com.anakin.review.VO.ReviewVO;

/**
 * Servlet implementation class ReviewComment
 */
@WebServlet("/review/comment")
public class ReviewComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ReviewService service = new ReviewService();
		int reviewid = Integer.parseInt(request.getParameter("reviewid"));
		request.setAttribute("rev", service.SelectById(reviewid));
		RequestDispatcher rd = request.getRequestDispatcher("jsp/commentreview.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		ReviewVO rev = makerev(request);
		ReviewService service = new ReviewService();
		int result = service.CommentReview(rev);
	    request.setAttribute("message", result > 0 ? "성공" : "실패");
		response.sendRedirect("/Anakin/user/cottageDetail");
		
	}


	private ReviewVO makerev(HttpServletRequest request) {
		int reviewid = Integer.parseInt(request.getParameter("review_id"));
		 String review_title = request.getParameter("review_title"); 
		  String review_pw= request.getParameter("review_pw"); 
		 String review_writer = request.getParameter("review_writer"); 
		 String review_description = request.getParameter("review_description");
		String review_comment = request.getParameter("review_comment");
		
		
		
		ReviewVO rev = new ReviewVO();
		rev.setReview_id(reviewid);   
		rev.setReview_title(review_title); 
		 rev.setReview_pw(review_pw);
		 rev.setReview_writer(review_writer);
		 rev.setReview_description(review_description);
		rev.setReview_comment(review_comment);
	
	
		
		return rev;
		
		
	}
		
	

}
