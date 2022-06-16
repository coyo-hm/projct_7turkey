package com.dohwaji.app.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;

public class MypageFrontController extends HttpServlet{
	
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
		
		if(command.equals("/mypage/MypageOpen.my")) {
			action = new MypageOpenAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}else if(command.equals("/mypage/MyPageEnterPW.my")){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/blue/mypage/check_pw.jsp");
		}else if(command.equals("/mypage/MypageCheckOk.my")){
			action = new MypageCheckPWAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}			
		}else if(command.equals("/mypage/MypageUpdateOk.my")){
			action = new MypageUpdateOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}			
		}else if(command.equals("/mypage/MyPageFollower.my")){
			action = new MyPageFollowerAction();
			
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}			
		}else if(command.equals("/mypage/MyPageFollowing.my")){
			action = new MypageFollowingAction();
			
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}			
		}else if(command.equals("/mypage/MypageSignOut.my")){
			action = new MypageSignOutAction();
			
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}			
		}else if(command.equals("/mypage/Follow.my")){
			action = new FollowAction();
			
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}			
		}else if (command.equals("/mypage/MypageBttipCheck.my")) {
			action = new MypageBttipCheckAction();
			
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

		}else if (command.equals("/mypage/MypageBttipCheck2.my")) {
			action = new MypageBttipCheckAction2();
			
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

		}else if (command.equals("/mypage/MypageBttipCheck3.my")) {
			action = new MypageBttipCheckAction3();
			
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

		}else if (command.equals("/mypage/MypageBttipDelete.my")) {
			action = new MypageBttipDeleteAction();
			
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
		
		if(forward != null) {
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}
}
