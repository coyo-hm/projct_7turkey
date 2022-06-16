package com.dohwaji.app.report;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.report.dao.ReportAllBean;
import com.dohwaji.app.report.dao.ReportAllDAO;


public class ReportListAction implements Action{



	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" - ReportListAction = " );
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		ReportAllDAO r_dao = new ReportAllDAO();
		ReportAllBean r_bean = new ReportAllBean();
		
		HttpSession session = request.getSession();
		
		System.out.println("session = " + session);
		
		String temp = request.getParameter("page");
		int page = temp == null ? 1 : Integer.parseInt(temp);
		int pageSize = 10;
		int totalCnt = r_dao.getReportCnt();
		
		int endRow = page * 10;
		int startRow = endRow - 9;
		
		int startPage = ((page - 1) / pageSize) * pageSize + 1;
		int endPage = startPage + 9;
		int totalPage = (totalCnt - 1) / pageSize + 1;
		
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
	
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		System.out.println("totalCnt = " + totalCnt);
		
		request.setAttribute("reportList", r_dao.listAll(startRow, endRow));
		
		
		System.out.println("r_dao.getReportList(startRow, endRow) = " + r_dao.listAll(startRow, endRow));
		
//		String userType = (String)session.getAttribute("admin");
		
		forward.setRedirect(false);
		
		forward.setPath("/blue/admin/reportList.jsp");
		
//		if(userType == null) {
//			forward.setPath("/blue/admin/reportList.jsp");
//		}else if(userType.equals("1")) {
//			forward.setPath("/blue/admin/reportList.jsp");
//		}else {
//			forward.setPath("/blue/admin/reportList.jsp");
//		}
		
		return forward;
	}

}
