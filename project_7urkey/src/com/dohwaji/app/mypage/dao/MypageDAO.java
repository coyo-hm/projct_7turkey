package com.dohwaji.app.mypage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.app.bttip.dao.BeautytipBean;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.product.dao.ProductReplyBean;
import com.dohwaji.config.SqlMapConfig;

public class MypageDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public MypageDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	public MemberBean getMemberInfo(int usernum){
		MemberBean memberInfo = (MemberBean) sqlsession.selectOne("Mypage.memberinfo", usernum);
		return memberInfo;
	}
	
	public boolean checkPw(int userNum, String pw) {
		boolean result = false;
		String real_pw = sqlsession.selectOne("Mypage.checkpw", userNum);
		if(pw.equals(real_pw)) {
			result = true;
		}
		return result;
	}
	
	public int getPostNum(int userNum, String userid) {
		int bttip = sqlsession.selectOne("Mypage.bttipnum", userid);
		int review = sqlsession.selectOne("Mypage.reviewnum", userid);
		
		int result = bttip + review;
		return result;
	}
	
	public boolean updateUser(MemberBean newInfo) {
		boolean result = false;
		if(sqlsession.update("Mypage.updateuser", newInfo) != 0) {
			result = true;
		}		
		return result;
	}
	public boolean delectUser(int userNum) {
		boolean result = false;
		if(sqlsession.delete("Mypage.signout", userNum) != 0) {
			result = true;
		}
		return result;
	}
	public List<BeautytipBean> getBttipList(String userid){
		List<BeautytipBean> resultList = sqlsession.selectList("Mypage.getbttipList", userid);
		return resultList;
	}
	public String getBttipImg(int bttipNum) {
		return sqlsession.selectOne("Mypage.getBttipImg", bttipNum);
	}
	public List<Integer> getreviewList(String userid){
		return sqlsession.selectList("Mypage.getreviewList", userid);
	}
	public String getreview(int commentNum) {
		return sqlsession.selectOne("Mypage.getreview", commentNum);
	}
	public int getProductNum(int commentNum) {
		return sqlsession.selectOne("Mypage.getProductNum", commentNum);
	}
	public String getProductName(int productNum) {
		return sqlsession.selectOne("Mypage.getProductName", productNum);
	}
	public String getProductImg(int productNum) {
		return sqlsession.selectOne("Mypage.getProductImg", productNum);
	}

	
	public List<Map<String, Object>> mybttip(String userid) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("userid", userid);
		List<Map<String, Object>>result = sqlsession.selectList("Mypage.mybttip", userid);
		return result;
	}
	
	public void deleteMybttip(int bttipsavenum) {
		sqlsession.delete("Mypage.deletebttip", bttipsavenum);
		
	}
	
	public List<Integer> getTopFollower(){
		return sqlsession.selectList("Mypage.getTopFollower");
	}
	
}
