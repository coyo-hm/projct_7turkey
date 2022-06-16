package com.dohwaji.app.notice.dao;

import java.util.HashMap;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;



public class NoticeDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	// 기본생성자
	public NoticeDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	
	// 전체 게시글 수
	public int getNoticeCnt() {
		return sqlsession.selectOne("Notice.noticeCnt");
	}

	
	// 게시글  [이전] [다음] 10개씩   표시
	public List<NoticeBean> getNoticeList(int startRow, int endRow) {
		HashMap<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		List<NoticeBean> noticeList = sqlsession.selectList("Notice.listAll", pageMap);
		return noticeList;
	}
	
	
	// 내림차순으로 게시글 보기
	public int getNoticeSeq() {
		return sqlsession.selectOne("Notice.getSeq");
	}
	
	
	// 게시글 등록 
	public boolean insertNotice(NoticeBean bean) {
		boolean check = false;
		if(sqlsession.insert("Notice.insertNotice", bean) == 1) {
			check = true;
		}
		return check;
	}
	
	
	
	// 게시글 pk넘버 외부 입력 받아 , 해당 게시글 상세보기
	public NoticeBean getDetail(int notice_num) {
		return sqlsession.selectOne("Notice.getDetail", notice_num);
	}
	
	
	// 게시글 pk넘버 외부 입력받아 , 해당 게시글 클릭시 조회수 +1 증가
	public void updateReadCount(int notice_num) {
		sqlsession.update("Notice.updateReadCount", notice_num);
	}
	
	
	
	// 삭제
	public void deleteNotice(int notice_num) {
		sqlsession.delete("Notice.deleteNotice", notice_num);
	}
	
	
	
}














