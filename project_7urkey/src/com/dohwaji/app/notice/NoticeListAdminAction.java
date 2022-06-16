package com.dohwaji.app.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.notice.dao.NoticeDAO;

public class NoticeListAdminAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		NoticeDAO n_dao = new NoticeDAO();
		
		HttpSession session = request.getSession();
		
		String temp = request.getParameter("page");
		int page = temp == null ? 1 : Integer.parseInt(temp);
		int pageSize = 10;
		int totalCnt = n_dao.getNoticeCnt();
		
		int endRow = page * 10;
		int startRow = endRow - 9;
		
		int startPage = ((page - 1) / pageSize) * pageSize + 1;
		int endPage = startPage + 9;
		int totalPage = (totalCnt - 1) / pageSize + 1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("noticeList", n_dao.getNoticeList(startRow, endRow));
		
		forward.setRedirect(false);
		
		String userType = (String)session.getAttribute("admin");
		
		
		
		
		if(userType == null) {
			forward.setPath("/blue/admin/noticeListAdmin.jsp");
		}else if(userType.equals("1")) {
			forward.setPath("/blue/admin/noticeListAdmin.jsp");
		}else {
			forward.setPath("/blue/admin/noticeListAdmin.jsp");
		}
		return forward;
	}
}










