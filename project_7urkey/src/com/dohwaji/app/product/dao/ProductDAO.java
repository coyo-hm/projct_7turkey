package com.dohwaji.app.product.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;

public class ProductDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public ProductDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	public int getProductCnt() {
		return sqlsession.selectOne("Product.productCnt");
	}
	
	public List<ProductBean> getProductList(int startRow, int endRow, int category1Id, int category2Id, int list_order){
		HashMap<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("category1Id", category1Id);
		pageMap.put("category2Id", category2Id);
		pageMap.put("list_order", list_order);
		List<ProductBean> productList = sqlsession.selectList("Product.listAll", pageMap);
		if(productList.size() > 0 )  System.out.println(productList.get(0).toString());
		return productList;
	}
	
	public int getProductSeq() {
		return sqlsession.selectOne("Product.getSeq");
	}

	public boolean insertProduct(ProductBean bean) {
		boolean check = false;
		if(sqlsession.insert("Product.insertProduct", bean) == 1) {
			check = true;
		}
		return check;
	}
	
	public ProductBean getDetail(int productNum) {
		return sqlsession.selectOne("Product.getDetail", productNum);
	}
	
	// 강사님꺼 가져옴 ( 안씀)
	public void updateReadCount(int product_num) {
		sqlsession.update("Product.updateReadCount", product_num);
	}

	public int getMaxProductNum() {
		return sqlsession.selectOne("Product.getMaxProductNum");
	}
	
	public void deleteProduct(int ProductNum) {
		sqlsession.delete("Product.deleteProduct", ProductNum);
	}
	
	public void updateProduct(ProductBean bean) {
		sqlsession.update("Product.updateProduct", bean);
	}
	
	
	
	
}




















