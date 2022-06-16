package com.dohwaji.app.bttip;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.bttip.dao.BeautytipBean;
import com.dohwaji.app.bttip.dao.BeautytipDAO;
import com.dohwaji.app.bttip.dao.BeautytipFileDao;
import com.dohwaji.app.bttip.dao.BeautytipMultiFileBean;
import com.dohwaji.app.bttip.dao.BeautytipMultiFileDao;
import com.dohwaji.app.member.dao.MemberDAO;

public class BttiplikeAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		//추가
		response.setCharacterEncoding("UTF-8");
		
		BeautytipDAO b_dao = new BeautytipDAO();
		
		//시퀀스 받아서 여기 넣어준 다음에 뷰액션으로 다시보냄 
		int session_btnum = Integer.parseInt(request.getParameter("seq"));
		
		
		
		//다오 실행 
		b_dao.bttiplike(session_btnum);
		session.setAttribute("session_btnum", session_btnum);
			
		ActionForward forward = new ActionForward();
			//포워드로 넘어감 
		forward.setRedirect(false);
		forward.setPath("/bttip/BeautytipView.bt");
		return forward;
		
	
	}
	}
