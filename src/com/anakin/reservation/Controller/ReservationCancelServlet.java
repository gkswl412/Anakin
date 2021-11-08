package com.anakin.reservation.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.reservation.Service.ReservationService;

/**
 * Servlet implementation class ReservationCancelServlet
 */
@WebServlet("/reservationCancel")
public class ReservationCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationCancelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//**********get variables from client**********
		long reservationId = Long.parseLong(request.getParameter("reservationId"));
		
		//**********declare variable in server**********
		ReservationService reservationService;
		int deleteResult;
				
				
		//**********do business logic in server**********
		reservationService = new ReservationService();
		deleteResult = reservationService.deleteReservationByIdService(reservationId);

		//**********set variables for client in server**********
		request.setAttribute("deleteResult", deleteResult);
		
		
		//**********forward to next page in server**********
		if(deleteResult == 1) {
			RequestDispatcher rd = request.getRequestDispatcher("/reservation/jsp/reservationCancelComplete.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/reservation/jsp/reservationCancelFail.jsp");
			rd.forward(request, response);
		}
		
	}

}
