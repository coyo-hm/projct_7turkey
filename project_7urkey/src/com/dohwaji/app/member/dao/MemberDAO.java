package com.dohwaji.app.member.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;

public class MemberDAO {
	
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public MemberDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	public boolean insertMember(MemberBean bean) {
		boolean check = false;
		if(sqlsession.insert("Member.join", bean) == 1) {
			check = true;
		}
		return check;
	}

	public int getUserNum() {
		return sqlsession.selectOne("Member.getusernum");
	}

	public boolean checkId(String userid) {
		boolean check = false;
		if((Integer)sqlsession.selectOne("Member.checkid", userid) == 1) {
			check = true;
		}
		return check;
	}
	
	public Map<String, String> login(String id, String pw) {
		HashMap<String, String> datas = new HashMap<>();
		
		datas.put("id", id);
		datas.put("pw", pw);
		
		Map<String, String> loginDatas = sqlsession.selectOne("Member.login", datas);
		return loginDatas;
	}

	public int getimgnum(String id) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("Member.imgnum", id);
	}
	public Integer getusernumforfindpw(String id, String phone) {
		HashMap<String, String> datas = new HashMap<>();
		datas.put("id", id);
		datas.put("phone", phone);
		return sqlsession.selectOne("Member.getusernumForFindPw", datas);
	}
	
	public Map<String, Object> updatePW(String pw, int num) {
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("pw", pw);
		datas.put("num", num);
		Map<String, Object> updatepw = sqlsession.selectOne("Member.updatepw", datas);
		return updatepw;
	}
	
	public Map<String, Object> updatePhoneCkNum(String ck, int num) {
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("ck", ck);
		datas.put("num", num);
		Map<String, Object> updateck = sqlsession.selectOne("Member.updateck", datas);
		return updateck;
	}
	
	public boolean cknum(String ck_num, String phone) {
		Boolean result = false;
		String ckDatas = sqlsession.selectOne("Member.cknum", ck_num);
		if(phone.equals(ckDatas)) {
			result = true;
		}
		return result;
	}

	public String getFindId(String name, String phone) {
		HashMap<String, String> datas = new HashMap<>();
		datas.put("name", name);
		datas.put("phone", phone);
		return sqlsession.selectOne("Member.findid", datas);
		
	}
	
	public int updateck(String phone) {
		int updatecki = sqlsession.update("Member.updateckid", phone);
		return updatecki;
	}	
	
	public String ckForLogin(String id) {
		return sqlsession.selectOne("Member.ckForLogin", id);
	}
}














