package com.anakin.manager;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		int cid = Integer.parseInt(request.getParameter("cottage_id"));

		Cottage_RoomService crs = new Cottage_RoomService();
		List<Cottage_RoomVO> rlist = crs.selectAllByCottage_id(cid);

		ReviewService1 rs = new ReviewService1();
		List<ReviewVO1> rvlist = rs.SelectList(cid);

		ReservationService1 rsvs = new ReservationService1();
		List<ReservationVO1> rvtlist = rsvs.selectReservationByCottageId(cid);
		String message ="";
		
		for (ReservationVO1 vo : rvtlist) {
			Date in = vo.getReservation_checkin_date();
			Date out = vo.getReservation_checkout_date();

			Date today = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd"); // 원하는 데이터 포맷 지정
			String strNowDate1 = simpleDateFormat.format(today); // 지정한 포맷으로 변환

			String strNowDate2 = simpleDateFormat.format(in);
			String strNowDate3 = simpleDateFormat.format(out);
			
			int t1 = Integer.parseInt(strNowDate1);
			int t2 = Integer.parseInt(strNowDate2);
			int t3 = Integer.parseInt(strNowDate3);
			System.out.println("======");
			System.out.println(t2-t1);
			System.out.println(t3-t1);
			System.out.println("======");
			if (t2 - t1 >= 0) {
				System.out.println("1");
				message = "예약중";
			} else if (t2 - t1 < 0 && t3 - t1 >= 0) {
				System.out.println("2");
				message = "check in";
			} else {
				System.out.println("3");
				message = "check out";
			}
		}
		
		request.setAttribute("message", message);
		request.setAttribute("rvtlist", rvtlist);
		request.setAttribute("rvlist", rvlist);
		session.setAttribute("roomlist", rlist);
		RequestDispatcher rd = request.getRequestDispatcher("manager/jsp/roomlist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
