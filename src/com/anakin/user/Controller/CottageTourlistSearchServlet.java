package com.anakin.user.Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.user.Service.SearchService;
import com.anakin.user.VO.SearchConditionVO;
import com.anakin.user.VO.SearchResultVO;

/**
 * Servlet implementation class CottageTourlistSearchServlet
 */
@WebServlet("/user/search")
public class CottageTourlistSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sido = request.getParameter("sido");
		String gugun = request.getParameter("gugun");
		String focus = request.getParameter("focus");
		String checkinDate = request.getParameter("checkinDate");
		String checkoutDate = request.getParameter("checkoutDate");
		System.out.println(sido + gugun + focus + checkinDate + checkoutDate);
		
		SearchConditionVO scVO = new SearchConditionVO(sido,gugun,focus,checkinDate,checkoutDate);
		request.setAttribute("scVO", scVO);
		
		SearchService searchService = new SearchService();
		List<SearchResultVO> searchList = searchService.selectByArea(scVO);
		request.setAttribute("searchList", searchList);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/searchResult.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
