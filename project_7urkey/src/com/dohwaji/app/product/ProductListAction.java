package com.dohwaji.app.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.product.dao.ProductDAO;
import com.dohwaji.config.ProjectConfig;

public class ProductListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		ProductDAO p_dao = new ProductDAO();
		
		HttpSession session = request.getSession();
		String temp = request.getParameter("page");
		int category1Id = (null == request.getParameter("category1Id"))?0:Integer.parseInt(request.getParameter("category1Id"));
		int category2Id = (null == request.getParameter("category2Id"))?0:Integer.parseInt(request.getParameter("category2Id"));
		int list_order  = (null == request.getParameter("list_order"))?1:Integer.parseInt(request.getParameter("list_order"));
			
		int page = temp == null ? 1 : Integer.parseInt(temp);
		int pageSize = 10;
		int totalCnt = p_dao.getProductCnt();

		System.out.println("ProductListAction totalCnt="+totalCnt);
		
		int endRow = page * 10;
		int startRow = endRow - 9;
		
		int startPage = ((page - 1) / pageSize) * pageSize + 1;
		int endPage = startPage + 9;
		int totalPage = (totalCnt - 1) / pageSize + 1;
		
		endPage = endPage > totalPage ? totalPage : endPage;

		System.out.println("ProductListAction startRow="+startRow);
		System.out.println("ProductListAction endRow="+endRow);
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("nowPage", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("productList", p_dao.getProductList(startRow, endRow, category1Id, category2Id, list_order));

		request.setAttribute("PRODUCT_UPLOAD_LOCATION", ProjectConfig.PRODUCT_UPLOAD_LOCATION);


		session.setAttribute("category1Id", category1Id);
		session.setAttribute("category2Id", category2Id);
		session.setAttribute("list_order" , list_order);
		
		//아직 할게 남았으면 false 다 끝났으면 true
		forward.setRedirect(false);
		
		forward.setPath("/blue/admin/product_list.jsp"); //목적지
		
		return forward;
	}

}
