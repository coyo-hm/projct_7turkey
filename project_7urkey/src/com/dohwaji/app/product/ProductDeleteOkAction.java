package com.dohwaji.app.product;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.product.dao.ProductBean;
import com.dohwaji.app.product.dao.ProductDAO;
import com.dohwaji.app.product.dao.ProductFilesBean;
import com.dohwaji.app.product.dao.ProductFilesDAO;
import com.dohwaji.app.product.dao.ProductReplyDAO;
import com.dohwaji.config.ProjectConfig;

public class ProductDeleteOkAction implements Action{

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      request.setCharacterEncoding("UTF-8");
      
      ProductDAO p_dao = new ProductDAO();
      ProductReplyDAO r_dao = new ProductReplyDAO();
      ProductFilesDAO f_dao = new ProductFilesDAO();
      
      ActionForward forward = new ActionForward();
      ProductBean bean = new ProductBean();
      
      System.out.println("seq="+request.getParameter("seq"));
      String seq = request.getParameter("seq");
      int product_num = Integer.parseInt(seq);
      
      
      String saveFolder =  ProjectConfig.PRODUCT_UPLOAD_LOCATION;
      for(ProductFilesBean file : f_dao.getDetail(product_num)) {
         File f = new File(saveFolder + "\\" + file.getFileName());
         if(f.exists()) {f.delete();}
      }
      
      f_dao.deleteFiles(product_num);
      r_dao.deleteReply(product_num);
      p_dao.deleteProduct(product_num);
      
      bean = p_dao.getDetail(product_num);
      
      forward.setRedirect(true);
      forward.setPath(request.getContextPath() + "/product/ProductList.pr");
   
      return forward;
   }

}