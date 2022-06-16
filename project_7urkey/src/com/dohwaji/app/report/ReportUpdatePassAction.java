package com.dohwaji.app.report;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.report.dao.ReportAllDAO;
import com.dohwaji.app.report.dao.ReportFilesBean;
import com.dohwaji.app.report.dao.ReportFilesDAO;

public class ReportUpdatePassAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

//		신고
		ReportAllDAO r_dao = new ReportAllDAO();
		ReportFilesDAO rf_dao = new ReportFilesDAO();

		// 신고
		int report_num = Integer.parseInt(request.getParameter("report_num"));

		ActionForward forward = new ActionForward();


		rf_dao.deleteFiles(report_num);
		r_dao.deleteNotice(report_num);

		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/report/ReportList.rep");

		return forward;
	}
}