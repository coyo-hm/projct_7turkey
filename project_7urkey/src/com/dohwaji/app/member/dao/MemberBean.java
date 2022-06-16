package com.dohwaji.app.member.dao;

public class MemberBean {
	private int usernum;
	private String userid;
	private String userpw;
	private String useremail;
	private String username;
	private String userphone;
	private int followernum;
	private int followingnum;
	private String userck;
	
	public MemberBean() {;}
	
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
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
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
	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getUserck() {
		return userck;
	}

	public void setUserck(String userck) {
		this.userck = userck;
	}
	
	
}
