package com.dohwaji.app.product;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;
import com.dohwaji.app.member.dao.MemberFilesBean;
import com.dohwaji.app.member.dao.MemberFilesDAO;
import com.dohwaji.app.mypage.dao.MypageBean;
import com.dohwaji.app.mypage.dao.MypageDAO;
import com.dohwaji.app.product.dao.ProductBean;
import com.dohwaji.app.product.dao.ProductDAO;
import com.dohwaji.app.product.dao.ProductFilesBean;
import com.dohwaji.app.product.dao.ProductFilesDAO;
import com.dohwaji.app.product.dao.ProductReplyBean;
import com.dohwaji.app.product.dao.ProductReplyDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		String userid = (String) request.getSession().getAttribute("session_id");

		ProductDAO p_dao = new ProductDAO();
		ProductReplyDAO pr_dao = new ProductReplyDAO();
		ProductFilesDAO f_dao = new ProductFilesDAO();
		ProductBean p_bean = new ProductBean();
		ProductReplyBean pr_bean = new ProductReplyBean();
		
		
		
//		// 리뷰 사용자 이미지 추가 작업중
//		MemberBean m_bean = new MemberBean();
//		MemberDAO m_dao = new MemberDAO();
//		MemberFilesBean mf_bean = new MemberFilesBean();
//		MemberFilesDAO mf_dao = new MemberFilesDAO();
//		MypageDAO my_dao = new MypageDAO();
//		MypageBean my_bean = new MypageBean();
//		String id = userid;
//		
//		if(!(id == "" && id == null)) {
//			
//			int usernum = m_dao.getimgnum(id);
//			my_bean.setUserfileimg(mf_dao.selectFiles(usernum));
//			
//			System.out.println("id = " + id);
//			
////			m_bean = my_dao.getMemberInfo(usernum);
//			
////			mf_dao.selectFiles(m_bean.getUsernum());
//			
//			request.setAttribute("my_bean", my_bean);
//		}
//		
//
//		// ↑ 사용자 이미지	↑↑↑↑↑↑↑↑↑↑

		
		
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

		p_bean = p_dao.getDetail(product_num);
		List<ProductReplyBean> productReplyList = pr_dao.getReply(product_num);

		System.out.println("product_num=" + product_num);
		System.out.println("p_bean.getProductTitle=" + p_bean.getProductTitle());

		List<ProductFilesBean> filesBeanList = f_dao.getDetail(product_num);
		for (int i = 0; i < filesBeanList.size(); i++) {
			ProductFilesBean pfb = filesBeanList.get(i);
			System.out.println("f_dao.getProductTitle=" + pfb.getFileName());
		}
		
		
//		List<ProductReplyBean> replyBeanList = pr_dao.getReply(product_num);

//		// 추천 테스트
//		int like_count = pr_dao.like_count(pr_bean.getCommentNum());
//		
//		request.setAttribute("like_count", like_count);
//		
//		System.out.println("like_count = " + like_count);
//		
//		
//		System.out.println("1. ProductViewAction [ like_count = " + like_count);

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
			ActionForward forward = new ActionForward();
			if(userid == "admin") {
				forward.setRedirect(false);
				forward.setPath("/blue/admin/product_detail_admin.jsp");
				return forward;
				
			}else {
				
				forward.setRedirect(false);
				forward.setPath("/blue/admin/product_detail.jsp");
				return forward;
			}
			
		}

		return null;
	}
}