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
       
	//cottageList ���� ���� ȣ���� Cottage ��ó ������ ���� ��Ÿ���� ���� �κ�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	//cottageList ���� ���� Ŭ���� Cottage �� ���� ���� ���� �κ�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int cottage_id = Integer.parseInt(request.getParameter("cottage_id"));
		String cottage_cat = request.getParameter("cottage_cat");
		String cottage_name = request.getParameter("cottage_name");
		
		String reviewCount = request.getParameter("reviewCount");
		if(reviewCount==null) {
			reviewCount="";
		}
		int rcount = 0;
		if(!reviewCount.equals("")) {
			 rcount = Integer.parseInt(reviewCount);
		}else {
			rcount=0;
		}
		
		String cottage_location = request.getParameter("cottage_location");
		String photo_url = request.getParameter("photo_url");
		
		
		String cottage_longitude_x = request.getParameter("cottage_longitude_x");
		if(cottage_longitude_x==null) {
			cottage_longitude_x="";
		}
		double x = 0;
		if(!cottage_longitude_x.equals("")) {
			 x = Double.parseDouble(cottage_longitude_x);
		}else {
			x=0;
		}
		
		String cottage_latitude_y = request.getParameter("cottage_latitude_y");
		if(cottage_latitude_y==null) {
			cottage_latitude_y="";
		}
		double y = 0;
		if(!cottage_latitude_y.equals("")) {
			 y = Double.parseDouble(cottage_latitude_y);
		}else {
			y=0;
		}
		
		
		String checkIndate = request.getParameter("checkInDate");
		String checkOutdate = request.getParameter("checkOutDate");
		
		//Cottage ������ request scope�� ����
		SearchResultVO cottageDetailInfo = new SearchResultVO(
				cottage_id,cottage_name,cottage_cat,cottage_location,
				photo_url,0,0,x,y,rcount);
		request.setAttribute("cottageDetailInfo", cottageDetailInfo);
		//request.setAttribute("reviewCount", reviewCount);
		
		//Cottage Room ���� request scope�� ����
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
