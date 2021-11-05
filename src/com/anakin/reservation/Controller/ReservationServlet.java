package com.anakin.reservation.Controller;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.reservation.Service.CottageRoomService;
import com.anakin.reservation.VO.CottageRoomVO;


/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/reservation") // searchResultList(park, <form><action = "reservationServlet.java") 
							// -> ReservationServlet -> reservation.jsp

public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//**********get variables from client**********
		
		String cottageName = request.getParameter("cottageName"); // from searchResult
		String roomName = request.getParameter("roomName");
		//Date checkInDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("checkInDate"));
		//Date checkOutDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("checkOutDate"));
		
		//**********declare variable in server**********
		// int price;
		// int roomCount;
		// int bathroomCount;
		// String balconyOption;
		// int tvCount;
		// String description;

		//**********do business logic in server**********
		CottageRoomService roomService = new CottageRoomService();
		CottageRoomVO roomVO = roomService.selectRoomByNamesService(cottageName, roomName);
		
		
		//**********set variables for client in server**********
		request.setAttribute("cottageName", cottageName);
		request.setAttribute("roomVO", roomVO);
		//request.setAttribute("checkInDate", checkInDate);
		//request.setAttribute("checkOutDate", checkOutDate);

		
		//**********forward to next page in server**********
		RequestDispatcher rd = request.getRequestDispatcher("jsp/reservation.jsp");
		rd.forward(request, response);
	}

}
