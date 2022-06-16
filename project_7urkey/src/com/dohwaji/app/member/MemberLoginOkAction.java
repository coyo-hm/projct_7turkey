package com.dohwaji.app.member;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.member.dao.MemberDAO;
import com.dohwaji.app.member.dao.MemberFilesDAO;

public class MemberLoginOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		MemberDAO m_dao = new MemberDAO();
		MemberFilesDAO f_dao =  new MemberFilesDAO();
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		
		Map<String, String>resultMap = m_dao.login(id, pw);
		
		int num = m_dao.getimgnum(id);
		String img = f_dao.selectFiles(num);
		session.setAttribute("session_img", img);
		
		String ck = m_dao.ckForLogin(id);
		
		if(resultMap != null) {
			session.setAttribute("session_id", resultMap.get("USERID"));
			forward.setPath(request.getContextPath() + "/index.jsp");
		}else {
			if( ck != "1") {
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('회원가입을 진행해주세요.');history.back();");
				out.println("</script>");
				out.close();
				return null;
			}else {
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('로그인 실패. 다시 시도해주세요.');history.back();");
				out.println("</script>");
				out.close();
				return null;
			}
		}
		forward.setRedirect(true);
		
		return forward;
	}
}














