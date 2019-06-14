package com.didiao.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadFileServlet
 */
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//创建文件上传处理器
		ServletFileUpload upload = new ServletFileUpload(factory);
		//开始解析请求信息
		@SuppressWarnings("rawtypes")
		List items = null;
		try {
			items = upload.parseRequest(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//对所有请求信息进行判断
		@SuppressWarnings("rawtypes")
		Iterator iter = items.iterator();
		while(iter.hasNext()) {
			FileItem item = (FileItem)iter.next();
			//信息为普通格式
			if(item.isFormField()) {
				String fieldName = item.getFieldName();
				String value = item.getString();
				request.setAttribute(fieldName, value);
			}else {
				//信息为文件格式
				String fileName = item.getName();
				System.out.println(fileName);
				int index = fileName.lastIndexOf("\\");
				fileName = fileName.substring(index+1);
				request.getSession().setAttribute("realFileName", fileName);
				File file = new File("E:\\NEW_WORK\\ShoppingProject\\WebContent\\goods",fileName);
				try {
					item.write(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.setAttribute("msg", "文件上传成功!");
			request.getRequestDispatcher("/add_goodinfo.jsp").forward(request, response);
		}
	}

}
