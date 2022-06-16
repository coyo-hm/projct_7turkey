package com.dohwaji.app.blame;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.blame.dao.BlameBean;
import com.dohwaji.app.blame.dao.BlameDAO;

public class BlameEnrollmentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		request.setCharacterEncoding("UTF-8");
		BlameDAO b_dao = new BlameDAO();
		BlameBean blame = new BlameBean();
		
		ActionForward forward = new ActionForward();
		
		boolean check = false;
		
		
//		blame.setBlameNumId(Integer.parseInt(request.getParameter("blameNumId")));
//		blame.setAdminBlameId(Integer.parseInt(request.getParameter("adminBlameId")));
//		blame.setBlameTitle(request.getParameter("blameTitle"));
//		blame.setBlameExplanation(request.getParameter("blameExplanation"));
//		blame.setBbsNumId(Integer.parseInt(request.getParameter("bbsNumId")));
//		blame.setUserNumId(Integer.parseInt(request.getParameter("userNumId")));
//		blame.setTargetUserId(Integer.parseInt(request.getParameter("targetUserId")));
//		blame.setIsBlame(request.getParameter("isBlame"));
//		blame.setBlameDate(request.getParameter("blameDate"));
		
		
		
		blame.setBlameTitle(request.getParameter("blameTitle"));
		blame.setBlameExplanation(request.getParameter("blameExplanation"));
		
		check = b_dao.enrollment(blame);
		
		
		if(!check) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('게시글 등록 실패');");
			out.println("</script>");
			out.close();
		}
		
		forward.setRedirect(true);

		forward.setPath(request.getContextPath() + "/app/blame/blameForm.jsp");
		return forward;

	}

}
