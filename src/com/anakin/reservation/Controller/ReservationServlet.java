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
@WebServlet("/reservation") 
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
		int cottageId = Integer.parseInt(request.getParameter("cottageId"));
		String cottageName = request.getParameter("cottageName"); // from searchResult
		String roomName = request.getParameter("roomName");
		String checkInDate = request.getParameter("checkInDate");
		String checkOutDate = request.getParameter("checkOutDate");
		int price = Integer.parseInt(request.getParameter("price"));
		
		
		//**********declare variable in server**********
		CottageRoomService roomService;
		CottageRoomVO roomVO;
		
		
		//**********do business logic in server**********
		roomService = new CottageRoomService();
		roomVO = roomService.selectRoomByNamesService(cottageName, roomName);
		
		
		//**********set variables for client in server**********
		request.setAttribute("cottageId", cottageId);
		request.setAttribute("cottageName", cottageName);
		request.setAttribute("roomVO", roomVO);
		request.setAttribute("checkInDate", checkInDate);
		request.setAttribute("checkOutDate", checkOutDate);
		request.setAttribute("price", price);

		
		//**********forward to next page in server**********
		RequestDispatcher rd = request.getRequestDispatcher("jsp/reservation.jsp");
		rd.forward(request, response);
	}

}
