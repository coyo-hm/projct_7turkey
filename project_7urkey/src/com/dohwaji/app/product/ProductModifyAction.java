package com.dohwaji.app.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.product.dao.ProductBean;
import com.dohwaji.app.product.dao.ProductDAO;

public class ProductModifyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
			
		ActionForward forward = new ActionForward();
			HttpSession session = request.getSession();
			ProductDAO p_dao = new ProductDAO();
			ProductBean bean = new ProductBean();
			
			
			System.out.println("seq="+request.getParameter("seq"));
			System.out.println("currProductNum="+request.getSession().getAttribute("currProductNum"));
			String seq = request.getParameter("seq");
			int product_num = Integer.parseInt(seq);
			
			
			bean = p_dao.getDetail(product_num);
			request.setAttribute("productBean", bean);
			session.setAttribute("category1Id", bean.getCatechoryDivId());
			session.setAttribute("category2Id", bean.getCatechoryDivId2());

			System.out.println("ProductModifyAction.productBean="+bean);
			System.out.println("category1Id="+session.getAttribute("category1Id"));
			System.out.println("category2Id="+session.getAttribute("category2Id"));
			
			forward.setRedirect(false);
			forward.setPath("/blue/admin/prod_Modify.jsp");
			
			return forward;
				
	}

}
