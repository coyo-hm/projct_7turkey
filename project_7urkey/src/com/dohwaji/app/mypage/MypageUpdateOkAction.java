package com.dohwaji.app.mypage;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;
import com.dohwaji.app.member.dao.MemberFilesDAO;
import com.dohwaji.app.mypage.dao.MypageDAO;
import com.dohwaji.config.ProjectConfig;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MypageUpdateOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		MemberBean newInfo = new MemberBean();
		MypageDAO m_dao = new MypageDAO();
		MemberDAO u_dao = new MemberDAO();
		MemberFilesDAO f_dao = new MemberFilesDAO();
		
		//TODO
		String saveFolder = ProjectConfig.USER_UPLOAD_LOCATION;
		int fileSize = 5 * 1024 * 1024;
		boolean f_result = false;
		
		try {
			MultipartRequest multi = null;
			
			multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
			
			String userId = (String)session.getAttribute("session_id");
			int userNum = u_dao.getimgnum(userId);
			MemberBean oldInfo = m_dao.getMemberInfo(userNum);
			
			
			newInfo.setUsernum(userNum);
			newInfo.setUserid(userId);
			newInfo.setUserphone(multi.getParameter("phone").isEmpty() ? oldInfo.getUseremail() : multi.getParameter("phone"));
			newInfo.setUseremail(multi.getParameter("e_mail").isEmpty() ? oldInfo.getUseremail() : multi.getParameter("e_mail"));
			newInfo.setUserpw(multi.getParameter("pw").isEmpty() ? oldInfo.getUserpw() : multi.getParameter("pw"));
			newInfo.setUsername(multi.getParameter("username").isEmpty() ? oldInfo.getUsername() : multi.getParameter("username"));
			
			File f = new File(saveFolder + "\\" + f_dao.selectFiles(userNum));
			
			if(multi.getFilesystemName("profileimg") != null) {
				if(f.exists()) {
					f.delete();
					f_dao.deleteFiles(userNum);
				}
				f_result = f_dao.insertFiles(multi, userNum);
			}else {
				f_result = true;
			}
			
			if(!m_dao.updateUser(newInfo) || !f_result) {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('회원 정보 수정 실패. 다시 시도해주세요');history.back();");
				out.println("</script>");
				out.close();
				return null;
			}
				PrintWriter out = response.getWriter();
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('회원 정보 수정 완료');");
				out.println("</script>");
				forward.setRedirect(true);
				forward.setPath(request.getContextPath() + "/mypage/MypageOpen.my?homepage_user=" + (String)session.getAttribute("session_id"));
				return forward;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
