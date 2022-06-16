package com.dohwaji.app.report.dao;

public class ReportAllBean {

	/**
	 * 신고 게시글 VO
	 * 
	 * 신고 넘버 PK 신고 게시글 타입(나만의화장법, 제품리뷰, 기타등) 신고 당한 게시글 신고 당한 자 (일반회원)FK 신고 자(일반회원)
	 * FK 신고 제목 신고 내용 신고 날짜
	 *
	 */

	private int report_num;
	private String report_type;
	private int report_board;
	private String userid;
	private String report_title;
	private String report_contents;
	private String report_date;
	private String report_result;

	public ReportAllBean() {
		// TODO Auto-generated constructor stub
	}

	public int getReport_num() {
		return report_num;
	}

	public void setReport_num(int report_num) {
		this.report_num = report_num;
	}

	public String getReport_type() {
		return report_type;
	}

	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}

	public int getReport_board() {
		return report_board;
	}

	public void setReport_board(int report_board) {
		this.report_board = report_board;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getReport_title() {
		return report_title;
	}

	public void setReport_title(String report_title) {
		this.report_title = report_title;
	}

	public String getReport_contents() {
		return report_contents;
	}

	public void setReport_contents(String report_contents) {
		this.report_contents = report_contents;
	}

	public String getReport_date() {
		return report_date;
	}

	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}

	public String getReport_result() {
		return report_result;
	}

	public void setReport_result(String report_result) {
		this.report_result = report_result;
	}

	
}
