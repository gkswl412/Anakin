package com.anakin.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/roomlist")
public class Cottage_RoomListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		int cid = Integer.parseInt(request.getParameter("cottage_id"));
		Cottage_RoomService crs = new Cottage_RoomService();
		List<Cottage_RoomVO> rlist = crs.selectAllByCottage_id(cid);
		
		session.setAttribute("roomlist", rlist);
		RequestDispatcher rd = request.getRequestDispatcher("manager/jsp/roomlist.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
