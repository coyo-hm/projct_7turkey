package com.dohwaji.app.product;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.product.dao.ProductBean;
import com.dohwaji.app.product.dao.ProductDAO;
import com.dohwaji.app.product.dao.ProductFilesDAO;
import com.dohwaji.config.ProjectConfig;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductWriteOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ProductBean bean = new ProductBean();
		ProductDAO p_dao = new ProductDAO();
		ProductFilesDAO f_dao = new ProductFilesDAO();
		
		ActionForward forward = new ActionForward();
		
//		servlet.com/cos : 파일 업로드 라이브러리
//		requset.getServletContext().getRealPath("/") : 서버 경로
		String saveFolder = ProjectConfig.PRODUCT_UPLOAD_LOCATION;
		
		int fileSize = 5 * 1024 * 1024;	//5M
		boolean p_result = false;
		boolean f_result = false;
		
		try {
			MultipartRequest multi = null;
			
			multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
			bean.setCatechoryDivId2(Integer.parseInt(multi.getParameter("category2")));
			bean.setProductTitle(multi.getParameter("productTitle"));
			bean.setProductBrand(multi.getParameter("productBrand"));
			bean.setProductPrice(Long.parseLong(multi.getParameter("productPrice")));
			bean.setProductExplanation(multi.getParameter("productExplanation"));
			//bean.setProductImage(multi.getFileNames().nextElement().toString());

			String productImage = ProductUtil.getMultipartFileName(multi);
			System.out.println("productImage="+productImage);
			
			bean.setProductImage(productImage);
			
			
			p_result = p_dao.insertProduct(bean);
			int productNum = p_dao.getProductSeq();
			f_result = f_dao.insertFiles(multi, productNum);
		
			if(!p_result || !f_result) {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('게시글 등록 실패. 다시 시도해주세요.')");
				out.println("</script>");
				out.close();
				return null;
			}
			forward.setRedirect(true);
			//forward.setPath(request.getContextPath() + "/product/ProductList.pr");
			//상세페이지로
//			ProductConst.currProductNum = productNum;
			request.setAttribute("seq", productNum);

			request.getSession().setAttribute("currProductNum", productNum);
			forward.setPath(request.getContextPath()+"/product/ProductView.pr");
			
			return forward;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
