package com.dohwaji.app.product.dao;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.print.attribute.HashAttributeSet;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;
import com.oreilly.servlet.MultipartRequest;

public class ProductFilesDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;

	public ProductFilesDAO() {
		sqlsession = sessionf.openSession(true);
	}

	public boolean insertFiles(MultipartRequest multi, int product_num) {
		HashMap<String, Object> fileMap = new HashMap<>();
		Enumeration<String> files = multi.getFileNames();
		boolean check = true;

		fileMap.put("productNum", product_num);
		System.out.println("FilesDAO.productNum=" + product_num);
		
		while (files.hasMoreElements()) {
			String data = files.nextElement();
			if (multi.getFilesystemName(data) == null) {
				continue;
			}
			String fileName = multi.getFilesystemName(data);
			fileMap.put("fileName", fileName);
			System.out.println("FilesDAO.fileName=" + fileName);
			if (sqlsession.insert("ProductFiles.insertFile", fileMap) != 1) {
				check = false;
				break;
			}
		}
		return check;
	}

	public List<ProductFilesBean> getDetail(int productNum) {
		List<ProductFilesBean> filesBeanList = sqlsession.selectList("ProductFiles.getDetail", productNum);
		return filesBeanList;
	}

	public void deleteFiles(int productNum) {
		sqlsession.delete("ProductFiles.deleteFiles", productNum);
	}

}
