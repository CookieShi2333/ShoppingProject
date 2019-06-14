package com.didiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.didiao.dao.UserInfoDao;
import com.didiao.dao.impl.UserInfoDaoImpl;
import com.google.gson.JsonObject;
 

public class ProductContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	String nickName = new String(request.getParameter("nickName").getBytes("ISO8859-1"),"UTF-8");
    	String content = new String(request.getParameter("content").getBytes("ISO8859-1"),"UTF-8");
    	//System.out.println(nickName);
    	JsonObject obj=new JsonObject();
    	UserInfoDao userDao=new UserInfoDaoImpl();
    	int status=0;
    	try {
			status=userDao.insertUserComment(nickName, content);
			System.out.println(status);
		  if(status>0){
			  obj.addProperty("resultCode",1);
			  obj.addProperty("message", "新增成功!");
		  }else{
			  obj.addProperty("resultCode",0);
			  obj.addProperty("message", "新增失败!");
		  }
		  response.getWriter().write(obj.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
}
