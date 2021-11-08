package com.anakin.manager.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.manager.Service.Cottage_RoomService;


@WebServlet("/roomdelete")
public class Cottage_RoomDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher rd = request.getRequestDispatcher("manager/jsp/roomdelete.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
        Cottage_RoomService crs = new Cottage_RoomService();
		
		int rid = Integer.parseInt(request.getParameter("room_id"));
		int result = crs.Cottage_RoomDeleteService(rid);
		
		int cid = Integer.parseInt(request.getParameter("cottage_id"));
		String cn = request.getParameter("cottage_name");
		
		request.setAttribute("cottage_id", cid);
		request.setAttribute("cottage_name", cn);
		
		request.setAttribute("message", result>0?"삭제 되었습니다.":"삭제 실패했습니다.");
		RequestDispatcher rd; rd =
		request.getRequestDispatcher("manager/jsp/result5.jsp"); 
		rd.forward(request, response);
	}

}
