package com.dohwaji.app.member;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;
import com.dohwaji.app.member.dao.MemberFilesDAO;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class MemberPhoneCkOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		MemberBean bean = new MemberBean();
		MemberDAO m_dao = new MemberDAO();
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		ActionForward forward = new ActionForward();
		boolean check = false;
		
		String ck_num = request.getParameter("ck_num"); 
		String phone = (String) session.getAttribute("userphone");
		
		boolean result = m_dao.cknum(ck_num, phone);
		
		if(result != false) {
			int chch = m_dao.updateck(phone);
			forward.setPath(request.getContextPath() + "/blue/join/login.jsp");
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('인증이 이루어지지 않았습니다. 다시 시도해주세요.');");
			out.println("</script>");
			out.close();
			return null;
		}
		
		forward.setRedirect(true);
		
		return forward;
	}
}

	