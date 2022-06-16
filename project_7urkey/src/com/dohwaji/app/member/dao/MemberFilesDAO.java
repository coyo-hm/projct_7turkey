package com.dohwaji.app.member.dao;

import java.util.Enumeration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;
import com.oreilly.servlet.MultipartRequest;

public class MemberFilesDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public MemberFilesDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	public boolean insertFiles(MultipartRequest multi, int usernum) {
		
		HashMap<String, Object> fileMap = new HashMap<>();
		Enumeration<String> files = multi.getFileNames();
		boolean check = true;
		
		fileMap.put("usernum", usernum);
		
		while(files.hasMoreElements()) {
			String data = files.nextElement();
			System.out.println(data);
			if(multi.getFilesystemName(data) == null) {continue;}
			fileMap.put("userfileimg", multi.getFilesystemName(data));
			if(sqlsession.insert("MemberFiles.insertFile", fileMap) != 1) {
				check = false;
				break;
			}
		}
		return check;
	}

	public String selectFiles(int num) {
		return sqlsession.selectOne("MemberFiles.loginimg", num);
	}
	
	public void deleteFiles(int user_num) {
		sqlsession.delete("MemberFiles.deleteImg", user_num);
	}
}