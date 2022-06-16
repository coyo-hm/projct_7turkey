package com.dohwaji.app.member;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;
import com.dohwaji.app.member.dao.MemberFilesDAO;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class MemberFindPwOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		MemberDAO m_dao = new MemberDAO();
		
		PrintWriter out = response.getWriter();
		
		ActionForward forward = new ActionForward();
		boolean check = false;
		String temp_pw = "";
		
		//랜검한 문자의 조합으로 임시 비밀번호 생성
		String temp = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random r = new Random();
		
		String id = request.getParameter("userid");
		String phone = request.getParameter("userphone");
		
		Integer idx = m_dao.getusernumforfindpw(id, phone);
		
		if(idx != null) {
			//입력한 정보에 맞는 사용자가 존재하면 들어와서 임시 비밀번호를 발급
			for (int i = 0; i < 8; i++) {
				temp_pw += temp.charAt(r.nextInt(temp.length()));
			}
			Map<String, Object> updatepw = m_dao.updatePW(temp_pw, idx);
			
			//외부 API(SMS전송 API)
			String api_key = "NCS6Q6TACQIG5PH8";
			String api_secret = "QSLPWUCTRIZM5V0KYNQV2RH2VVL47GII";
			Message coolsms = new Message(api_key, api_secret);

			HashMap<String, String> params = new HashMap<String, String>();
			params.put("to", phone); // 수신번호
			params.put("from", "01023624942"); // 발신번호
			params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
			params.put("text", "[테스트]\n임시 비밀번호 : "+ temp_pw +"\n노출될 수 있으니 반드시 비밀번호 변경을 해주세요."); // 문자내용
			params.put("app_version", "JAVA SDK v2.2");
			
			try {
				JSONObject obj = coolsms.send(params);
			} catch (CoolsmsException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getCode());
			}
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('아이디와 이메일이 바르지 않습니다. 다시 시도해주세요.');");
			out.println("</script>");
			out.close();
			return null;
		}
		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/blue/join/login.jsp");
		return forward;			
	}
		
}

	

