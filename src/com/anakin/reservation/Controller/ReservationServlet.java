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
import com.anakin.reservation.VO.CottageVO;
import com.anakin.reservation.VO.CottageRoomVO;


/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/reservation") // search result list(park) -> ReservationServlet -> reservation.jsp
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
		
		// there should be interface between searchlist and this servlet
		String cottageName = request.getParameter("cottageName"); // from searchResult
		String roomName = request.getParameter("roomName");
//		Date checkInDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("checkInDate"));
//		Date checkOutDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("checkOutDate"));
		
		int price;
		int roomCount;
		int bathroomCount;
		String balconyOption;
		int tvCount;
		String description;

		CottageRoomService roomService = new CottageRoomService();
		CottageRoomVO roomVO = roomService.selectRoomByNamesService(cottageName, roomName);
		
		request.setAttribute("Room_standard_price", roomVO.getRoom_standard_price());
		request.setAttribute("Room_count", roomVO.getRoom_count());
		request.setAttribute("Room_bathroom_count", roomVO.getRoom_bathroom_count());
		request.setAttribute("Room_balcony_option", roomVO.getRoom_balcony_option());
		request.setAttribute("Room_tv_count", roomVO.getRoom_tv_count());
		request.setAttribute("Room_description", roomVO.getRoom_description());
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/reservation.jsp");
		rd.forward(request, response);
	}

}
