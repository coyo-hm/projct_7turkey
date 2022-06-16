package com.dohwaji.app.product;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.product.dao.ProductReplyDAO;

public class ProductReplyDeleteOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		
		ProductReplyDAO r_dao = new ProductReplyDAO();
		ActionForward forward = new ActionForward();
		
		int product_num = Integer.parseInt(request.getParameter("seq"));
		int commentNum = Integer.parseInt(request.getParameter("commentNum"));
		
		r_dao.deleteOneReply(commentNum);
		
		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/product/ProductView.pr?seq="+product_num);
		
		return forward;
	}
}
