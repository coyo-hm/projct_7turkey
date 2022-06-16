package com.dohwaji.app.product;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.product.dao.CodeBean;
import com.dohwaji.app.product.dao.ProductCatechoryDAO;
import com.google.gson.Gson;

public class ProductFrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Map<String, String> mapCod = Collections.synchronizedMap(new HashMap<String, String>());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		System.out.println("command="+command);
		ActionForward forward = null;
		Action action = null;

		if (command.equals("/product/ProductList.pr")) {

			action = new ProductListAction();

			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				// e.printStackTrace();
				e.printStackTrace(); // 디버그하기에는 stack trace 를 보는게 나음
			}

		} else if (command.equals("/product/ProductWrite.pr")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/blue/admin/prod_reg.jsp");

		} else if (command.equals("/product/ProductWriteOk.pr")) {

			action = new ProductWriteOkAction();

			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();

			}
			
		}else if(command.equals("/product/ProductReviewLike.pr")) {
			action = new ProductReviewLikeAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}	

		} else if (command.equals("/product/ProductView.pr")) {

			action = new ProductViewAction();

			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/product/ProductGetCat.pr")) { // 대분류 가져오기
			String cat1Json = mapCod.get("cat1Json");
			
			if(null == cat1Json) {
			ProductCatechoryDAO dao = new ProductCatechoryDAO();
			List<CodeBean> list = dao.getCat();
			req.setAttribute("listCategory", list);
			
				cat1Json = new Gson().toJson(list);
				mapCod.put("cat1Json", cat1Json);
			}else {
				System.out.println("Get cached cat1Json...");
			}

			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(cat1Json);

		} else if (command.equals("/product/ProductGetCat2.pr")) { // 소분류가져오기
			String category = req.getParameter("category");
			String cat2Json = mapCod.get(category+".cat2Json");
			
			if(null == cat2Json) {
			
				System.out.println("선택된 [" + category + "]의 소분류 항목을 가져옵니다");
			
			ProductCatechoryDAO dao = new ProductCatechoryDAO();
			List<CodeBean> list = dao.getCat2(category);
			req.setAttribute("listCategory", list);
			
				cat2Json = new Gson().toJson(list);
				mapCod.put(category+".cat2Json", cat2Json);
			}else {
				System.out.println("Get cached cat2Json..[" + category + "].");
			}

			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(cat2Json);

		} else if (command.equals("/product/product.pr")) {
			action = new FileDownloadAction();
			try {
				action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.contains("/product/ProductReplyOk.pr")) {
			String mode = req.getParameter("mode");
			//등록
			if(mode.equalsIgnoreCase("add")) {
				action = new ProductReplyOkAction();
				try { forward = action.execute(req, resp); } catch (Exception e) { e.printStackTrace(); }
			}
			
			
		}else if(command.equals("/product/ProductReplyDeleteOk.pr")) {
			action = new ProductReplyDeleteOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}else if (command.equals("/product/FileDownload.pr")) {
			action = new FileDownloadAction();
			try {
				action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}else if(command.equals("/product/ProductDeleteOk.pr")) {
			action = new ProductDeleteOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/product/ProductModify.pr")) {
			action = new ProductModifyAction();
			try {
				forward = action.execute(req, resp);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/product/ProductModifyOk.pr")) {
			action = new ProductModifyOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
			
	
		} else if (command.equals("/product/ProductMypage.pr")) {

			action = new ProductMypageAction();

			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} else if (command.equals("/product/ProductReplyViewLike.pr")) {
			
			action = new ProductReplyLikeAllAction();
			
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/product/ProductStarReply.pr")) {
			
			action = new ProductStarReplyAction();
			
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
		}else {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/blue/error/404.jsp");
		}

		// 일괄처리
		if (forward != null) {
			if (forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			} else {
				// forward를 함
				RequestDispatcher dispather = req.getRequestDispatcher(forward.getPath());
				dispather.forward(req, resp);
			}
		}
	}
}