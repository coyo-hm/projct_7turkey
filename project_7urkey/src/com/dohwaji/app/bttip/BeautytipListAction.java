package com.dohwaji.app.bttip;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.bttip.dao.BeautytipDAO;
import com.dohwaji.app.bttip.dao.BeautytipSaveBean;
import com.dohwaji.app.mypage.dao.MypageDAO;

public class BeautytipListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();
		BeautytipDAO b_dao = new BeautytipDAO();

		HttpSession session = request.getSession();

		String temp = request.getParameter("page");
		int page = temp == null ? 1 : Integer.parseInt(temp);
		int pageSize = 5;
		int totalCnt = b_dao.getBttipCnt();

		int endRow = page * 5;
		int startRow = endRow - 4;

		int startPage = ((page - 1) / pageSize) * pageSize + 1;
		int endPage = startPage + 9;
		int totalPage = (totalCnt - 1) / pageSize + 1;

		endPage = endPage > totalPage ? totalPage : endPage;

		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("bttipList", b_dao.getBttipList(startRow, endRow));

		forward.setRedirect(false);

		

		// 맞춤저장
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

			forward.setRedirect(false);
			forward.setPath("/blue/bttip/bttip_index.jsp");
		}
		String userType = (String) session.getAttribute("admin");
		if (userType != null) {
			if (userType.equals("1")) {
				forward.setPath("/blue/bttip/bttip_index.jsp");
			} else {
				forward.setPath("/blue/bttip/bttip_index.jsp");
			}
		}else {
			forward.setPath("/blue/bttip/bttip_index.jsp");
		}
		return forward;
	}

}
