package com.dohwaji.app.product.dao;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;

public class ProductReplyDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public ProductReplyDAO() {
		
		sqlsession = sessionf.openSession(true);
	}
	
	// 리뷰 별점 순
	public List<ProductReplyBean> starReply(int productNum) {
		HashMap<String, String> pageMap = new HashMap<>();
		pageMap.put("productNum", String.valueOf(productNum));
		List<ProductReplyBean> starReplyList = sqlsession.selectList("Product.starReply", pageMap);
		return starReplyList;
	}
	
	
	// 댓글 정보가져 오기
	public List<ProductReplyBean> like_all(int seq){
		List<Integer> list_comment = sqlsession.selectList("Product.likeAll", seq);
		List<ProductReplyBean> comment_info = new ArrayList<>();
		for(int i : list_comment) {
			ProductReplyBean temp = sqlsession.selectOne("Product.getCommentInfo", i);
			comment_info.add(temp);
		}
		return comment_info;
	}
	
	// 
	
	// 나만의 글 조회
	public List<ProductReplyBean> mypageReply(int productNum, String userid) {
		HashMap<String, String> pageMap = new HashMap<>();
		pageMap.put("productNum", String.valueOf(productNum));
		pageMap.put("userid", userid);
		List<ProductReplyBean> mypageReplyList = sqlsession.selectList("Product.mypageReply", pageMap);
		return mypageReplyList;
	}
	
	
	
	// 댓글 추천여부 검사
	public int like_check(Map<String, Object> m) {
		int result = 0;

		result = (Integer) sqlsession.selectOne("Product.like_check", m);

		return result;
	}

	// 댓글 추천
	public void like_update(Map<String, Object> m) {

		sqlsession.insert("Product.like_update", m);

	}

	// 댓글 추천 제거
	public void like_delete(Map<String, Object> m) {

		sqlsession.delete("Product.like_delete", m);

	}

	// 댓글 추천수
	public int like_count(int commentNum) {
		int count = 0;

		count = (Integer) sqlsession.selectOne("Product.like_count", commentNum);

		return count;
	}
	
	
	public boolean insertReply(ProductReplyBean r_bean) {
		boolean check = false;
		if(sqlsession.insert("Product.insertReply", r_bean) == 1) {
			check = true;
		}
		return check;
	}
	
	public List<ProductReplyBean> getReply(int productNum) {
		HashMap<String, Integer> pageMap = new HashMap<>();
		pageMap.put("productNum", productNum);
		
		List<ProductReplyBean> replyList = sqlsession.selectList("Product.getReply", pageMap);
		return replyList;
	}

	public List<ProductReplyBean> getReplyByUserid(int productNum, String userid) {
		HashMap<String, String> pageMap = new HashMap<>();
		pageMap.put("productNum", String.valueOf(productNum));
		pageMap.put("userid", userid);
		List<ProductReplyBean> replyList = sqlsession.selectList("Product.getReplyByUserid", pageMap);
		return replyList;
	}
	
	public void deleteReply(int product_num) {
		sqlsession.delete("Product.deleteReply", product_num);
	}
	
	public void deleteOneReply(int reply_num) {
		sqlsession.delete("Product.deleteOneReply", reply_num);
	}
	
	public void updateReply(int reply_num, String reply_contents) {
		HashMap<String, Object> replyMap = new HashMap<>();
		replyMap.put("reply_num", reply_num);
		replyMap.put("reply_contents", reply_contents);
		sqlsession.update("Board.updateReply", replyMap);
	}
}
