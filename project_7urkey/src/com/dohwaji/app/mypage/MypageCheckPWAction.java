package com.dohwaji.app.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;
import com.dohwaji.app.member.dao.MemberFilesDAO;
import com.dohwaji.app.mypage.dao.MypageDAO;

public class MypageCheckPWAction implements Action{
   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      
      ActionForward forward = new ActionForward();
      HttpSession session = request.getSession();
      MypageDAO m_dao = new MypageDAO();
      MemberDAO u_dao = new MemberDAO();
      MemberFilesDAO mf_dao = new MemberFilesDAO();
      
      String id = (String)session.getAttribute("session_id");
      String pw = request.getParameter("pw");
      int userNum = u_dao.getimgnum(id);
      
      forward.setRedirect(false);
      
      if(m_dao.checkPw(userNum, pw)) {
         MemberBean userInfo = new MemberBean();
         userInfo = m_dao.getMemberInfo(userNum);
         request.setAttribute("userInfo", userInfo);
         forward.setPath("/blue/mypage/mypage_update.jsp");
      }else {
         
         forward.setPath("/mypage/MyPageEnterPW.my?check=false");
      }
      
      return forward;
   }
}