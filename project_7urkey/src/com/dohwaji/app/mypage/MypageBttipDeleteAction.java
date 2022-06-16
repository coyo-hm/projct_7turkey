package com.dohwaji.app.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.mypage.dao.MypageDAO;

public class MypageBttipDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MypageDAO m_dao = new MypageDAO();

		ActionForward forward = new ActionForward();

		String[] save = { "bttipsavenum1", "bttipsavenum2", "bttipsavenum3" };
		int bttipsavenum = 0;

		HttpSession session = request.getSession();

		String userid = (String) session.getAttribute("session_id");

		for (int i = 0; i < save.length; i++) {
			String savenum = request.getParameter(save[i]);
			if (savenum == null) {
				continue;
			}
			bttipsavenum = Integer.parseInt(savenum);
		}
		m_dao.deleteMybttip(bttipsavenum);

		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/mypage/MypageOpen.my?homepage_user=" + userid);

		return forward;
	}

}
