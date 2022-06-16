package com.dohwaji.app.notice;

import java.io.File;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.notice.dao.NoticeDAO;
import com.dohwaji.app.notice.dao.NoticeFilesBean;
import com.dohwaji.app.notice.dao.NoticeFilesDAO;


public class NoticeDeleteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		NoticeDAO n_dao = new NoticeDAO();
//		NoticeReplyDAO r_dao = new NoticeReplyDAO();
		NoticeFilesDAO f_dao = new NoticeFilesDAO();
//		ReportBean reportBean = new ReportBean();

		
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();

		int notice_num = Integer.parseInt(request.getParameter("seq"));

		System.out.println("notice_num = " + notice_num);


		String saveFolder = "C:\\web4_1500_LJW\\workspace\\board_mvc2_3\\WebContent\\app\\upload";
		for (NoticeFilesBean file : f_dao.getDetail(notice_num)) {
			File f = new File(saveFolder + "\\" + file.getNotice_file_name());
			if (f.exists()) {
				f.delete();
			}
		}
		f_dao.deleteFiles(notice_num);
		// r_dao.deleteReply(notice_num);
		n_dao.deleteNotice(notice_num);
		


		
		
		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/report/ReportList.re");

		return forward;
	}

}
