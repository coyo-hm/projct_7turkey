package com.dohwaji.app.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;

public class MemberFrontController extends HttpServlet{
	
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
		
		if(command.equals("/join/MemberJoin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/blue/join/join.jsp");
		}else if(command.equals("/join/MemberJoinOk.me")){
			action = new MemberJoinOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
		}else if(command.equals("/join/MemberCheckIdOk.me")) {
			action = new MemberCheckIdOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
		}else if(command.equals("/join/MemberPhoneCkOk.me")) {
			action = new MemberPhoneCkOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
		}else if(command.equals("/join/MemberFindId.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/blue/join/findid.jsp");
		}else if(command.equals("/join/MemberFindIdOk.me")) {
			action = new MemberFindIdOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
		}else if(command.equals("/join/MemberFindPw.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/blue/join/findpw.jsp");
		}else if(command.equals("/join/MemberFindPwOk.me")) {
			action = new MemberFindPwOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
		}else if(command.equals("/join/MemberLogin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/blue/join/login.jsp");
		}else if(command.equals("/join/MemberLoginOk.me")) {
			action = new MemberLoginOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
		}else if(command.equals("/join/MemberLogout.me")) {
			action = new MemberLogoutAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
		}else {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/blue/error/404.jsp");
		}
		//일괄처리
		if(forward != null) {
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispather = req.getRequestDispatcher(forward.getPath());
				dispather.forward(req, resp);
			}
		}
	}
}