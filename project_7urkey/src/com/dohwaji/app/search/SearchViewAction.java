package com.dohwaji.app.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import javax.servlet.http.HttpSession;

public class SearchViewAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		
		int seq =  Integer.parseInt(request.getParameter("seq"));
		
		//HttpSession session = request.getSession();
		
		//session.setAttribute("session_btnum", session_btnum);
		
		request.setAttribute("seq", seq);
		
		
		ActionForward forward = new ActionForward();
		//forward로 
		forward.setRedirect(false);
		forward.setPath("/bttip/BeautytipView.bt");
		
		//forward.setPath(request.getContextPath() + "/board/BoardList.bo");
		return forward;
		
		
		
	}

}
