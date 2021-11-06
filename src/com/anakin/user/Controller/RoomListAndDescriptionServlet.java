package com.anakin.user.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.user.VO.Cottage_roomVO;

@WebServlet("/user/roomListAndDescription")
public class RoomListAndDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//roomList 출력 위한 Servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List roomList = (List) request.getAttribute("roomList");
		request.setAttribute("roomList",roomList);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/roomList.jsp");
		rd.forward(request, response);
	}
	
	//roomDescription 출력 위한 Servlet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
