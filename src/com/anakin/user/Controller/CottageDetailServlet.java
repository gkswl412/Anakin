package com.anakin.user.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.user.VO.SearchConditionVO;
import com.anakin.user.VO.SearchResultVO;

@WebServlet("/user/cottageDetail")
public class CottageDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cottage_id = Integer.valueOf(request.getParameter("cottage_id"));
		String cottage_cat = request.getParameter("cottage_cat");
		String cottage_name = request.getParameter("cottage_name");
		String reviewCount = request.getParameter("reviewCount");
		String cottage_location = request.getParameter("cottage_location");
		String photo_url = request.getParameter("photo_url");
		double cottage_longitude_x = Double.valueOf(request.getParameter("cottage_longitude_x"));
		double cottage_latitude_y = Double.valueOf(request.getParameter("cottage_latitude_y"));
		String checkIndate = request.getParameter("checkInDate");
		String checkOutdate = request.getParameter("checkOutDate");
		
		SearchResultVO cottageDetailInfo = new SearchResultVO(
				cottage_id,cottage_name,cottage_cat,cottage_location,
				photo_url,0,0,cottage_longitude_x,cottage_latitude_y,0);
		
		SearchConditionVO reservationDate = new SearchConditionVO("","","",checkIndate,checkOutdate);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
