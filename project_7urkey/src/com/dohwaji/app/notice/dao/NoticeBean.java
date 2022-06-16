package com.dohwaji.app.notice.dao;

public class NoticeBean {

//	공지 사항 VO  테이블 
//	공지글 넘버
//	공지 제목
//	공지 내용
//	작성자
//	공지 날짜
//	공지 조회수

	private int notice_num;
	private String notice_title;
	private String notice_contents;
	private String userid;
	private String notice_date;
	private int notice_readcount;

	public NoticeBean() {
		;
	}

	public int getNotice_num() {
		return notice_num;
	}

	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_contents() {
		return notice_contents;
	}

	public void setNotice_contents(String notice_contents) {
		this.notice_contents = notice_contents;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNotice_date() {
		return notice_date;
	}

	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}

	public int getNotice_readcount() {
		return notice_readcount;
	}

	public void setNotice_readcount(int notice_readcount) {
		this.notice_readcount = notice_readcount;
	}

}
