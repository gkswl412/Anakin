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
 * Servlet implementation class ReviewUpdate
 */
@WebServlet("/ReviewUpdate")
public class ReviewUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewService service = new ReviewService();
		request.setAttribute("reviewlist", service.SelectList());
		RequestDispatcher rd = request.getRequestDispatcher("reviewupdate.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		ReviewVO rev = makerev(request);
		ReviewService service = new ReviewService();
		int result = service.UpdateReview(rev);
		request.setAttribute("message", result > 0 ? "입력성공" : "입력실패");
		response.sendRedirect("reviewlist?message=success");
		
	}


	private ReviewVO makerev(HttpServletRequest request) {
		
		String review_title = request.getParameter("review_title");
		String review_pw = request.getParameter("review_pw");
		String review_writer= request.getParameter("review_writer");
		String review_description = request.getParameter("review_description");
		ReviewVO rev = new ReviewVO();
	
	
		rev.setReview_title(review_title);
		rev.setReview_pw(review_pw);
		rev.setReview_writer(review_writer);
			
		
		rev.setReview_description(review_description);
		
		
	
		
		return rev;
		
		
	}
	
		
		
}
