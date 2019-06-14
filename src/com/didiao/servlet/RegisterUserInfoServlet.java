package com.didiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.didiao.dao.impl.UserInfoDaoImpl;
import com.google.gson.JsonObject;

/**
 * Desc: 用户信息注册Servlet
 */
public class RegisterUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   UserInfoDaoImpl userDao=new UserInfoDaoImpl();
	 
		// 设置请求数据编码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取前端传递的参数getParameter()方法获取
		String email=request.getParameter("email");
	    String account=request.getParameter("account");
	    String password=request.getParameter("password");
	    int status=0;
	    JsonObject obj=new JsonObject();
	    try {
	      status = userDao.registerUserInfo(email, account, password);
	      if(status<=0){
	    	  obj.addProperty("resultCode", 0);
	    	  obj.addProperty("message", "注册失败！");
	      }else{
	    	  obj.addProperty("resultCode", 1);
	    	  obj.addProperty("message","注册成功!");
	      }}catch (Exception e) {
		      e.printStackTrace();
	      }
	      response.getWriter().write(obj.toString());
	}}
	    
	

