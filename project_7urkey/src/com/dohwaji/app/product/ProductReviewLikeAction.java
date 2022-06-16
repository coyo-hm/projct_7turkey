package com.dohwaji.app.product;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;

import com.dohwaji.app.product.dao.ProductReplyDAO;

public class ProductReviewLikeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");


		ActionForward forward = new ActionForward();



		HttpSession session = request.getSession();

//		String userid = (String) session.getAttribute("userid");
		String userid = request.getParameter("ueseid");

		int commentNum = Integer.parseInt(request.getParameter("commentNum"));
	
		int productNum = Integer.parseInt(request.getParameter("seq"));
	

		// 테스트 [ session_id 로그인 안할경우 어드민으로 저장
		if (userid == null) {
			userid = "admin";
		
		} else {
			System.out.println("- ProductReviewLikeAction [ userid = " + userid);
		}

		// no와 id값을 map에 저장
		Map<String, Object> m = new HashMap<>();
		m.put("productNum", productNum);
		m.put("commentNum", request.getParameter("commentNum"));
		m.put("userid", request.getParameter("userid"));

		System.out.println("0. ProductReviewLikeAction productNum =" + productNum);
		System.out.println("1. ProductReviewLikeAction userid =" + userid);
		System.out.println("2. ProductReviewLikeAction commentNum =" + commentNum);

		ProductReplyDAO pr_dao = new ProductReplyDAO();
		// 동일 게시글에 대한 이전 추천 여부 검색
		int result = pr_dao.like_check(m);

		System.out.println("4. NoticeReviewLikeAction result =" + result);

		if (result == 0) { // 추천하지 않았다면 추천 추가

			pr_dao.like_update(m);

		} else { // 추천을 하였다면 추천 삭제

			pr_dao.like_delete(m);
		}

//		forward.setRedirect(false);
//		forward.setPath("/blue/admin/product_detail.jsp");
//		return forward;

		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/product/ProductView.pr?seq=" + productNum);
		return forward;
	}
}
