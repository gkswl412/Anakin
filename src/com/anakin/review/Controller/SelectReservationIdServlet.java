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
@WebServlet("/review/reservedCheckForReview")
public class SelectReservationIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		int reservedId = Integer.parseInt(request.getParameter("reservedId"));
		int cattage_id = Integer.parseInt(request.getParameter("cattage_id"));
		ReviewService service = new ReviewService();

		String result = service.SelectReservationId(reservedId,cattage_id);
		response.getWriter().append(result);

	}

}
