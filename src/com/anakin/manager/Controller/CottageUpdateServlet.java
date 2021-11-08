package com.anakin.manager.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anakin.manager.Service.CottageService;
import com.anakin.manager.VO.CottageVO;


@WebServlet("/cotupdata")
public class CottageUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		CottageService cs = new CottageService();
		int cid = Integer.parseInt(request.getParameter("cottage_id"));
		CottageVO cv = cs.selectByCottage_id(cid);
		String mid = request.getParameter("manager_id");
		request.setAttribute("manager_id", mid);
		request.setAttribute("cv", cv);
		
		RequestDispatcher rd = request.getRequestDispatcher("manager/jsp/cottageUpdate.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		CottageService cs = new CottageService();
		String mid = request.getParameter("manager_id");
		int cid =  Integer.parseInt(request.getParameter("cottage_id"));  
		String cnm = request.getParameter("cottage_name");
		String cl = request.getParameter("cottage_location");
		String cpn = request.getParameter("cottage_phone_number");
		String cd = request.getParameter("cottage_description");
		String cc = request.getParameter("cottage_cat");
		String clx = request.getParameter("cottage_longitude_x");
		String cly = request.getParameter("cottage_latitude_y");
		CottageVO c = new CottageVO(mid, cid, cnm, cl, cpn, cd, cc, clx, cly);
		int result = cs.CottageUpdateService(c);
		request.setAttribute("message", result>0?"입력 성공":"입력 실패");
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("manager/jsp/result3.jsp");
		rd.forward(request, response);
	}

}
