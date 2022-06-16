package com.dohwaji.app.bttip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.bttip.dao.BeautytipBean;
import com.dohwaji.app.bttip.dao.BeautytipDAO;
import com.dohwaji.app.bttip.dao.BeautytipSaveBean;
import com.dohwaji.app.bttip.dao.BeautytipSearchBean;
import com.dohwaji.app.mypage.dao.MypageDAO;

public class BeautytipSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BeautytipDAO bdao = new BeautytipDAO();
		ActionForward forward = new ActionForward();

		HttpSession session = request.getSession();

		BeautytipSaveBean b_bean = new BeautytipSaveBean();
		MypageDAO m_dao = new MypageDAO();
		
		String userid = (String) session.getAttribute("session_id");
		List<Map<String, Object>> bttiplist = m_dao.mybttip(userid);

		String[] list = { "BTTIPGENDER", "BTTIPAGE", "BTTIPEYE", "BTTIPNOSE", "BTTIPFACESHAPE", "BTTIPLIP",
				"BTTIPFACETYPE", "BTTIPFACETONE", "BTTIPSEASON", "BTTIPTHEME" };

		String btlist = "";
		String btlist2 = "";
		String btlist3 = "";

		if (bttiplist.size() > 0) {
			for (int i = 0; i < list.length; i++) {
				if (bttiplist.get(0).get(list[i]) == null) {
					continue;
				}
				String temp2 = bttiplist.get(0).get(list[i]).toString();
				btlist += temp2 + "/";
			}
			btlist = btlist.substring(0, btlist.length() - 1);
		}

		if (bttiplist.size() > 1) {
			for (int i = 0; i < list.length; i++) {
				if (bttiplist.get(1).get(list[i]) == null) {
					continue;
				}
				String temp2 = bttiplist.get(1).get(list[i]).toString();
				btlist2 += temp2 + "/";
			}
			btlist2 = btlist2.substring(0, btlist2.length() - 1);
		}

		if (bttiplist.size() > 2) {
			for (int i = 0; i < list.length; i++) {
				if (bttiplist.get(2).get(list[i]) == null) {
					continue;
				}
				String temp2 = bttiplist.get(2).get(list[i]).toString();
				btlist3 += temp2 + "/";
			}
			btlist3 = btlist3.substring(0, btlist3.length() - 1);
		}

		if (bttiplist != null) {
			request.setAttribute("btlist", btlist);
			request.setAttribute("btlist2", btlist2);
			request.setAttribute("btlist3", btlist3);
		}

//		---------------------------------------------------------------------------------------------
		
		ArrayList<List<BeautytipBean>> result = new ArrayList<>();
		String[] titles = { "gender", "age", "eye", "nose", "lip", "face", "type", "tone", "season", "theme" };
		HashMap<String, BeautytipSearchBean> datas = new HashMap<>();
		for (int i = 0; i < titles.length; i++) {
			BeautytipSearchBean bean = new BeautytipSearchBean();
			String[] values = request.getParameterValues(titles[i]);
			if (values == null || values.length == 0)
				continue;
			bean.setColumn("bttip" + titles[i]);
			bean.setValues(values);
			result.add(bdao.bttipSearch(bean));

		}
		List<BeautytipBean> temp = result.get(0);
		for (int i = 1; i < result.size(); i++) {
			temp.retainAll(result.get(i));
		}
		System.out.println(temp.size());
		session.setAttribute("result", temp);
		request.setAttribute("result", temp);
		forward.setRedirect(false);
		forward.setPath("/blue/bttip/bttip_index.jsp?search=true");
		return forward;
	}

}
