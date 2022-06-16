package com.dohwaji.app.notice.dao;

import java.util.Enumeration;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;
import com.oreilly.servlet.MultipartRequest;

public class NoticeFilesDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public NoticeFilesDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	public boolean insertFiles(MultipartRequest multi, int notice_num) {
		HashMap<String, Object> fileMap = new HashMap<>();
		Enumeration<String> files = multi.getFileNames();
		System.out.println(files);
		boolean check = true;
		
		fileMap.put("notice_num", notice_num);
		
		while(files.hasMoreElements()) {
			String data = files.nextElement();
			System.out.println("1");
			System.out.println(data);
			if(multi.getFilesystemName(data) == null) {continue;}
			fileMap.put("notice_file_name", multi.getFilesystemName(data));
			if(sqlsession.insert("NoticeFiles.insertFile", fileMap) != 1) {
				check = false;
				break;
			}
		}
		return check;
	}
	
	public List<NoticeFilesBean> getDetail(int notice_num) {
		List<NoticeFilesBean> filesBeanList =  sqlsession.selectList("NoticeFiles.getDetail", notice_num);
		System.out.println("2");
		return filesBeanList;
	}
	
	
	// 삭제
	public void deleteFiles(int notice_num) {
		sqlsession.delete("NoticeFiles.deleteFiles", notice_num);
	}
	
	
}










