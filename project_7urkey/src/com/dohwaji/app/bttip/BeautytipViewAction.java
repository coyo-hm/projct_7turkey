package com.dohwaji.app.bttip;

import java.util.ArrayList;
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
import com.dohwaji.app.bttip.dao.BeautytipMultiTextBean;
import com.dohwaji.app.bttip.dao.BeautytipMultiTextDao;
import com.dohwaji.app.member.dao.MemberDAO;


public class BeautytipViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		BeautytipBean b_bean = new BeautytipBean();
		BeautytipDAO b_dao = new BeautytipDAO();
		BeautytipFileDao f_dao = new BeautytipFileDao();
		MemberDAO m_dao = new MemberDAO();
		BeautytipMultiFileDao bmf_dao = new BeautytipMultiFileDao();
		BeautytipMultiTextDao bmt_dao = new BeautytipMultiTextDao();
				
		int bttipnum = Integer.parseInt(request.getParameter("seq"));
		
		b_bean = b_dao.getBtTipDetail(bttipnum);
		
		List<BeautytipMultiFileBean> filesBeanList = bmf_dao.getMultiImgDetail(bttipnum);
		List<BeautytipMultiTextBean> textBeanList = bmt_dao.getMultiTextDetail(bttipnum);
		
		int num = filesBeanList.size();
		int num_2 = textBeanList.size();
		
		session.setAttribute("session_n", num);
		session.setAttribute("session_n2", num_2);
		
		String[] path_1 = new String[num];
		ArrayList<String> list_1 = new ArrayList<String>(); 

		for(int i=0; i<num; i++){
			path_1[i] = String.valueOf(filesBeanList.get(i));
		}
		for(int i=0; i<num; i++){
			list_1.add(path_1[i]);
		}
		session.setAttribute("file_path",list_1);
	
		String[] path_2 = new String[num_2];
		ArrayList<String> list_2 = new ArrayList<String>(); 

		for(int i=0; i<num_2; i++){
			path_2[i] = String.valueOf(textBeanList.get(i));
		}
		for(int i=0; i<num_2; i++){
			list_2.add(path_2[i]);
		}
		session.setAttribute("text_path",list_2);
		
		
		if(b_bean != null) {
			request.setAttribute("BeautytipBean", b_bean);
			if(filesBeanList != null || textBeanList != null ) {
				request.setAttribute("filesBeanList", filesBeanList);
				request.setAttribute("textBeanList", textBeanList);
			}
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/blue/bttip/makeup_view.jsp");
			return forward;
		}
		return null;
	}

}