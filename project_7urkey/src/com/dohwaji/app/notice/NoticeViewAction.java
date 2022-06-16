package com.dohwaji.app.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.notice.dao.NoticeFilesBean;
import com.dohwaji.app.notice.dao.NoticeFilesDAO;
import com.dohwaji.app.notice.dao.NoticeBean;
import com.dohwaji.app.notice.dao.NoticeDAO;

public class NoticeViewAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		NoticeBean n_bean = new NoticeBean();
		NoticeDAO n_dao = new NoticeDAO();
		NoticeFilesDAO f_dao = new NoticeFilesDAO();
		
		
		int notice_num = Integer.parseInt(request.getParameter("seq"));
		
		
		n_dao.updateReadCount(notice_num);
		n_bean = n_dao.getDetail(notice_num);
		List<NoticeFilesBean> filesBeanList = f_dao.getDetail(notice_num);
		
		if(n_bean != null) {
			request.setAttribute("noticeBean", n_bean);
			if(filesBeanList != null) {
				request.setAttribute("filesBeanList", filesBeanList);
			}
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/blue/admin/noticeView.jsp");
			return forward;
		}
		
		
		
		
		return null;
	}

}
