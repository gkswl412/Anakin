package com.anakin.reservation.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.reservation.Service.IntegratedService;
import com.anakin.reservation.VO.IntegratedVO;

/**
 * Servlet implementation class SelectReservationServlet
 */
@WebServlet("/selectReservation")
public class SelectReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/reservation/jsp/reservationSearch.jsp");
		rd.forward(request, response);
	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		//**********get variables from client**********
		long reservationId = Integer.parseInt(request.getParameter("reservation_id"));
		
		//**********declare variable in server**********
		IntegratedVO integratedVO;
		IntegratedService integratedService;
		
		
		//**********do business logic in server**********
		integratedService = new IntegratedService();
		integratedVO = integratedService.selectIntegratedByReservationIdService(reservationId);
		
		
		//**********set variables for client in server**********
		request.setAttribute("integratedVO", integratedVO);

		//**********forward to next page in server**********
		RequestDispatcher rd = request.getRequestDispatcher("/reservation/jsp/reservationCheck.jsp");
		rd.forward(request, response);
	}

}
