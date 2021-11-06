package com.anakin.reservation.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.reservation.Service.CottageRoomService;
import com.anakin.reservation.Service.CottageService;
import com.anakin.reservation.VO.CottageRoomVO;
import com.anakin.reservation.VO.CottageVO;
import com.anakin.reservation.VO.ReservationVO;

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
		String cottageName = request.getParameter("cottageName");
		String roomName = request.getParameter("roomName");
		// Date checkInDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("checkInDate"));
		// Date checkOutDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("checkOutDate"));
		
		String userName = request.getParameter("user_name");
		String userPhoneNumber = request.getParameter("User_phone_number");
		String ReservationPeopleCount = request.getParameter("User_phone_number");
		
		
		//**********declare variable in server**********
		

		//**********do business logic in server**********
		CottageService cottageService = new CottageService();
		CottageRoomService cottageRoomService = new CottageRoomService();
		CottageVO cottageVO = cottageService.selectCottageByNamesService(cottageName);
		CottageRoomVO roomVO = cottageRoomService.selectRoomByNamesService(cottageName, roomName);
		ReservationVO reservationVO = null;	
		
		
		//**********set variables for client in server**********
		request.setAttribute("Cottage_name", roomName);
		request.setAttribute("Room_name", roomName);
		// request.setAttribute("checkInDate", checkInDate);
		// request.setAttribute("checkOutDate", checkOutDate);
		
		
		//**********forward to next page in server**********
		RequestDispatcher rd = request.getRequestDispatcher("reservation/jsp/reservationCancel.jsp");
		rd.forward(request, response);
	}

}
