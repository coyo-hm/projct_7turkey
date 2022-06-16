package com.dohwaji.app.admin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;



public class UserDao {


	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	
	//기본 생성자 
	public UserDao() {
		// TODO Auto-generated constructor stub
		sqlsession = sessionf.openSession(true);
	}
	
	
	public String adminLogin(String id , String password) {
		HashMap<String, String> datas = new HashMap<>();
		
		datas.put("id", id);
		datas.put("password", password);
		
		

		String logindata = sqlsession.selectOne("Admin.adminlogin", datas);
		return logindata;
	}
	
	
}
