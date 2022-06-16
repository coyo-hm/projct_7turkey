package com.dohwaji.app.bttip;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.bttip.dao.BeautytipBean;
import com.dohwaji.app.bttip.dao.BeautytipDAO;
import com.dohwaji.app.bttip.dao.BeautytipFileBean;
import com.dohwaji.app.bttip.dao.BeautytipFileDao;
import com.dohwaji.app.bttip.dao.BeautytipMultiFileBean;
import com.dohwaji.app.bttip.dao.BeautytipMultiFileDao;
import com.dohwaji.app.bttip.dao.BeautytipMultiTextBean;
import com.dohwaji.app.bttip.dao.BeautytipMultiTextDao;
import com.dohwaji.config.ProjectConfig;

public class BeautytipDeleteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		
		BeautytipBean tip_bean = new BeautytipBean();
		BeautytipFileBean file_bean = new BeautytipFileBean();
		BeautytipMultiTextBean multitext_bean = new BeautytipMultiTextBean();
		BeautytipMultiFileBean multifile_bean = new BeautytipMultiFileBean();
		
		BeautytipDAO bt_dao = new BeautytipDAO();
		BeautytipFileDao bf_dao = new BeautytipFileDao();
		BeautytipMultiTextDao bmt_dao = new BeautytipMultiTextDao();
		BeautytipMultiFileDao bmf_dao = new BeautytipMultiFileDao();
		
		int session_btnum = Integer.parseInt(request.getParameter("seq"));
		String saveFolder = ProjectConfig.BTTIP_UPLOAD_LOCATION;
		List<BeautytipMultiFileBean> multifile = bmf_dao.getMultiImgDetail(session_btnum);
		
		for(BeautytipMultiFileBean temp : multifile) {
			File f = new File(saveFolder + "\\" + temp.getFilename());
			if(f.exists()) {f.delete();}
		}
		
		File f = new File(saveFolder + "\\" + bf_dao.getBttipImg(session_btnum));
		if(f.exists()) {f.delete();}
		
		if(bmf_dao.deleteMultiFile(session_btnum) && bmt_dao.deleteMultiText(session_btnum) && bf_dao.deleteFile(session_btnum)) {
			bt_dao.deleteBttip(session_btnum);
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/blue/bttip/BeautyList.bt");
			return forward;
		}else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('게시물 삭제 실패. 다시 시도해주세요.'); history.back();");
			out.println("</script>");
			out.close();
			return null;
			
		}		
	}
}
