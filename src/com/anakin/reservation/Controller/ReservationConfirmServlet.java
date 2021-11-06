package com.anakin.reservation.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.reservation.Service.CottageRoomService;
import com.anakin.reservation.Service.CottageService;
import com.anakin.reservation.Service.IntegratedService;
import com.anakin.reservation.Service.ReservationService;
import com.anakin.reservation.VO.CottageRoomVO;
import com.anakin.reservation.VO.CottageVO;
import com.anakin.reservation.VO.IntegratedVO;
import com.anakin.reservation.VO.ReservationVO;

/**
 * Servlet implementation class ReservationConfirmServlet
 */
@WebServlet("/reservationConfirm")
public class ReservationConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReservationConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//**********get variables from client**********
		int cottageId = Integer.parseInt(request.getParameter("cottageId"));
		long roomId = Integer.parseInt(request.getParameter("roomId"));
		String cottageName = request.getParameter("cottageName");
		String roomName = request.getParameter("roomName");
		String checkInDate = request.getParameter("checkInDate");
		String checkOutDate = request.getParameter("checkOutDate");
		int price = Integer.parseInt(request.getParameter("price"));
		
		String userName = request.getParameter("user_name");
		String userPhoneNumber = request.getParameter("user_phone_number");
		int reservationPeopleCount = Integer.parseInt(request.getParameter("reservation_people_count"));
		
		
		//**********declare variable in server**********
		ReservationVO reservationVO = null;
		IntegratedVO integratedVO = null;
		long reservationId = 0;
		ReservationService reservationService = new ReservationService();
		IntegratedService integratedService = new IntegratedService();
		
		//**********do business logic in server**********
		reservationVO = new ReservationVO(cottageId, roomId, userName, userPhoneNumber, checkInDate, checkOutDate, reservationPeopleCount);
		reservationService.insertReservationService(reservationVO);
		
		integratedVO = integratedService.selectIntegratedByReservationIdService(reservationId);
		
		
		//**********set variables for client in server**********
		request.setAttribute("integratedVO", integratedVO);
		request.setAttribute("price", price);
		
		//**********forward to next page in server**********
		RequestDispatcher rd = request.getRequestDispatcher("reservation/jsp/reservationCheck.jsp");
		rd.forward(request, response);
	}

}
