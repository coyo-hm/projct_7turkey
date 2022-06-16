package com.dohwaji.app.blame.dao;

public class BlameBean {

//	신고 번호
//	게시글 타입 번호
//	신고 제목
//	신고 설명
//	게시글 넘버_PK
//	회원번호(신고자)
//	신고당한회원
//	승인여부 (삭제, 보류)
//	신고 날짜

	
	private int blameNumId;
	private int adminBlameId;
	private String blameTitle;
	private String blameExplanation;
	private int bbsNumId;
	private int userNumId;
	private int targetUserId;
	private String isBlame;
	private String blameDate;
	
	

	public BlameBean() {
		// TODO Auto-generated constructor stub
	}
	
	

	public int getBlameNumId() {
		return blameNumId;
	}

	public void setBlameNumId(int blameNumId) {
		this.blameNumId = blameNumId;
	}

	public int getAdminBlameId() {
		return adminBlameId;
	}

	public void setAdminBlameId(int adminBlameId) {
		this.adminBlameId = adminBlameId;
	}

	public String getBlameTitle() {
		return blameTitle;
	}

	public void setBlameTitle(String blameTitle) {
		this.blameTitle = blameTitle;
	}

	public String getBlameExplanation() {
		return blameExplanation;
	}

	public void setBlameExplanation(String blameExplanation) {
		this.blameExplanation = blameExplanation;
	}

	public int getBbsNumId() {
		return bbsNumId;
	}

	public void setBbsNumId(int bbsNumId) {
		this.bbsNumId = bbsNumId;
	}

	public int getUserNumId() {
		return userNumId;
	}

	public void setUserNumId(int userNumId) {
		this.userNumId = userNumId;
	}

	public int getTargetUserId() {
		return targetUserId;
	}

	public void setTargetUserId(int targetUserId) {
		this.targetUserId = targetUserId;
	}

	public String getIsBlame() {
		return isBlame;
	}

	public void setIsBlame(String isBlame) {
		this.isBlame = isBlame;
	}

	public String getBlameDate() {
		return blameDate;
	}

	public void setBlameDate(String blameDate) {
		this.blameDate = blameDate;
	}

}
