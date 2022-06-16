package com.dohwaji.app.mypage.dao;

public class FollowBean {
	private String userNum;
	private String targetUserNum;
	private boolean state;
	private MypageBean targetUserInfo;
	
	public FollowBean() {;}

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getTargetUserNum() {
		return targetUserNum;
	}

	public void setTargetUserNum(String targetUserNum) {
		this.targetUserNum = targetUserNum;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public MypageBean getTargetUserInfo() {
		return targetUserInfo;
	}

	public void setTargetUserInfo(MypageBean targetUserInfo) {
		this.targetUserInfo = targetUserInfo;
	}

}
