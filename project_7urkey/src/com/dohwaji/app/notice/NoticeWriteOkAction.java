package com.dohwaji.app.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.notice.dao.NoticeBean;
import com.dohwaji.app.notice.dao.NoticeDAO;
import com.dohwaji.app.notice.dao.NoticeFilesDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NoticeWriteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		NoticeBean bean = new NoticeBean();
		NoticeDAO n_dao = new NoticeDAO();
		NoticeFilesDAO f_dao = new NoticeFilesDAO();

		ActionForward forward = new ActionForward();

//		servlet.com/cos : 파일 업로드 라이브러리
//		requset.getServletContext().getRealPath("/") : 서버 경로
		String saveFolder = "C:\\JSP_01\\board_mvc2\\WebContent\\app\\upload";
		int fileSize = 5 * 1024 * 1024; // 5M
		boolean n_result = false;
		boolean f_result = false;

		String title = null;
		String contents = null;

		System.out.println(title);

		title = bean.getNotice_title();
		System.out.println(title);
		System.out.println(bean.getNotice_title());
		contents = bean.getNotice_contents();

		try {
			MultipartRequest multi = null;

			multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());

			bean.setNotice_title(multi.getParameter("notice_title"));
			bean.setNotice_contents(multi.getParameter("notice_contents"));
			bean.setUserid(multi.getParameter("userid"));
		
			System.out.println(" - bean.getUserid() = " + bean.getUserid());
			
			
			if(bean.getUserid() == "") {
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('게시글 등록 실패. 로그인을 해주세요');");
				out.println("</script>");
				out.close();
				return null;
			}
			
			
			n_result = n_dao.insertNotice(bean);
			System.out.println(n_dao.getNoticeSeq());
			f_result = f_dao.insertFiles(multi, n_dao.getNoticeSeq());

			// null , 공백 글쓰기 등록 수정중

			if (!n_result || !f_result) {
				System.out.println("들어옴3");
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('게시글 등록 실패. 다시 시도해주세요.');");
				out.println("</script>");
				out.close();
				return null;

				
//				  } else if ((title == null )|| (contents == null)) {
//				  System.out.println("들어옴333");
//				  response.setContentType("text/html;charset=UTF-8"); 
//				  out.println("<script>");
//				  out.println("alert('입력이 안 된 사항이 있습니다.');"); 
//				  out.println("</script>");
//				  out.close();
//				  
//				  return null;
				 
			}
			
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/notice/NoticeList.no");
			
			

			
			System.out.println("들어옴4");
			return forward;

		} catch (Exception e) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('게시글 수정 실패. 다시 시도해주세요.');history.back();");
			out.println("</script>");
			out.close();
			System.out.println(e);
			return null;
		}

		
	}
}
