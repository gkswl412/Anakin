package com.anakin.reservation.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.reservation.Service.ReservationService;
 
@WebServlet("/reservation/selectAllReservation") // ***** ServletMappingName is selectAllReservation.
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("reservation.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("SelectAllReservation doPost...."); // test code.
		
		request.setCharacterEncoding("utf-8");
		String para = request.getParameter("submit");
		ReservationService service = new ReservationService();
		request.setAttribute("reservationList", service.selectAllReservation());
		RequestDispatcher rd = request.getRequestDispatcher("jsp/selectAllReservationResult.jsp"); // with / absolute
		rd.forward(request, response);
	}

}
