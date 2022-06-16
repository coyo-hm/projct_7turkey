package com.dohwaji.app.mypage;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;
import com.dohwaji.app.mypage.dao.FollowDAO;
import com.dohwaji.app.mypage.dao.MypageDAO;

public class FollowAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		
		FollowDAO f_dao = new FollowDAO();
		MemberDAO u_dao = new MemberDAO();
		MypageDAO m_dao = new MypageDAO();
		
		String target_id = request.getParameter("target_id");
		if(session.getAttribute("session_id") == null) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('로그인 후 이용해주세요.');history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		String id = (String) session.getAttribute("session_id");
		String state = request.getParameter("state");
		
		int userNum = u_dao.getimgnum(id);
		int targetuserNum = u_dao.getimgnum(target_id);
		MemberBean user = m_dao.getMemberInfo(userNum);
		MemberBean targetuser = m_dao.getMemberInfo(targetuserNum);
		
		if(f_dao.checkFollow(userNum, targetuserNum)) {
			f_dao.deleteFollow(userNum, targetuserNum, user.getFollowingnum(), targetuser.getFollowernum());
		}else {
			f_dao.insertFollow(userNum, targetuserNum, user.getFollowingnum(), targetuser.getFollowernum());
		}
		
		forward.setRedirect(true);
		
		if (state.equals("er")) {
			forward.setPath(request.getContextPath() + "/mypage/MyPageFollower.my");
		}else if(state.equals("ing")) {
			forward.setPath(request.getContextPath() + "/mypage/MyPageFollowing.my");
		}else {
			forward.setPath(request.getContextPath() + "/mypage/MypageOpen.my?homepage_user=" + target_id);
		}
		return forward;
	}
}
