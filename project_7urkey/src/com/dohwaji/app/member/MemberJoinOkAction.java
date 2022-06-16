package com.dohwaji.app.member;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;
import com.dohwaji.app.member.dao.MemberFilesDAO;
import com.dohwaji.config.ProjectConfig;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

	public class MemberJoinOkAction implements Action {

		@Override
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			MemberBean bean = new MemberBean();
			MemberDAO m_dao = new MemberDAO();
			MemberFilesDAO f_dao = new MemberFilesDAO();
			
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			
			ActionForward forward = new ActionForward();
			boolean check = false;

			//TODO
			String saveFolder = ProjectConfig.USER_UPLOAD_LOCATION;
			int fileSize = 5 * 1024 * 1024; 
			boolean n_result = false;
			boolean f_result = false;

			String userid = null;      
			String userpw = null;      
            String useremail = null;   
			String username = null; 
			String userphone = null; 
			String userck = null;
			
			userid = bean.getUserid();
			userpw = bean.getUserpw();
			useremail = bean.getUseremail();
			username = bean.getUsername();
			userphone = bean.getUserphone();
			userck = bean.getUserck();
			
			String phone_ck_num = "";
			String temp = "0123456789abcdefghijklnmopqrsvz";
			Random r = new Random();
			
			for (int i = 0; i < 8; i++) {
				phone_ck_num += temp.charAt(r.nextInt(temp.length()));
			}
			System.out.println(phone_ck_num);
			
			try {
				MultipartRequest multi = null;

				multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
				
				bean.setUserid(multi.getParameter("userid"));
				bean.setUserpw(multi.getParameter("userpw"));
				bean.setUseremail(multi.getParameter("useremail"));
				bean.setUsername(multi.getParameter("username"));
				bean.setUserphone(multi.getParameter("userphone"));
				bean.setUserck(phone_ck_num);
				
				n_result = m_dao.insertMember(bean);
				f_result = f_dao.insertFiles(multi, m_dao.getUserNum());
				
				session.setAttribute("userphone", bean.getUserphone());
				System.out.println("join : "+session.getAttribute("userphone"));
				//외부 API(SMS전송 API)
				String api_key = "NCS6Q6TACQIG5PH8";
				String api_secret = "QSLPWUCTRIZM5V0KYNQV2RH2VVL47GII";
				Message coolsms = new Message(api_key, api_secret);

				HashMap<String, String> params = new HashMap<String, String>();
				params.put("to", bean.getUserphone()); // 수신번호
				params.put("from", "01023624942"); // 발신번호
				params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
				params.put("text", "도화지 회원가입\n인증 번호 : "+ phone_ck_num +"\n도화지 회원 가입을 위한 인증코드 입니다."); // 문자내용
				params.put("app_version", "JAVA SDK v2.2");
				
				try {
					JSONObject obj = coolsms.send(params);
				} catch (CoolsmsException e) {
					System.out.println(e.getMessage());
					System.out.println(e.getCode());
				}
				
				if (!n_result || !f_result) {
					response.setContentType("text/html;charset=UTF-8");
					out.println("<script>");
					out.println("alert('회원 가입 실패. 다시 시도해주세요.');");
					out.println("</script>");
					out.close();
					return null;
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/blue/join/join_ck.jsp");
			return forward;
		}
}
