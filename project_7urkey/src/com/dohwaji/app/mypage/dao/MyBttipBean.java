package com.dohwaji.app.mypage.dao;

public class MyBttipBean {
	private int bttipNum;
	private String bttipTitle;
	private String bttipDate;
	private String fileName;
	
	public MyBttipBean() {;}
	public int getBttipNum() {
		return bttipNum;
	}
	public void setBttipNum(int bttipNum) {
		this.bttipNum = bttipNum;
	}
	public String getBttipTitle() {
		return bttipTitle;
	}
	public void setBttipTitle(String bttipTitle) {
		this.bttipTitle = bttipTitle;
	}
	public String getBttipDate() {
		return bttipDate;
	}
	public void setBttipDate(String bttipDate) {
		this.bttipDate = bttipDate;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
