package com.dohwaji.app.bttip;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.bttip.dao.BeautytipBean;
import com.dohwaji.app.bttip.dao.BeautytipDAO;
import com.dohwaji.app.bttip.dao.BeautytipFileDao;
import com.dohwaji.app.bttip.dao.BeautytipMultiFileBean;
import com.dohwaji.app.bttip.dao.BeautytipMultiFileDao;
import com.dohwaji.app.bttip.dao.BeautytipMultiTextBean;
import com.dohwaji.app.bttip.dao.BeautytipMultiTextDao;
import com.dohwaji.app.member.dao.MemberDAO;
import com.dohwaji.config.ProjectConfig;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class BeautytipWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		BeautytipBean b_bean = new BeautytipBean();
		BeautytipDAO b_dao = new BeautytipDAO();
		BeautytipFileDao f_dao = new BeautytipFileDao();
		MemberDAO m_dao = new MemberDAO();
		BeautytipMultiFileDao bmf_dao = new BeautytipMultiFileDao();
		BeautytipMultiTextDao bmt_dao = new BeautytipMultiTextDao();
		BeautytipMultiFileBean bmf_bean = new BeautytipMultiFileBean();
		BeautytipMultiTextBean bmt_bean = new BeautytipMultiTextBean();
		
		//TODO
		String saveFolder = ProjectConfig.BTTIP_UPLOAD_LOCATION;
		int fileSize = 5 * 1024 * 1024;	//5M

		boolean b_result = false;
		boolean f_result = false;
		
		boolean mc_result = false;
		boolean mi_result = false;
		
		MultipartRequest multi = null;

		String userid = (String) session.getAttribute("session_id");
		System.out.println(userid);
//		String userid = String.valueOf(session.getAttribute("session_id"));
		try {
			multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
			
			b_bean.setUserID(userid);
			b_bean.setBttipTitle(multi.getParameter("title"));
			b_bean.setBttipGender(multi.getParameter("gender"));
			b_bean.setBttipAge(multi.getParameter("age"));
			b_bean.setBttipEye(multi.getParameter("eye"));
			b_bean.setBttipNose(multi.getParameter("nose"));
			b_bean.setBttipLip(multi.getParameter("lip"));
			b_bean.setBttipFace(multi.getParameter("face"));
			b_bean.setBttipType(multi.getParameter("type"));
			b_bean.setBttipTone(multi.getParameter("tone"));
			b_bean.setBttipSeason(multi.getParameter("season"));
			b_bean.setBttipTheme(multi.getParameter("thema"));
			b_bean.setBttipContent(multi.getParameter("contents"));
			
			b_result =  b_dao.insertbeautytip(b_bean);
			f_result = f_dao.insertFiles(multi.getFilesystemName("fileName"), b_dao.getBeautytipSeq());
			
			int seq = b_dao.getBeautytipSeq();
			
			if(!b_result || !f_result) {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('게시글 등록 실패. 다시 시도해주세요.');");
				out.println("</script>");
				out.close();
				return null;
			}
			
			String[] text = multi.getParameterValues("bttext");
			for ( int i = 0 ; i < text.length ; i++ ) {
				String textFordb = text[i];
				bmt_bean.setBttipnum(b_dao.getBeautytipSeq());
				bmt_bean.setContents(textFordb);
				bmt_dao.insertMultiContents(bmt_bean);
				System.out.println(textFordb);
			}
			
			bmf_dao.insertMultiFiles(multi, b_dao.getBeautytipSeq());

			int bt_num = b_dao.getBeautytipSeq();
			session.setAttribute("session_btnum", bt_num);
			
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/bttip/BeautytipView.bt?seq="+seq);
			
			return forward;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("들어옴");
		return null;
	}

}
