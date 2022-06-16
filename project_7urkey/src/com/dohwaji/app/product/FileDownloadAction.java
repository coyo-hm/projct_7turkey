package com.dohwaji.app.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;

public class FileDownloadAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		String file_name = request.getParameter("file_name");
		String savePath = "C:\\teamproject\\workspace\\project_7urkey\\WebContent\\blue\\upload";

		InputStream in = null;
		OutputStream os = null;
		File file = null;
		boolean skip = false;
		String client = "";
		
		try {
			try {
				file = new File(savePath, file_name);
				in = new FileInputStream(file);
			}catch ( FileNotFoundException fe) {
				skip = true;
			}
			
			client = request.getHeader("User-Agent");
			
			response.reset();
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Description", "JSP Generated Data");
		
			if(!skip) {
				file_name = new String(file_name.getBytes("UTF-8"), "ISO-8859-1");
				
				if (client.indexOf("MSIE") != -1) {
					response.setHeader("Content-Disposition",	"attachment; filename=" + file_name);
				} else {
					// IE 이외
					response.setHeader("Content-Disposition", "attachment; filename=\"" + file_name + "\"");
					response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
				}

				response.setHeader("Content-Length", "" + file.length());

				out.flush();
				
				os = response.getOutputStream();
				byte b[] = new byte[(int) file.length()];
				int leng = 0;

				while ((leng = in.read(b)) > 0) {
					os.write(b, 0, leng);
				}
				
			} else {
				
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>alert('파일을 찾을 수 없습니다');history.back();</script>");
			}
			
		}catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(in != null) {
					in.close();
				}
				if(os != null) {
					os.close();
				}
			}
		return null;
	}

}
