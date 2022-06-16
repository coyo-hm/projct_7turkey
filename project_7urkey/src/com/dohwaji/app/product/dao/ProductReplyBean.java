package com.dohwaji.app.product.dao;

public class ProductReplyBean {
	private int commentNum    = 0;
	private int productNum      = 0;
	private String userid        = null;
	private String commentWrite = null;
	private int commentBlame    = 0;
	private int commentPoint    = 0;
	private String commentDate     = null;
	private String commentStars    = null;

	@Override
	public String toString() {

		StringBuilder sb  = new StringBuilder();			
		sb.append(commentNum).append("	")
		.append(productNum).append("	")
		.append(userid).append("	")
		//.append(commentBlame).append("	")
		.append(commentWrite).append("	")
		.append(commentPoint).append("	")
		.append(commentDate).append("	");	
		return sb.toString();
	}
	
	public ProductReplyBean() {}



	public String getCommentStars() {
		return commentStars;
	}

	public void setCommentStars(String commentStars) {
		this.commentStars = commentStars;
	}

	public int getCommentNum() {
		return commentNum;
	}



	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}



	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getProductNum() {
		return productNum;
	}


	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}




	public String getCommentWrite() {
		return commentWrite;
	}


	public void setCommentWrite(String commentWrite) {
		this.commentWrite = commentWrite;
	}


	public int getCommentBlame() {
		return commentBlame;
	}


	public void setCommentBlame(int commentBlame) {
		this.commentBlame = commentBlame;
	}


	public int getCommentPoint() {
		return commentPoint;
	}


	public void setCommentPoint(int commentPoint) {
		this.commentPoint = commentPoint;
	}


	public String getCommentDate() {
		return commentDate;
	}


	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	
	
}
