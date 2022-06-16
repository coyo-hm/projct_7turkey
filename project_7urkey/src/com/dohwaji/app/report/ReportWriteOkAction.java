package com.dohwaji.app.report;

import java.io.PrintWriter;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.report.dao.ReportAllBean;
import com.dohwaji.app.report.dao.ReportAllDAO;
import com.dohwaji.app.report.dao.ReportFilesDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



public class ReportWriteOkAction implements Action {


	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userid = (String) request.getSession().getAttribute("session_id");
		
		ReportAllBean r_bean = new ReportAllBean();
		ReportAllDAO r_dao = new ReportAllDAO();
		ReportFilesDAO f_dao = new ReportFilesDAO();

		PrintWriter out = response.getWriter();

		System.out.println("들어옴1");
		ActionForward forward = new ActionForward();

//		servlet.com/cos : 파일 업로드 라이브러리
//		requset.getServletContext().getRealPath("/") : 서버 경로
		String saveFolder = "C:\\JSP_01\\test_dd\\WebContent\\blue\\imagesProduct";
		int fileSize = 5 * 1024 * 1024; // 5M

		boolean r_result = false;
		boolean f_result = false;
		userid = r_bean.getUserid();
		

		try {

			MultipartRequest multi = null;

			multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());

			r_bean.setReport_type(multi.getParameter("report_type"));

			r_bean.setReport_board(Integer.parseInt(multi.getParameter("report_board")));

			
			r_bean.setUserid(multi.getParameter("userid"));
			System.out.println("userid = "+userid);


			r_bean.setReport_title(multi.getParameter("report_title"));

			r_bean.setReport_contents(multi.getParameter("report_contents"));

			r_result = r_dao.insertReport(r_bean);
			f_result = f_dao.insertFiles(multi, r_dao.getReportSeq());

			
		

			if (!r_result || !f_result) {
				System.out.println("들어옴3");
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('게시글 수정 실패. 다시 시도해주세요.');history.back();");
				out.println("</script>");
				out.close();
				return null;
//
//			} else if (r_bean.getReport_type() == null || "" + r_bean.getReport_board() == null
//					|| r_bean.getUserid() == null || r_bean.getReport_title() == null
//					|| r_bean.getReport_contents() == null) {
//
//				System.out.println("들어옴333");
//				response.setContentType("text/html;charset=UTF-8");
//				out.println("<script>");
//				out.println("alert('게시글 수정 실패. 다시 시도해주세요.');history.back();");
//				out.println("</script>");
//				out.close();
//
//				return null;
			}

//			forward.setPath(request.getContextPath() + "/report/ReportList.rep");
//			forward.setRedirect(true);

			System.out.println("들어옴4");
			
			
			
			
			
			forward.setRedirect(false);
			forward.setPath("/index.jsp");
			
			
			return forward;

		} catch (Exception e) {
			System.out.println("ReportWriteOkAction : " + e);
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('게시글 수정 실패. 다시 시도해주세요.');history.back();");
			out.println("</script>");
			out.close();
		}
		return null;
	}
}
