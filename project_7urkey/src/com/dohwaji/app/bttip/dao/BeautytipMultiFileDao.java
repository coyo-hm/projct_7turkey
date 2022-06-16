package com.dohwaji.app.bttip.dao;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;
import com.oreilly.servlet.MultipartRequest;

public class BeautytipMultiFileDao {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public BeautytipMultiFileDao() {
		sqlsession = sessionf.openSession(true);
	}

	public boolean insertMultiFiles(MultipartRequest multi, int bttipNum) {
		
		HashMap<String, Object> fileMap = new HashMap<>();
		Enumeration<String> files = multi.getFileNames();
		boolean check = true;
		
		fileMap.put("bttipnum", bttipNum);
		
		while(files.hasMoreElements()) {
			String data = files.nextElement();
			if(multi.getFilesystemName(data) == null) {continue;}
			fileMap.put("filename", multi.getFilesystemName(data));
			if(sqlsession.insert("BeautytipMultiFile.insertBTMultiFile", fileMap) != 1) {
				check = false;
				break;
			}
		}
		return check;
	}
	
	public List<BeautytipMultiFileBean> getMultiImgDetail(int bttipnum) {
		List<BeautytipMultiFileBean> MultifilesBeanList = sqlsession.selectList("BeautytipMultiFile.getMultiImgDetail", bttipnum);
		return MultifilesBeanList;
	}
	
	public boolean deleteMultiFile(int bttipnum) {
		boolean result = false;
		if(sqlsession.delete("BeautytipMultiFile.deleteMultiFile", bttipnum) != 0) {
			result = true;
		}
		return result;
	}
	
}

