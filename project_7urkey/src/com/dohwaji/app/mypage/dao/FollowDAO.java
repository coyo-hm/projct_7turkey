package com.dohwaji.app.mypage.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;

public class FollowDAO {

	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public FollowDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	public int getFollowerNum(int userNum) {
		int result = 0;
		result = sqlsession.selectOne("Mypage.followernum", userNum);		
		return result;
	}
	public int getFollowingNum(int userNum) {
		int result = 0;
		result = sqlsession.selectOne("Mypage.followingnum", userNum);		
		return result;
	}
	public List<Integer> getFollowerList(int userNum){
		List<Integer> resultList = sqlsession.selectList("Mypage.getfollowerlist", userNum);
		return resultList;
	}
	public List<Integer> getFollowingList(int userNum){
		List<Integer> resultList = sqlsession.selectList("Mypage.getfollowinglist", userNum);
		return resultList;
	}
	
	/**
	 * following 여부 확인 
	 * @param userNum
	 * @param targetuserNum
	 * @return follow할 경우 true
	 */
	public boolean checkFollow(int userNum, int targetuserNum) {
		boolean result = false;
		HashMap<String, Integer> idMap = new HashMap<>();
		idMap.put("userNum", userNum);
		idMap.put("targetuserNum", targetuserNum);
		if((Integer)sqlsession.selectOne("Mypage.checkFollow", idMap) != 0) {
			result = true;
		}
		return result;
	}
	
	public boolean deleteFollow(int userNum, int targetuserNum, int userFollowing, int targetFollower) {
		boolean result = false;
		HashMap<String, Integer> idMap = new HashMap<>();
		idMap.put("userNum", userNum);
		idMap.put("targetuserNum", targetuserNum);
		if(sqlsession.delete("Mypage.deleteFollow", idMap) != 0) {
			HashMap<String, Integer> target = new HashMap<>();
			target.put("userNum", targetuserNum);
			target.put("followerNum", targetFollower - 1);
			sqlsession.update("Mypage.updateFollowerNum",target);
			HashMap<String, Integer> user = new HashMap<>();
			user.put("userNum", userNum);
			user.put("followingNum", userFollowing - 1);
			sqlsession.update("Mypage.updateFollowingNum", user);
			return result;
		}
		return result;
	}
	
	public boolean insertFollow(int userNum, int targetuserNum, int userFollowing, int targetFollower) {
		boolean result = false;
		HashMap<String, Integer> idMap = new HashMap<>();
		idMap.put("userNum", userNum);
		idMap.put("targetuserNum", targetuserNum);
		if(sqlsession.insert("Mypage.insertFollow", idMap) != 0) {
			HashMap<String, Integer> target = new HashMap<>();
			target.put("userNum", targetuserNum);
			target.put("followerNum", targetFollower + 1);
			sqlsession.update("Mypage.updateFollowerNum",target);
			HashMap<String, Integer> user = new HashMap<>();
			user.put("userNum", userNum);
			user.put("followingNum", userFollowing + 1);
			sqlsession.update("Mypage.updateFollowingNum", user);
			return result;
		}
		return result;
	}
	
	/**
	 * 가장 팔로워 수가 많은 사람 5명 리스트 뽑기
	 * @return
	 */
	public List<Integer> TopArtist(){
		List<Integer> getId = sqlsession.selectList("Mypage.getTopFollower");
		return getId;
	}



}
