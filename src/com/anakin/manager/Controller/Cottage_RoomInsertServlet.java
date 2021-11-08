package com.anakin.manager.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.manager.Service.Cottage_RoomService;
import com.anakin.manager.VO.Cottage_RoomVO;

@WebServlet("/insertroom")
public class Cottage_RoomInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("manager/jsp/roominsert.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Cottage_RoomService crs = new Cottage_RoomService();
		int cid = Integer.parseInt(request.getParameter("cottage_id"));
		String cn = request.getParameter("cottage_name");
		long rid = cid * 100 + Integer.parseInt(request.getParameter("room_id"));
		
		String rn = request.getParameter("room_name");
		int ro = Integer.parseInt(request.getParameter("room_occupancy"));
		int rp1 = Integer.parseInt(request.getParameter("room_price1"));
		int rp2 = Integer.parseInt(request.getParameter("room_price2"));
		int rp3 = Integer.parseInt(request.getParameter("room_price3"));
		int rtc = Integer.parseInt(request.getParameter("room_tv_count"));
		int rbc = Integer.parseInt(request.getParameter("room_bathroom_count"));
		String rbo = request.getParameter("room_balcony_option");
		String rs = request.getParameter("room_status");
		String rd = request.getParameter("room_description");
		
		
		int rc = Integer.parseInt(request.getParameter("room_count"));
		Cottage_RoomVO cr = new Cottage_RoomVO(cid, rid, rn, ro, rp1, rp2, rp3, rtc, rbc, rbo, rs, rd, rc);
		int result = crs.Cottage_RoomInsertService(cr);
		
		request.setAttribute("cottage_id", cid);
		request.setAttribute("cottage_name", cn);
		
		request.setAttribute("message", result > 0 ? "정상적으로 등록이 되었습니다." : "등록 실패");
		RequestDispatcher rd1;
		rd1 = request.getRequestDispatcher("manager/jsp/result5.jsp");
		rd1.forward(request, response);

	}

}
