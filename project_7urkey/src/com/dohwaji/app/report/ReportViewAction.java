package com.dohwaji.app.report;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.report.dao.ReportAllBean;
import com.dohwaji.app.report.dao.ReportAllDAO;
import com.dohwaji.app.report.dao.ReportFilesBean;
import com.dohwaji.app.report.dao.ReportFilesDAO;

public class ReportViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		ReportAllBean r_bean = new ReportAllBean();
		ReportAllDAO r_dao = new ReportAllDAO();
		ReportFilesDAO f_dao = new ReportFilesDAO();

		int report_num = Integer.parseInt(request.getParameter("seq"));

		// r_dao.updateReadCount(report_num);
		r_bean = r_dao.getDetail(report_num);
		List<ReportFilesBean> filesBeanList = f_dao.getDetail(report_num);

		if (r_bean != null) {
			request.setAttribute("reportBean", r_bean);
			if (filesBeanList != null) {
				request.setAttribute("filesBeanList", filesBeanList);
			}

			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			// forward.setPath("/blue/admin/reportView.jsp");

			String userType = (String) session.getAttribute("admin");

			if (userType == null) {
				forward.setPath("/blue/admin/reportView.jsp");
				System.out.println("1");
			} else if (userType.equals("1")) {
				forward.setPath("/blue/admin/reportView.jsp");
				System.out.println("2");
			} else {
				forward.setPath("/blue/admin/reportView.jsp");
				System.out.println("3");
			}
			return forward;
		}

		return null;
	}
}
