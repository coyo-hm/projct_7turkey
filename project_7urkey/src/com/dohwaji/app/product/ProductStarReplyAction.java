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

public class ProductStarReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ProductReplyDAO pr_dao = new ProductReplyDAO();

		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();

		//

		String userid = (String) request.getSession().getAttribute("session_id");

		ProductDAO p_dao = new ProductDAO();

		ProductFilesDAO f_dao = new ProductFilesDAO();
		ProductBean p_bean = new ProductBean();
		ProductReplyBean pr_bean = new ProductReplyBean();

		System.out.println("1)) seq=" + request.getParameter("seq"));

		System.out.println("2)) currProductNum=" + request.getSession().getAttribute("currProductNum"));
		String seq = request.getParameter("seq");
		int currProductNum = (request.getSession().getAttribute("currProductNum") == null) ? 0
				: (int) request.getSession().getAttribute("currProductNum");
		int product_num = 0;

		if (seq == null) {
			product_num = currProductNum;
		} else {
			product_num = Integer.parseInt(seq);
		}

		p_bean = p_dao.getDetail(product_num);

		System.out.println("3)) product_num=" + product_num);
		System.out.println("4)) p_bean.getProductTitle=" + p_bean.getProductTitle());

		List<ProductFilesBean> filesBeanList = f_dao.getDetail(product_num);
		for (int i = 0; i < filesBeanList.size(); i++) {
			ProductFilesBean pfb = filesBeanList.get(i);
			System.out.println("5)) f_dao.getProductTitle=" + pfb.getFileName());
		}

		System.out.println("6)) pr_bean.getCommentNum() = " + pr_bean.getCommentNum());
		System.out.println("7)) ProductMypageAction / userid = " + userid);

		int productNum = Integer.parseInt(request.getParameter("seq"));

		System.out.println("8)) ProductMypageAction / productNum = " + productNum);

		List<ProductReplyBean> productReplyList = pr_dao.starReply(productNum);

		System.out.println("9)) ProductReviewLikeAction productReplyList =" + productReplyList);

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