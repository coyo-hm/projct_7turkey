package com.dohwaji.app.product;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.product.dao.ProductDAO;
import com.dohwaji.app.product.dao.ProductReplyBean;
import com.dohwaji.app.product.dao.ProductReplyDAO;

public class ProductReplyOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();

		boolean p_result = false;
		String userid = (String) request.getSession().getAttribute("session_id");
		try {
			int productNum = Integer.parseInt(request.getParameter("seq"));
			String commentWrite = request.getParameter("comment_write");
			//물어봐서 구현해야함.
			//int commentBlame = Integer.parseInt(request.getParameter("commentBlame"));
			int commentPoint = Integer.parseInt(request.getParameter("comment_point"));
			
			ProductReplyBean prb = new ProductReplyBean();
			prb.setProductNum(productNum);
			prb.setUserid(userid);
			prb.setCommentWrite(commentWrite);
			//prb.setCommentBlame(commentBlame);
			prb.setCommentPoint(commentPoint);
			System.out.println("ProductReplyBean="+prb);
			ProductReplyDAO p_dao = new ProductReplyDAO();
			
			p_result = p_dao.insertReply(prb);
			
			if(!p_result) {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('댓글 등록 실패. 다시 시도해주세요.')");
				out.println("</script>");
				out.close();
				return null;
			}
			forward.setRedirect(false);
			request.setAttribute("seq", productNum);
			forward.setPath("/product/ProductView.pr");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return forward;
		
	}

}
