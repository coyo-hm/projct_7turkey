package com.dohwaji.app.mypage.dao;

public class MypageBean {
	private int usernum;
	private String userid;
	private String useremail;
	private String username;
	private String userfileimg;
	private int postnum;
	private int followernum;
	private int followingnum;
	private boolean f_state;
	public MypageBean() {;}

	public int getUsernum() {
		return usernum;
	}

	public void setUsernum(int usernum) {
		this.usernum = usernum;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserfileimg() {
		return userfileimg;
	}

	public void setUserfileimg(String userfileimg) {
		this.userfileimg = userfileimg;
	}

	public int getPostnum() {
		return postnum;
	}

	public void setPostnum(int postnum) {
		this.postnum = postnum;
	}

	public int getFollowernum() {
		return followernum;
	}

	public void setFollowernum(int followernum) {
		this.followernum = followernum;
	}

	public int getFollowingnum() {
		return followingnum;
	}

	public void setFollowingnum(int followingnum) {
		this.followingnum = followingnum;
	}

	public boolean isF_state() {
		return f_state;
	}

	public void setF_state(boolean f_state) {
		this.f_state = f_state;
	}
	
	
	
}
