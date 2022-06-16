package com.dohwaji.app.report.dao;

import java.util.Enumeration;




import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;
import com.oreilly.servlet.MultipartRequest;

public class ReportFilesDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public ReportFilesDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	public boolean insertFiles(MultipartRequest multi, int report_num) {
		HashMap<String, Object> fileMap = new HashMap<>();
		Enumeration<String> files = multi.getFileNames();
		System.out.println(files);
		boolean check = true;
		
		fileMap.put("report_num", report_num);
		
		while(files.hasMoreElements()) {
			String data = files.nextElement();
			System.out.println("1");
			System.out.println(data);
			if(multi.getFilesystemName(data) == null) {continue;}
			fileMap.put("report_file_name", multi.getFilesystemName(data));
			if(sqlsession.insert("ReportFiles.insertFile", fileMap) != 1) {
				check = false;
				break;
			}
		}
		return check;
	}
	
	public List<ReportFilesBean> getDetail(int report_num) {
		List<ReportFilesBean> filesBeanList =  sqlsession.selectList("ReportFiles.getDetail", report_num);
		System.out.println("2");
		return filesBeanList;
	}
	
	
	
	// 삭제
	public void deleteFiles(int report_num) {
		sqlsession.delete("ReportFiles.deleteFiles", report_num);
	}
	
	
}










