package com.dohwaji.app.bttip.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;

public class BeautytipDAO {
	
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public BeautytipDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	public boolean bttipsave(BeautytipSaveBean bean) {
		boolean check = false;
		if (sqlsession.insert("Beautytip.bttipsave", bean) == 1) {
			check = true;
		}
		return check;
	}
	
	public List<BeautytipBean> bttipSearch(BeautytipSearchBean bean) {
		List<BeautytipBean> result = sqlsession.selectList("Beautytip.selectByColumn",bean);
		
		return result;
	}
	
	public int getBttipCnt() {
		int result=sqlsession.selectOne("Beautytip.getBttipCnt");
		return result;
	}
	
	public List<BeautytipBean> getBttipList(int startRow, int endRow) {
		HashMap<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		List<BeautytipBean> boardList = sqlsession.selectList("Beautytip.listAll", pageMap);
		return boardList;
	}
	
	public int bttipCount(String userid) {
		return sqlsession.selectOne("Beautytip.bttipCnt",userid);
	}
	
	public boolean insertbeautytip(BeautytipBean bean) {
		boolean check = false;
		if(sqlsession.insert("Beautytip.bttipinsert", bean) == 1) {
			check = true;
		}
		return check;
	}
	
	public int getBeautytipSeq() {
		return sqlsession.selectOne("Beautytip.getSeq");
	}
	
	public BeautytipBean getBtTipDetail(int bttipnum) {
		return sqlsession.selectOne("Beautytip.getBtTipDetail", bttipnum);
	} 
	
	public int bttiplike(int bttipnum) {
		return sqlsession.update("Beautytip.bttiplike" , bttipnum);
	}
	
	public boolean deleteBttip(int bttipnum) {
		boolean result = false;
		if(sqlsession.delete("Beautytip.deleteBttip", bttipnum) != 0) {
			result = true;
		}
		return result;
	}
	
	
}
	
