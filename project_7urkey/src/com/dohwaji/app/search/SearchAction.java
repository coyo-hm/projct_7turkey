package com.dohwaji.app.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.search.dao.SearchDao;


public class SearchAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		
		
		ActionForward forward = new ActionForward();
		
		//다오를 깨운다 
		SearchDao s_dao = new SearchDao();
		
		//넘어온 파라미터를 사용 
		String query  = request.getParameter("query");
		
		
		//다오 사용 
		request.setAttribute("searchList", s_dao.searchList(query));
		request.setAttribute("searchListOne", s_dao.searchListOne(query));
//		request.setAttribute("reviewSearch", s_dao.reviewSearch(query));
		
		
		System.out.println();
		
		
		
		
		//포워드로 보낼겁니다 
		forward.setRedirect(false);
		//forward.setPath(request.getContextPath() + "/blue/search/search_index.jsp");
		forward.setPath("/blue/search/search_index.jsp");
		
		
		
		return forward;
	}

}
