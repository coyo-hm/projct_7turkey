package com.dohwaji.app.report;

import java.io.IOException;





import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;



public class ReportFrontController extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		if (command.equals("/report/ReportList.rep")) {

			action = new ReportListAction();

			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

		} else if (command.equals("/report/ReportWrite.rep")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/blue/admin/reportWrite.jsp");

		} else if (command.equals("/report/ReportWriteOk.rep")) {

			action = new ReportWriteOkAction();

			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

		} else if (command.equals("/report/ReportView.rep")) {

			action = new ReportViewAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			
			// 공지 게시글 삭제
		} else if (command.equals("/report/ReportDeleteOk.rep")) {
			action = new ReportDeleteOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
			// 
		} else if (command.equals("/report/ReportUpdatePass.rep")) {
			action = new ReportUpdatePassAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			
	
			
			
			
			
			

		} else {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/error/404.jsp");
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}
}
