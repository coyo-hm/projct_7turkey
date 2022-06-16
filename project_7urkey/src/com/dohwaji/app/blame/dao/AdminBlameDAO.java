package com.dohwaji.app.blame.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;

public class AdminBlameDAO {
	
	
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	
	public AdminBlameDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	
	// 게시글 등록
	public boolean enrollment(AdminBlameDAO adminBlame) {
		boolean check = false;
		
		// 게시글 쿼리 (수정중)
		if(sqlsession.insert("Blame.enrollment", adminBlame) == 1) {
			check = true;
		}
		return check;
	}

	
	
	
	

}
