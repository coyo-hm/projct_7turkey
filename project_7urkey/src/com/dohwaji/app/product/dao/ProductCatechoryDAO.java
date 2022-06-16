package com.dohwaji.app.product.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.app.catechory.dao.CatechoryBean;
import com.dohwaji.config.SqlMapConfig;

public class ProductCatechoryDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public ProductCatechoryDAO() {
		sqlsession = sessionf.openSession(true);
	}

	
//	 대분류가져오기

	public List<CodeBean> getCat(){
		List<CodeBean> cats = sqlsession.selectList("ProductExt.getCat");
		return cats;
	}
	
//	 소분류가져오기
	 
	public List<CodeBean> getCat2(String category){

	    HashMap<String, String> datas = new HashMap<>();
		datas.put("category", category);
		
		List<CodeBean> cats = sqlsession.selectList("ProductExt.getCat2", datas);
		return cats;
	}
	
}

