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
import com.anakin.review.VO.ReviewReservationIdVO;
import com.anakin.review.VO.ReviewVO;


/**
 * Servlet implementation class InsertReservationIdServlet
 */
@WebServlet("/review/selectreservationid")
public class SelectReservationIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		request.setCharacterEncoding("utf-8");
	   

      int cottage_id =Integer.parseInt(request.getParameter("cottage_id"));
  	
   	ReviewService service = new ReviewService();
 
	List<ReviewReservationIdVO> reslist = service.SelectReservationId(cottage_id);
	request.setAttribute("reslist", reslist);
   	request.setAttribute("cottage_id",cottage_id);

	  RequestDispatcher rd = request.getRequestDispatcher("jsp/reviewlist.jsp");
   	  rd.forward(request, response);
   
   
   
       
	}

}
