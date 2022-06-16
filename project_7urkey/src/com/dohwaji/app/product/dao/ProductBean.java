package com.dohwaji.app.product.dao;

public class ProductBean {
	private int    productNum;
	private int    catechoryDivId2;
	private String productBrand;
	private String productTitle;
	private String productExplanation;
	private long   productPrice;
	private String productDate;
	private String productImage;
	private String catechoryDivName;
	private String catechoryDivName2;
	private String catechoryDivId;
	private String avgPoint;
	private int commentCount = 0;
	private int avgValue     = 0;
	private int pointCount1  = 0;
	private int pointCount2  = 0;
	private int pointCount3  = 0;
	private int pointCount4  = 0;
	private int pointCount5  = 0; 
	
	///////////////////////// 다시 물어보기
	@Override
	public String toString() {
		StringBuilder sb  = new StringBuilder();			
		sb.append(productNum).append("	")
		.append(catechoryDivId2).append("	")
		.append(productBrand).append("	")
		.append(productTitle).append("	")
		.append(productPrice).append("	")
		.append(productDate).append("	")
		.append(productImage).append("	")
		.append(catechoryDivName).append("	")
		.append(catechoryDivName2).append("	")
		.append(catechoryDivId).append("	")
		.append(avgPoint).append("	");		
		return sb.toString();
	}
	public ProductBean() {}	
	
	
	
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public int getAvgValue() {
		return avgValue;
	}
	public void setAvgValue(int avgValue) {
		this.avgValue = avgValue;
	}
	public int getPointCount1() {
		return pointCount1;
	}
	public void setPointCount1(int pointCount1) {
		this.pointCount1 = pointCount1;
	}
	public int getPointCount2() {
		return pointCount2;
	}
	public void setPointCount2(int pointCount2) {
		this.pointCount2 = pointCount2;
	}
	public int getPointCount3() {
		return pointCount3;
	}
	public void setPointCount3(int pointCount3) {
		this.pointCount3 = pointCount3;
	}
	public int getPointCount4() {
		return pointCount4;
	}
	public void setPointCount4(int pointCount4) {
		this.pointCount4 = pointCount4;
	}
	public int getPointCount5() {
		return pointCount5;
	}
	public void setPointCount5(int pointCount5) {
		this.pointCount5 = pointCount5;
	}
	public String getAvgPoint() {
		return avgPoint;
	}
	public void setAvgPoint(String avgPoint) {
		this.avgPoint = avgPoint;
	}
	public String getCatechoryDivId() {
		return catechoryDivId;
	}
	public void setCatechoryDivId(String catechoryDivId) {
		this.catechoryDivId = catechoryDivId;
	}
	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public int getCatechoryDivId2() {
		return catechoryDivId2;
	}



	public void setCatechoryDivId2(int catechoryDivId2) {
		this.catechoryDivId2 = catechoryDivId2;
	}


	public String getProductBrand() {
		return productBrand;
	}



	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}



	public String getProductTitle() {
		return productTitle;
	}



	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}



	public String getProductExplanation() {
		return productExplanation;
	}



	public void setProductExplanation(String productExplanation) {
		this.productExplanation = productExplanation;
	}



	public long getProductPrice() {
		return productPrice;
	}



	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}



	public String getProductDate() {
		return productDate;
	}



	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}



	public String getProductImage() {
		return productImage;
	}



	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getCatechoryDivName() {
		return catechoryDivName;
	}
	public void setCatechoryDivName(String catechoryDivName) {
		this.catechoryDivName = catechoryDivName;
	}
	public String getCatechoryDivName2() {
		return catechoryDivName2;
	}
	public void setCatechoryDivName2(String catechoryDivName2) {
		this.catechoryDivName2 = catechoryDivName2;
	}
	
	

}
