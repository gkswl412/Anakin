package com.anakin.reservation.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.reservation.Service.ReservationService;
import com.anakin.reservation.VO.ReservationVO;

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		//**********get variables from client**********
		long reservationId = Integer.parseInt(request.getParameter("reservation_id"));
		
		//**********declare variable in server**********
		ReservationVO reservationVO;
		ReservationService reservationService;
		
		
		//**********do business logic in server**********
		reservationVO = new ReservationVO();
		reservationService = new ReservationService();
		reservationVO = reservationService.selectReservationById(reservationId);
		
		
		//**********set variables for client in server**********
		request.setAttribute("reservationVO", reservationVO);


		
		//**********forward to next page in server**********
		RequestDispatcher rd = request.getRequestDispatcher("/reservation/jsp/reservationComplete.jsp");
		rd.forward(request, response);
	}

}
