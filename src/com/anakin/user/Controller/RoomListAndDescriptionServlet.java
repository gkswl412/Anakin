package com.anakin.user.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.anakin.user.Service.SearchService;
import com.anakin.user.VO.CottageVO;
import com.anakin.user.VO.Cottage_roomVO;

@WebServlet("/user/roomListAndDescription")
public class RoomListAndDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//roomList 출력 위한 Servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List roomList = (List) session.getAttribute("roomList");
		session.setAttribute("roomList",roomList);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/roomList.jsp");
		rd.forward(request, response);
	}
	
	//roomDescription 출력 위한 Servlet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = "";
		int cottage_id = Integer.parseInt(request.getParameter("cottage_id"));
		double x = Double.parseDouble(request.getParameter("x"));
		double y = Double.parseDouble(request.getParameter("y"));
		String cottage_name = request.getParameter("cottage_name");
		
		SearchService service = new SearchService();
		description = service.selectCottageDescriptionByCottageId(cottage_id);
		
		HttpSession session = request.getSession();
		session.setAttribute("description", description);
		session.setAttribute("x", x);
		session.setAttribute("y", y);
		session.setAttribute("cottage_name", cottage_name);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/description.jsp");
		rd.forward(request, response);
	}

}
