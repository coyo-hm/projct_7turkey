package com.dohwaji.app.bttip.dao;

public class BeautytipMultiFileBean {

	private String filename;
	private int bttipnum;
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getBttipnum() {
		return bttipnum;
	}
	public void setBttipnum(int bttipnum) {
		this.bttipnum = bttipnum;
	}
	
	public String toString() {
		return getFilename();
	}
	
}
