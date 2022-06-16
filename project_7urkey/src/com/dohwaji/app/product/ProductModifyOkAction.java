package com.dohwaji.app.product;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.product.dao.ProductBean;
import com.dohwaji.app.product.dao.ProductDAO;
import com.dohwaji.app.product.dao.ProductFilesBean;
import com.dohwaji.app.product.dao.ProductFilesDAO;
import com.dohwaji.config.ProjectConfig;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductModifyOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ProductDAO p_dao = new ProductDAO();
		ProductBean p_bean = new ProductBean();
		ProductFilesDAO f_dao = new ProductFilesDAO();
		ActionForward forward = null;

		String saveFolder = ProjectConfig.PRODUCT_UPLOAD_LOCATION;
		int fileSize = 5 * 1024 * 1024; // 5M
		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());

			
			System.out.println("productNum="+multi.getParameter("productNum"));
			String seq = multi.getParameter("productNum");
			int product_num = Integer.parseInt(seq);
			
			String product_title = multi.getParameter("productTitle");
			String product_brand = multi.getParameter("productBrand");
			String productImage = ProductUtil.getMultipartFileName(multi);
			int catechoryDivId2 = Integer.parseInt(multi.getParameter("category2"));
			long product_price = Integer.parseInt(multi.getParameter("productPrice"));
			String product_explanation = multi.getParameter("productExplanation");

			for(ProductFilesBean file : f_dao.getDetail(product_num)) {
				File f = new File(saveFolder + "\\" + file.getFileName());
				if(f.exists()) {f.delete();}
			}
			f_dao.deleteFiles(product_num);
			
			p_bean.setProductNum(product_num);
			p_bean.setProductTitle(product_title);
			p_bean.setProductBrand(product_brand);
			p_bean.setProductPrice(product_price);
			p_bean.setCatechoryDivId2(catechoryDivId2);
			p_bean.setProductExplanation(product_explanation);
			p_bean.setProductImage(productImage);
			
			
			p_dao.updateProduct(p_bean);

			f_dao.insertFiles(multi, product_num);
			
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/product/ProductList.pr");
			
		} catch (Exception e) {
			e.printStackTrace();
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('상품 수정실패. 다시시도해주세요');history.back();");
			out.println("</script>");
			out.close();
		}
		return forward;
		
	}

}
