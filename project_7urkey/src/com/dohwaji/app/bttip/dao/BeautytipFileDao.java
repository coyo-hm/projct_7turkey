package com.dohwaji.app.bttip.dao;

import java.util.Enumeration;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;
import com.oreilly.servlet.MultipartRequest;

public class BeautytipFileDao {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public BeautytipFileDao() {
		sqlsession = sessionf.openSession(true);
	}
	
	public boolean insertFiles(String multi, int bttipNum) {
		
		HashMap<String, Object> fileMap = new HashMap<>();
//		Enumeration<String> files = multi.getFileNames();
		boolean check = true;
		fileMap.put("bttipNum", bttipNum);
		fileMap.put("fileName", multi);
		if(sqlsession.insert("BeautytipFiles.insertBeautytipFile", fileMap) != 1) {
			check = false;
		}
		return check;
	}
	
	public String getBttipImg(int bttipNum) {
		return sqlsession.selectOne("BeautytipFiles.getBttipImg", bttipNum);
	}
	
	public boolean deleteFile(int bttipnum) {
		boolean result = false;
		if(sqlsession.delete("BeautytipFiles.deleteFile", bttipnum) != 0) {
			result = true;
		}
		return result;
	}
}





















