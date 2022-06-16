package com.dohwaji.app.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.product.dao.ProductReplyDAO;

public class ProductReplyModifyOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ProductReplyDAO r_dao = new ProductReplyDAO();
		ActionForward forward = new ActionForward();
		
		int reply_num = Integer.parseInt(request.getParameter("reply_num"));
		int product_num = Integer.parseInt(request.getParameter("seq"));
		String reply_contents = request.getParameter("replys" + request.getParameter("num"));
		
		r_dao.updateReply(reply_num, reply_contents);
		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/product/ProductView.pr?seq="+product_num);
		
		return forward;
	}

}
