package com.anakin.user.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.anakin.user.Service.GetRoomInfoService;
import com.anakin.user.VO.Cottage_roomVO;
import com.anakin.user.VO.SearchConditionVO;
import com.anakin.user.VO.SearchResultVO;

@WebServlet("/user/cottageDetail")
public class CottageDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//cottageList 에서 사진 호버시 Cottage 근처 관광지 정보 나타내기 위한 부분
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	//cottageList 에서 사진 클릭시 Cottage 상세 정보 들어가기 위한 부분
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int cottage_id = Integer.valueOf(request.getParameter("cottage_id"));
		String cottage_cat = request.getParameter("cottage_cat");
		String cottage_name = request.getParameter("cottage_name");
		//String reviewCount = request.getParameter("reviewCount");
		String cottage_location = request.getParameter("cottage_location");
		String photo_url = request.getParameter("photo_url");
		double cottage_longitude_x = Double.valueOf(request.getParameter("cottage_longitude_x"));
		double cottage_latitude_y = Double.valueOf(request.getParameter("cottage_latitude_y"));
		String checkIndate = request.getParameter("checkInDate");
		String checkOutdate = request.getParameter("checkOutDate");
		
		//Cottage 상세정보 request scope에 저장
		SearchResultVO cottageDetailInfo = new SearchResultVO(
				cottage_id,cottage_name,cottage_cat,cottage_location,
				photo_url,0,0,cottage_longitude_x,cottage_latitude_y,0);
		request.setAttribute("cottageDetailInfo", cottageDetailInfo);
		//request.setAttribute("reviewCount", reviewCount);
		
		//Cottage Room 정보 request scope에 저장
		SearchConditionVO scVO = new SearchConditionVO("","","",checkIndate,checkOutdate);
		GetRoomInfoService service = new GetRoomInfoService();
		List<Cottage_roomVO> roomList = service.selectRoomByCottageId(scVO, cottage_id);
		roomList = service.selectRoomByCottageId(scVO, cottage_id);
		HttpSession session = request.getSession();
		session.setAttribute("roomList", roomList);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/cottageDetailInfo.jsp");
		rd.forward(request, response);
	}

}
