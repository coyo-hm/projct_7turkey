package com.dohwaji.app.admin;

import java.io.IOException;




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;



public class AdminFrontController extends HttpServlet{

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
		
		if(command.equals("/admin/AdminLogin.adm")) {
			
			forward = new ActionForward();
			//forward로 보낸다 
			forward.setRedirect(false);
			forward.setPath("/blue/admin/login.jsp");
						
		}else if(command.equals("/admin/AdminLoginOk.adm")){
			
			forward = new ActionForward();			
			action = new AdminLoginAction();
			
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
		}else if (command.equals("/admin/AdminIndex.adm")) {
			forward = new ActionForward();
			//forward로 보낸다 
			forward.setRedirect(false);
			forward.setPath("/blue/admin/index.jsp");
					
		
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













