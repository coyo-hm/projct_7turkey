package com.dohwaji.app.search.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;







public class SearchDao {


	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	
	//기본 생성자 
	public SearchDao() {
		sqlsession = sessionf.openSession(true);
		
	}
	
	//여기까지는 실행되는거같음 
	public List<SearchBeautyTipBean> searchList(String query) {
		
		
		
		List<SearchBeautyTipBean> searchList = sqlsession.selectList("Search.searchbeautytip",query);
		
		System.out.println(searchList);
		for (int i = 0; i < searchList.size(); i++) {
			System.out.println(searchList.get(i).getBttiptitle());
		}
		
		return searchList;
		
		
		
		
	}//성공다오 
	
	
	
	
	
	
public List<SearchProductBean> searchListOne(String query) {
		
		
	//넘어오는게 갯수는 맞는데 값이안넘어옴 
	List<SearchProductBean> searchListOne = sqlsession.selectList("Search.searchproduct",query);
		System.out.println("size : "+searchListOne.size());//null값넘어옴
		System.out.println(searchListOne+"여기 못받나요?");//null값넘어옴 
		
		for (int i = 0; i < searchListOne.size(); i++) {
			System.out.println(searchListOne.get(i).getProduct_Title());
		}
		
		return searchListOne;
		
		
		
		
	}
	
	
	


	public List<SearchProductReviewBean> reviewSearch(String query) {
		
		
		
		List<SearchProductReviewBean> reviewSearch = sqlsession.selectList("Search.searchreview",query);
		
		System.out.println(reviewSearch);
		for (int i = 0; i < reviewSearch.size(); i++) {
			System.out.println(reviewSearch.get(i).getReview_title());
		}
		
		return reviewSearch;
		
		
		
		
	}





	
}
