package com.Rtn.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Rtn.mdoel.RtnVO;
import com.Rtn.service.RtnService;
import com.Rtn.service.RtnServiceImpl;



@WebServlet("/emp/emp.do")
public class RtnServlet extends HttpServlet {
	// 一個 servlet 實體對應一個 service 實體
	private RtnService rtnService;

	@Override
	public void init() throws ServletException {
		rtnService = new RtnServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String forwardPath = "";
		switch (action) {
			case "getAll":
				forwardPath = getAllEmps(req, res);
				break;
			case "compositeQuery":
				forwardPath = getCompositeEmpsQuery(req, res);
				break;
			default:
				forwardPath = "/index.jsp";
		}
		
		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}

	private String getAllEmps(HttpServletRequest req, HttpServletResponse res) {
		String page = req.getParameter("page");
		int currentPage = (page == null) ? 1 : Integer.parseInt(page);
		
		List<RtnVO> empList = rtnService.getAllEmps(currentPage);

		if (req.getSession().getAttribute("empPageQty") == null) {
			int empPageQty = rtnService.getPageTotal();
			req.getSession().setAttribute("empPageQty", empPageQty);
		}
		
		req.setAttribute("empList", empList);
		req.setAttribute("currentPage", currentPage);
		
		return "/emp/listAllEmps.jsp";
	}
	
	private String getCompositeEmpsQuery(HttpServletRequest req, HttpServletResponse res) {
		Map<String, String[]> map = req.getParameterMap();
		
		if (map != null) {
			List<RtnVO> empList = rtnService.getEmpsByCompositeQuery(map);
			req.setAttribute("empList", empList);
		} else {
			return "/index.jsp";
		}
		return "/emp/listCompositeQueryEmps.jsp";
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
