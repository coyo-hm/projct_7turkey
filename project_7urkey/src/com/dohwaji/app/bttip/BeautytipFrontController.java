package com.dohwaji.app.bttip;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;

public class BeautytipFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		System.out.println(command);
		if (command.equals("/bttip/BeautySearch.bt")) {
			action = new BeautytipSearchAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
		}else if (command.equals("/bttip/BeautySave.bt")) {
			action = new BeautytipSaveAction(); 
			try {
				forward=action.execute(req, resp); 
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}else if (command.equals("/blue/bttip/BeautyList.bt")) {
			action = new BeautytipListAction(); 
			try {
				forward=action.execute(req, resp); 
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}else if (command.equals("/bttip/BeautytipWrite.bt")) {
			action = new BeautytipWriteAction(); 
			try {
				forward=action.execute(req, resp); 
			} catch (Exception e) {
				System.out.println(e);
			}	
		}else if (command.equals("/bttip/BeautytipView.bt")) {
			action = new BeautytipViewAction();
			try {
				forward=action.execute(req, resp); 
			} catch (Exception e) {
				System.out.println(e);
			}
		}else if (command.equals("/bttip/Bttiplike.bt")) {
			action = new BttiplikeAction();
			try {
				forward=action.execute(req, resp); 
			} catch (Exception e) {
				System.out.println(e);
			}	
		}else if (command.equals("/bttip/BttipDelete.bt")) {
			action = new BeautytipDeleteAction();
			try {
				forward=action.execute(req, resp); 
			} catch (Exception e) {
				System.out.println(e);
			}	
		}else if(command.equals("/bttip/BeautytipViewJSP.bt")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/makeup/makeup_view.jsp");
		}else if(command.equals("/bttip/BeautytipListJSP.bt")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/makeup/makeup_index.jsp");
		}else {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/blue/error/404.jsp");
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
