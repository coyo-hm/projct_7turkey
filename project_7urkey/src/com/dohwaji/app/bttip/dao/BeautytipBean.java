package com.dohwaji.app.bttip.dao;

public class BeautytipBean {
	private int bttipNum;
	private String userID;
	private String bttipTitle;
	private String bttipDate;
	private String bttipContent;
	private String bttipGender;
	private String bttipAge;
	private String bttipEye;
	private String bttipNose;
	private String bttipLip;
	private String bttipFace;
	private String bttipType;
	private String bttipTone;
	private String bttipSeason;
	private String bttipTheme;
	private int bttipLike;

	public BeautytipBean() {
		;
	}

	public int getBttipNum() {
		return bttipNum;
	}

	public void setBttipNum(int bttipNum) {
		this.bttipNum = bttipNum;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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

	public String getBttipContent() {
		return bttipContent;
	}

	public void setBttipContent(String bttipContent) {
		this.bttipContent = bttipContent;
	}

	public String getBttipGender() {
		return bttipGender;
	}

	public void setBttipGender(String bttipGender) {
		this.bttipGender = bttipGender;
	}

	public String getBttipAge() {
		return bttipAge;
	}

	public void setBttipAge(String bttipAge) {
		this.bttipAge = bttipAge;
	}

	public String getBttipEye() {
		return bttipEye;
	}

	public void setBttipEye(String bttipEye) {
		this.bttipEye = bttipEye;
	}

	public String getBttipNose() {
		return bttipNose;
	}

	public void setBttipNose(String bttipNose) {
		this.bttipNose = bttipNose;
	}

	public String getBttipLip() {
		return bttipLip;
	}

	public void setBttipLip(String bttipLip) {
		this.bttipLip = bttipLip;
	}

	public String getBttipFace() {
		return bttipFace;
	}

	public void setBttipFace(String bttipFace) {
		this.bttipFace = bttipFace;
	}

	public String getBttipType() {
		return bttipType;
	}

	public void setBttipType(String bttipType) {
		this.bttipType = bttipType;
	}

	public String getBttipTone() {
		return bttipTone;
	}

	public void setBttipTone(String bttipTone) {
		this.bttipTone = bttipTone;
	}

	public String getBttipSeason() {
		return bttipSeason;
	}

	public void setBttipSeason(String bttipSeason) {
		this.bttipSeason = bttipSeason;
	}

	public String getBttipTheme() {
		return bttipTheme;
	}

	public void setBttipTheme(String bttipTheme) {
		this.bttipTheme = bttipTheme;
	}

	public int getBttipLike() {
		return bttipLike;
	}

	public void setBttipLike(int bttipLike) {
		this.bttipLike = bttipLike;
	}

	@Override
	public int hashCode() {
		return bttipNum;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BeautytipBean) {
			BeautytipBean newobj = (BeautytipBean) obj;
			if (this.bttipNum == newobj.bttipNum) {
				return true;
			}
		}
		return false;
	}
}
