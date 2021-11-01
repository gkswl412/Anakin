package com.anakin.review.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.review.Service.ReviewService;
import com.anakin.review.VO.ReviewVO;




;
/**
 * Servlet implementation class reviewServlet
 */
@WebServlet("/review/list")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
	      ReviewService service = new ReviewService();
	      List<ReviewVO> reviewlist = service.SelectList();
	      request.setAttribute("reviewlist", reviewlist);
		  RequestDispatcher rd = request.getRequestDispatcher("jsp/reviewtest.jsp");
     	  rd.forward(request, response);

		
	}

}
