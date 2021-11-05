package com.anakin.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/roomupdateget")
public class Cottage_RoomUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Cottage_RoomService crs = new Cottage_RoomService();
		long ri = Long.parseLong(request.getParameter("room_id")); 	
		Cottage_RoomVO room = crs.selectAllByRoom_id(ri);
		String cn = request.getParameter("cottage_name");
		
		
		request.setAttribute("cottage_name", cn);
		request.setAttribute("room", room);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("manager/jsp/roomupdate.jsp");
		rd.forward(request, response);
		
	}

}
