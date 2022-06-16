package com.dohwaji.app.productReview.dao;

public class ProductReviewBean {

	// < 상품 리뷰 >

	// 리뷰 넘버 id PK
	// 상품 넘버 id FK
	// 사용자 넘버 ID FK
	// 리뷰 쓰기
	// 리뷰 조회
	// 리뷰 추천
	// 리뷰 별점
	// 리뷰 날짜

	private int reviewNumId;
	private int productNumId;
	private int userNumId;
	private String reviewWrite;
	private int reviewViews;
	private int reviewLike;
	private int reviewPoint;
	private String reviewDate;

	public ProductReviewBean() {
		// TODO Auto-generated constructor stub
	}

	public int getReviewNumId() {
		return reviewNumId;
	}

	public void setReviewNumId(int reviewNumId) {
		this.reviewNumId = reviewNumId;
	}

	public int getProductNumId() {
		return productNumId;
	}

	public void setProductNumId(int productNumId) {
		this.productNumId = productNumId;
	}

	public int getUserNumId() {
		return userNumId;
	}

	public void setUserNumId(int userNumId) {
		this.userNumId = userNumId;
	}

	public String getReviewWrite() {
		return reviewWrite;
	}

	public void setReviewWrite(String reviewWrite) {
		this.reviewWrite = reviewWrite;
	}

	public int getReviewViews() {
		return reviewViews;
	}

	public void setReviewViews(int reviewViews) {
		this.reviewViews = reviewViews;
	}

	public int getReviewLike() {
		return reviewLike;
	}

	public void setReviewLike(int reviewLike) {
		this.reviewLike = reviewLike;
	}

	public int getReviewPoint() {
		return reviewPoint;
	}

	public void setReviewPoint(int reviewPoint) {
		this.reviewPoint = reviewPoint;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

}
