package com.dohwaji.app.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.product.dao.ProductBean;
import com.dohwaji.app.product.dao.ProductDAO;
import com.dohwaji.app.product.dao.ProductFilesBean;
import com.dohwaji.app.product.dao.ProductFilesDAO;
import com.dohwaji.app.product.dao.ProductReplyBean;
import com.dohwaji.app.product.dao.ProductReplyDAO;

public class ProductMypageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ProductReplyDAO pr_dao = new ProductReplyDAO();

		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();

		String userid = (String) request.getSession().getAttribute("session_id");

	

		ProductDAO p_dao = new ProductDAO();

		ProductFilesDAO f_dao = new ProductFilesDAO();
		ProductBean p_bean = new ProductBean();
		ProductReplyBean pr_bean = new ProductReplyBean();

		System.out.println("seq=" + request.getParameter("seq"));

		System.out.println("currProductNum=" + request.getSession().getAttribute("currProductNum"));
		String seq = request.getParameter("seq");
		int currProductNum = (request.getSession().getAttribute("currProductNum") == null) ? 0
				: (int) request.getSession().getAttribute("currProductNum");
		int product_num = 0;

		if (seq == null) {
			product_num = currProductNum;
		} else {
			product_num = Integer.parseInt(seq);
		}

//		p_dao.updateReadCount(product_num);
		p_bean = p_dao.getDetail(product_num);
//		List<ProductReplyBean> productReplyList = pr_dao.getReply(product_num);

		System.out.println("product_num=" + product_num);
		System.out.println("p_bean.getProductTitle=" + p_bean.getProductTitle());

		List<ProductFilesBean> filesBeanList = f_dao.getDetail(product_num);
		for (int i = 0; i < filesBeanList.size(); i++) {
			ProductFilesBean pfb = filesBeanList.get(i);
			System.out.println("f_dao.getProductTitle=" + pfb.getFileName());
		}
//		List<ProductReplyBean> replyBeanList = r_dao.getReply(product_num);

//		System.out.println("productReplyList = " + productReplyList);
		System.out.println("pr_bean.getCommentNum() = " + pr_bean.getCommentNum());

		// 추천 테스트
		int like_count = pr_dao.like_count(pr_bean.getCommentNum());

		request.setAttribute("like_count", like_count);

		System.out.println("like_count = " + like_count);

		System.out.println("1. ProductViewAction [ like_count = " + like_count);

		//

//		String userid = (String) session.getAttribute("userid");
//		userid = request.getParameter("ueseid");

		System.out.println(" - ProductMypageAction / userid = " + userid);

		int productNum = Integer.parseInt(request.getParameter("seq"));

		System.out.println(" - ProductMypageAction / productNum = " + productNum);

		List<ProductReplyBean> productReplyList = pr_dao.mypageReply(productNum, userid);

		System.out.println(" - ProductReviewLikeAction productReplyList =" + productReplyList);

		request.setAttribute("mypageReplyList", productReplyList);
		if (p_bean != null) {
			request.setAttribute("productBean", p_bean);
//			request.setAttribute("replyBeanList", replyBeanList);
			if (filesBeanList.size() > 0) {
				request.setAttribute("productFilesBeanList", filesBeanList);
			}
			if (productReplyList.size() > 0) {
				request.setAttribute("productReplyList", productReplyList);
			}

//			userid = "admin";
			System.out.println("userid = " + userid);

			if (userid == "admin") {
				forward.setRedirect(false);
				forward.setPath("/blue/admin/product_detail_admin.jsp");
				return forward;

			} else {

				forward.setRedirect(false);
				forward.setPath("/blue/admin/product_detail.jsp");
				return forward;
			}
		}

		return null;

	}

}