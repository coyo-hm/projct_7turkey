package com.dohwaji.app.report;

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
import com.dohwaji.app.report.dao.ReportAllDAO;
import com.dohwaji.app.report.dao.ReportFilesBean;
import com.dohwaji.app.report.dao.ReportFilesDAO;
import com.dohwaji.config.ProjectConfig;

public class ReportDeleteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

//		신고
		ReportAllDAO r_dao = new ReportAllDAO();
//		ReportReplyDAO rr_dao = new ReportReplyDAO();
		ReportFilesDAO rf_dao = new ReportFilesDAO();


		// 나만의화장 법 , 제품리뷰 type
		int report_type = Integer.parseInt(request.getParameter("report_type"));
		
		int report_board = Integer.parseInt(request.getParameter("report_board"));
		// 신고
		int report_num = Integer.parseInt(request.getParameter("report_num"));

		ActionForward forward = new ActionForward();

		
//		신고 파일 삭제
		String saveFolder = "C:\\web4_1500_LJW\\workspace\\board_mvc2_3\\WebContent\\app\\upload";
		for (ReportFilesBean file : rf_dao.getDetail(report_num)) {
			File f = new File(saveFolder + "\\" + file.getReport_file_name());
			if (f.exists()) {
				f.delete();
			}
		}

		
		
		// 나만의화장법 = 1
		// 제품리뷰 = 2
		if (report_type == 1) {
			
			
			

		} else if (report_type == 2) {

			// 신고당한 게시글 번호
			int commentNum = report_board;
			
			System.out.println(" - ReportDeleteOkAction product_num = " + commentNum);
			
			ProductFilesDAO prf_dao = new ProductFilesDAO();
			ProductReplyDAO pr_dao = new ProductReplyDAO();
			ProductDAO p_dao = new ProductDAO();

			ProductBean p_bean = new ProductBean();

	
			pr_dao.deleteOneReply(commentNum);
			
	
			// 제품리뷰 = 2
		} else {

			System.out.println("다시 시도해주세요 [ report_type ] 설정 실패" + report_type);
		}

//	신고	
		rf_dao.deleteFiles(report_num);
		r_dao.deleteNotice(report_num);

		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/report/ReportList.rep");

		return forward;
		
		
	}

}
