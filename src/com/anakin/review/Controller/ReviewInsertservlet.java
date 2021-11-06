package com.anakin.review.Controller;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.review.Service.ReviewService;
import com.anakin.review.VO.ReviewVO;

import util.DateUtil;


/**
 * Servlet implementation class ReviewInsertservlet
 */
@WebServlet("/review/write")
public class ReviewInsertservlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * RequestDispatcher rd; 
		 * rd = request.getRequestDispatcher("jsp/reviewinsert.jsp");
		 * rd.forward(request,response);
		 */
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		ReviewVO rev = makerev(request);
		System.out.println(rev);
		ReviewService service = new ReviewService();
		int result = service.InsertReview(rev);
		request.setAttribute("message", result > 0 ? "성공" : "실패");
		 response.sendRedirect("/Anakin/user/cottageDetail");
			/*
			 * RequestDispatcher rd = request.getRequestDispatcher("../user/cottageDetail");
			 * rd.forward(request, response);
			 */
	}


	private ReviewVO makerev(HttpServletRequest request) {
		
		String review_title = request.getParameter("review_title");
		String review_pw = request.getParameter("review_pw");
		String review_writer= request.getParameter("review_writer");
		String review_description = request.getParameter("review_description");
		int cottage_id =Integer.parseInt( request.getParameter("cottage_id"));
		
		ReviewVO rev = new ReviewVO();
	
		rev.setReview_title(review_title);
		rev.setReview_pw(review_pw);
		rev.setReview_writer(review_writer);
		rev.setReview_description(review_description);
		rev.setCottage_id(cottage_id);
		
		return rev;
		
		
	}
	
		
		
	
	}


