package com.dohwaji.app.product;

import java.util.Enumeration;
import java.util.HashMap;

import com.oreilly.servlet.MultipartRequest;

public class ProductUtil {

	//	 MultipartRequest 에서 파일명를 가져온다 1개만 허용된다
	public static String getMultipartFileName(MultipartRequest multi) {

		HashMap<String, Object> fileMap = new HashMap<>();

		Enumeration<String> files = multi.getFileNames();
		while (files.hasMoreElements()) {
			String data = files.nextElement();
			if (multi.getFilesystemName(data) == null) {
				continue;
			}

			return multi.getFilesystemName(data);

		}
		return null;
	}

}
