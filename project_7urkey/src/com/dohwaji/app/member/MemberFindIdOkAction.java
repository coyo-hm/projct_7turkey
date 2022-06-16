package com.dohwaji.app.member;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.member.dao.MemberDAO;


public class MemberFindIdOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		MemberDAO m_dao = new MemberDAO();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String name = request.getParameter("username");
		String phone = request.getParameter("userphone");
		
		String FindId = m_dao.getFindId(name, phone);
		
		if( FindId != null ) {
			session.setAttribute("session_id", FindId);
			forward.setPath(request.getContextPath() + "/blue/join/findidview.jsp");
		}else {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('아이디와 이메일이 바르지 않습니다. 다시 시도해주세요.');");
			out.println("</script>");
			out.close();
			return null;
		}
		forward.setRedirect(true);
		
		return forward;			
	}
}

	

