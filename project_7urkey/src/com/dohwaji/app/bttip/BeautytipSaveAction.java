package com.dohwaji.app.bttip;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.bttip.dao.BeautytipDAO;
import com.dohwaji.app.bttip.dao.BeautytipSaveBean;

public class BeautytipSaveAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");

		response.setCharacterEncoding("UTF-8");
		BeautytipDAO b_dao = new BeautytipDAO();
		BeautytipSaveBean b_bean = new BeautytipSaveBean();

		ActionForward forward = new ActionForward();

		HttpSession session = request.getSession();

		boolean check = false;

		String userid = (String) session.getAttribute("session_id");

		int bttipcnt = b_dao.bttipCount(userid);

		List<String> btresult = null;
		List<String> btresult2 = null;
		List<String> btresult3 = null;

		if (bttipcnt == 3) { // 맞춤저장이 3개일 때
			forward.setPath(request.getContextPath() + "/blue/bttip/BeautyList.bt?bttipcnt=3");
		} else { // 3개가 아닐때
			b_bean.setUserID(userid);
			b_bean.setBttipGender(request.getParameter("gender"));
			b_bean.setBttipAge(request.getParameter("age"));
			b_bean.setBttipEye(request.getParameter("eye"));
			b_bean.setBttipNose(request.getParameter("nose"));
			b_bean.setBttipLip(request.getParameter("lip"));
			b_bean.setBttipFaceshape(request.getParameter("face"));
			b_bean.setBttipFacetype(request.getParameter("type"));
			b_bean.setBttipFacetone(request.getParameter("tone"));
			b_bean.setBttipSeason(request.getParameter("season"));
			b_bean.setBttipTheme(request.getParameter("theme"));

			check = b_dao.bttipsave(b_bean);
			forward.setPath(request.getContextPath() + "/blue/bttip/BeautyList.bt");
		}
		forward.setRedirect(true);
		return forward;
	}
}
