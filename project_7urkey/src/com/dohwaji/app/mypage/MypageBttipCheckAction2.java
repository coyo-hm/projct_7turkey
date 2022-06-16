package com.dohwaji.app.mypage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.mypage.dao.MypageDAO;

public class MypageBttipCheckAction2 implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MypageDAO m_dao = new MypageDAO();

		HttpSession session = request.getSession();
		
		String userid = (String)session.getAttribute("session_id");
		
		List<Map<String, Object>> mybttip = m_dao.mybttip(userid);

		List<String> btcheck = new ArrayList<String>();
		List<String> btcheck2 = new ArrayList<String>();
		List<String> btcheck3 = new ArrayList<String>();

		ActionForward forward = new ActionForward();

		String[] list = { "BTTIPGENDER", "BTTIPAGE", "BTTIPEYE", "BTTIPNOSE", "BTTIPFACESHAPE", "BTTIPLIP",
				"BTTIPFACETYPE", "BTTIPFACETONE", "BTTIPSEASON", "BTTIPTHEME" };

		String btlist = "";
		String btlist2 = "";
		String btlist3 = "";

		if (mybttip.size() > 0) {
			for (int i = 0; i < list.length; i++) {
				if (mybttip.get(0).get(list[i]) == null) {
					continue;
				}
				String temp = mybttip.get(0).get(list[i]).toString();
				btcheck.add(temp);
				btlist += temp + "/";
			}
			btlist = btlist.substring(0, btlist.length() - 1);
		}

		if (mybttip.size() > 1) {
			for (int i = 0; i < list.length; i++) {
				if (mybttip.get(1).get(list[i]) == null) {
					continue;
				}
				String temp = mybttip.get(1).get(list[i]).toString();
				btcheck2.add(temp);
				btlist2 += temp + "/";
			}
			btlist2 = btlist2.substring(0, btlist2.length() - 1);
		}

		if (mybttip.size() > 2) {
			for (int i = 0; i < list.length; i++) {
				if (mybttip.get(2).get(list[i]) == null) {
					continue;
				}
				String temp = mybttip.get(2).get(list[i]).toString();
				btcheck3.add(temp);
				btlist3 += temp + "/";
			}
			btlist3 = btlist3.substring(0, btlist3.length() - 1);
		}

		String[] gender1 = { "남", "여" };
		String[] gender2 = { "m", "w" };
		String[] age1 = { "10", "20", "30", "40", "50" };
		String[] age2 = { "age1", "age2", "age3", "age4", "age5" };
		String[] eye1 = { "무쌍", "겉쌍", "속쌍", "올라간눈", "내려간눈" };
		String[] eye2 = { "eye1", "eye2", "eye3", "eye4", "eye5" };
		String[] nose1 = { "높은코", "낮은코", "복코", "메부리코" };
		String[] nose2 = { "nose1", "nose2", "nose3", "nose4" };
		String[] lip1 = { "작은입술", "큰입술", "얇은입술", "두꺼운입술" };
		String[] lip2 = { "lip1", "lip2", "lip3", "lip4" };
		String[] face1 = { "계란형", "둥근형", "각진형", "긴형", "넓적형" };
		String[] face2 = { "face1", "face2", "face3", "face4", "face5" };
		String[] type1 = { "건성", "지성", "복합성", "트러블" };
		String[] type2 = { "type1", "type2", "type3", "type4" };
		String[] tone1 = { "어두운톤", "밝은톤", "핑크톤", "노란톤" };
		String[] tone2 = { "tone1", "tone2", "tone3", "tone4" };
		String[] season1 = { "봄", "여름", "가을", "겨울" };
		String[] season2 = { "season1", "season2", "season3", "season4" };
		String[] theme1 = { "데일리", "하객", "페스티벌", "인물커버", "새내기" };
		String[] theme2 = { "theme1", "theme2", "theme3", "theme4", "theme5" };

		List<String> bttemp = new ArrayList<>();
		List<String> bttemp2 = new ArrayList<>();
		List<String> bttemp3 = new ArrayList<>();

		for (int i = 0; i < btcheck.size(); i++) {
			bttemp.add(btcheck.get(i));
		}

		for (int i = 0; i < btcheck2.size(); i++) {
			bttemp2.add(btcheck2.get(i));
		}

		for (int i = 0; i < btcheck3.size(); i++) {
			bttemp3.add(btcheck3.get(i));
		}

		HashMap<String, String> map = new HashMap<>();

		for (int i = 0; i < gender1.length; i++) {
			map.put(gender1[i], gender2[i]);
		}

		for (int i = 0; i < age1.length; i++) {
			map.put(age1[i], age2[i]);
		}

		for (int i = 0; i < eye1.length; i++) {
			map.put(eye1[i], eye2[i]);
		}

		for (int i = 0; i < nose1.length; i++) {
			map.put(nose1[i], nose2[i]);
		}

		for (int i = 0; i < lip1.length; i++) {
			map.put(lip1[i], lip2[i]);
		}

		for (int i = 0; i < face1.length; i++) {
			map.put(face1[i], face2[i]);
		}

		for (int i = 0; i < type1.length; i++) {
			map.put(type1[i], type2[i]);
		}

		for (int i = 0; i < tone1.length; i++) {
			map.put(tone1[i], tone2[i]);
		}

		for (int i = 0; i < season1.length; i++) {
			map.put(season1[i], season2[i]);
		}

		for (int i = 0; i < theme1.length; i++) {
			map.put(theme1[i], theme2[i]);
		}

		List<String> btresult = null;
		List<String> btresult2 = new ArrayList<>();
		List<String> btresult3 = null;

		for (int i = 0; i < btcheck2.size(); i++) {
			btresult2.add(map.get(bttemp2.get(i)));
		}

		if (mybttip != null) {
			request.setAttribute("btlist", btlist);
			request.setAttribute("btlist2", btlist2);
			request.setAttribute("btlist3", btlist3);

			request.setAttribute("btcheck", btcheck);
			request.setAttribute("btcheck2", btcheck2);
			request.setAttribute("btcheck3", btcheck3);

			request.setAttribute("btresult", btresult);
			request.setAttribute("btresult2", btresult2);
			request.setAttribute("btresult3", btresult3);

			forward.setRedirect(false);
			forward.setPath("/blue/bttip/BeautyList.bt");
		}
		return forward;

	}
}
