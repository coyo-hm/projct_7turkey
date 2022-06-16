package com.dohwaji.app.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;

public class NoticeFrontController extends HttpServlet {
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

		if (command.equals("/notice/NoticeList.no")) {

			action = new NoticeListAction();

			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
		} else if (command.equals("/notice/noticeListAdmin.no")) {
				
				action = new NoticeListAdminAction();
				
				try {
					forward = action.execute(req, resp);
				} catch (Exception e) {
					System.out.println(e);
				}

		} else if (command.equals("/notice/NoticeWrite.no")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/blue/admin/noticeWrite.jsp");

		} else if (command.equals("/notice/NoticeWriteOk.no")) {

			action = new NoticeWriteOkAction();

			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

		} else if (command.equals("/notice/NoticeView.no")) {

			action = new NoticeViewAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

		} else if (command.equals("/notice/FileDownload.no")) {
			action = new FileDownloadAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

		
		} else if (command.equals("/notice/NoticeReport.no")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/blue/admin/reportWrite.jsp");

			

			
		// 공지 게시글 삭제
		}else if(command.equals("/notice/NoticeDeleteOk.no")) {
			action = new NoticeDeleteOkAction();
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
