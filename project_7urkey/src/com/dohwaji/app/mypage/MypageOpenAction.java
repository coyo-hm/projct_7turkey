package com.dohwaji.app.mypage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.bttip.dao.BeautytipBean;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;
import com.dohwaji.app.member.dao.MemberFilesDAO;
import com.dohwaji.app.mypage.dao.FollowDAO;
import com.dohwaji.app.mypage.dao.MyBttipBean;
import com.dohwaji.app.mypage.dao.MyReviewBean;
import com.dohwaji.app.mypage.dao.MypageBean;
import com.dohwaji.app.mypage.dao.MypageDAO;
import com.dohwaji.app.product.dao.ProductReplyBean;

public class MypageOpenAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();
		MypageDAO m_dao = new MypageDAO();
		FollowDAO f_dao = new FollowDAO();
		MemberDAO u_dao = new MemberDAO();
		MemberFilesDAO mf_dao = new MemberFilesDAO();

		HttpSession session = request.getSession();

		String homepage_user = request.getParameter("homepage_user");
		int usernum = u_dao.getimgnum(homepage_user);
		MemberBean temp = m_dao.getMemberInfo(usernum);
		MypageBean userInfo = new MypageBean();
		List<MyBttipBean> bttipList = new ArrayList<MyBttipBean>();
		List<MyReviewBean> reviewList = new ArrayList<MyReviewBean>();
		
		userInfo.setUsernum(usernum);
		userInfo.setUserid(homepage_user);
		userInfo.setUseremail(temp.getUseremail());
		userInfo.setUsername(temp.getUsername());
		userInfo.setUserfileimg(mf_dao.selectFiles(usernum));
		userInfo.setPostnum(m_dao.getPostNum(usernum, homepage_user));
		userInfo.setFollowernum(temp.getFollowernum());
		userInfo.setFollowingnum(temp.getFollowingnum());

		for(BeautytipBean i : m_dao.getBttipList(homepage_user)) {
			MyBttipBean btip  = new MyBttipBean();
			btip.setBttipNum(i.getBttipNum());
			btip.setBttipTitle(i.getBttipTitle());
			btip.setBttipDate(i.getBttipDate());
			btip.setFileName(m_dao.getBttipImg(i.getBttipNum()));
			bttipList.add(btip);
		}
		
		for(Integer i : m_dao.getreviewList(homepage_user)) {
			MyReviewBean review = new MyReviewBean();
			int p = m_dao.getProductNum(i);
			review.setProductNum(p);
			review.setProductName(m_dao.getProductName(p));
			review.setProductImg(m_dao.getProductImg(p));
			review.setReplyContents(m_dao.getreview(p));
			reviewList.add(review);
		}
		
		request.setAttribute("userInfo", userInfo);
		request.setAttribute("bttipList", bttipList);
		request.setAttribute("reviewList", reviewList);

		forward.setRedirect(false);

		if (session.getAttribute("session_id") != null) {

			String user = (String) session.getAttribute("session_id");

			if (user.equals(homepage_user)) {
				List<Map<String, Object>> mybttip = m_dao.mybttip(user);

				String[] list = { "BTTIPGENDER", "BTTIPAGE", "BTTIPEYE", "BTTIPNOSE", "BTTIPFACESHAPE", "BTTIPLIP",
						"BTTIPFACETYPE", "BTTIPFACETONE", "BTTIPSEASON", "BTTIPTHEME" };

				String btlist = "";
				String btlist2 = "";
				String btlist3 = "";

				String savenum = "BTTIPSAVENUM";
				String temp_num = "";
				String temp_num2 = "";
				String temp_num3 = "";

				if (mybttip.size() > 0) {
					for (int i = 0; i < list.length; i++) {

						if (mybttip.get(0).get(list[i]) == null) {
							continue;
						}
						String temp_1 = mybttip.get(0).get(list[i]).toString();
						btlist += temp_1 + "/";
					}
					btlist = btlist.substring(0, btlist.length() - 1);
					temp_num = mybttip.get(0).get(savenum).toString();
				}

				if (mybttip.size() > 1) {
					for (int i = 0; i < list.length; i++) {

						if (mybttip.get(1).get(list[i]) == null) {
							continue;
						}
						String temp_1 = mybttip.get(1).get(list[i]).toString();
						btlist2 += temp_1 + "/";
					}
					btlist2 = btlist2.substring(0, btlist2.length() - 1);
					temp_num2 = mybttip.get(1).get(savenum).toString();
				}

				if (mybttip.size() > 2) {
					for (int i = 0; i < list.length; i++) {
						if (mybttip.get(2).get(list[i]) == null) {
							continue;
						}
						String temp_1 = mybttip.get(2).get(list[i]).toString();
						btlist3 += temp_1 + "/";
					}
					btlist3 = btlist3.substring(0, btlist3.length() - 1);
					temp_num3 = mybttip.get(2).get(savenum).toString();
				}

				request.setAttribute("btlist", btlist);
				request.setAttribute("btlist2", btlist2);
				request.setAttribute("btlist3", btlist3);
				request.setAttribute("bttipsavenum1", temp_num);
				request.setAttribute("bttipsavenum2", temp_num2);
				request.setAttribute("bttipsavenum3", temp_num3);

				forward.setPath("/blue/mypage/mypage.jsp");
			} else {
				boolean f_state = f_dao.checkFollow(u_dao.getimgnum(user), usernum);
				request.setAttribute("f_state", f_state);
				forward.setPath("/blue/mypage/otherpage.jsp");
			}
			return forward;
		} else {
			request.setAttribute("f_state", "false");
			forward.setPath("/blue/mypage/otherpage.jsp");
			return forward;
		}
	}
}
