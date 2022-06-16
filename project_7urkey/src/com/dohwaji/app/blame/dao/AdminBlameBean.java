package com.dohwaji.app.blame.dao;

public class AdminBlameBean {
	
//	신고번호_PK
//	신고_게시글_타입

	
	private int adminBlameId;
	private String adminBlameTarget;
	
	
	
	public AdminBlameBean() {
		
	}
	
	
	public int getAdminBlameID() {
		return adminBlameId;
	}
	public void setAdminBlameID(int adminBlameId) {
		this.adminBlameId = adminBlameId;
	}
	public String getAdminBlameTarget() {
		return adminBlameTarget;
	}
	public void setAdminBlameTarget(String adminBlameTarget) {
		this.adminBlameTarget = adminBlameTarget;
	}
	
	
	
	
	
	

}
