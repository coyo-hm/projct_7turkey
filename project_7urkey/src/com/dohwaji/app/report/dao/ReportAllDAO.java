package com.dohwaji.app.report.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;





public class ReportAllDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;

	public ReportAllDAO() {
		sqlsession = sessionf.openSession(true);
	}

	// 전체 게시글 수
	public int getReportCnt() {
		return sqlsession.selectOne("Report.reportCnt");
	}

	// 게시글 [이전] [다음] 10개씩 표시
	public List<ReportAllBean> listAll(int startRow, int endRow) {
		HashMap<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		List<ReportAllBean> reportList = sqlsession.selectList("Report.listAll", pageMap);
		return reportList;
	}

	// 내림차순으로 게시글 보기
	public int getReportSeq() {
		return sqlsession.selectOne("Report.getSeq");
	}

	// 게시글 등록
	public boolean insertReport(ReportAllBean bean) {
		boolean check = false;
		if (sqlsession.insert("Report.insertReport", bean) == 1) {
			check = true;
		}
		return check;
	}

	// 게시글 pk넘버 외부 입력 받아 , 해당 게시글 상세보기
	public ReportAllBean getDetail(int report_num) {
		return sqlsession.selectOne("Report.getDetail", report_num);
	}

	// 게시글 pk넘버 외부 입력받아 , 해당 게시글 클릭시 조회수 +1 증가
	public void updateReadCount(int report_num) {
		sqlsession.update("Report.updateReadCount", report_num);
	}

	// 삭제
	public void deleteNotice(int report_num) {
		sqlsession.delete("Report.deleteReport", report_num);
	}

	// 게시글 pk넘버 외부 입력받아 , 해당 게시글 admin 관리자 가 통과 삭제 판단 여부
	public boolean updatePass(int report_num) {
		boolean result = false;
		
		if(sqlsession.delete("Report.updatePass", report_num) != 0) {
			result = true;
		}
		
		return result;
	}

}
