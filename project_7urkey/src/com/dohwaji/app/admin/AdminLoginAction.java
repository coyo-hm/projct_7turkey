package com.dohwaji.app.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.admin.dao.UserDao;



public class AdminLoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		
		ActionForward forward = new ActionForward();
		
		
		//다오를 깨우자
		UserDao u_dao = new UserDao();
		
		HttpSession session = request.getSession();
		
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		
		
		System.out.println(id);
		System.out.println(password);
		
		String userinfo = u_dao.adminLogin(id, password);
		
		
		if (userinfo != null && userinfo.equals("admin")) {
			session.setAttribute("id", id);
			forward.setPath(request.getContextPath() + "/admin/AdminIndex.adm");
		}else {
			forward.setPath(request.getContextPath() + "/admin/AdminLogin.adm?login=false");
		}
		//리다이렉트로 보내겠습니다.
		forward.setRedirect(true);
		return forward;

		
	}

}
