package com.didiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.didiao.dao.impl.UserInfoDaoImpl;
import com.google.gson.JsonObject;

/**
 * 校验用户账户信息Servlet
 */
public class UserAccountServlet extends HttpServlet {
  
 
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
  //设置编码格式为UTF-8
	request.setCharacterEncoding("utf-8");
  //接收参数
	String account = request.getParameter("account");
    //实例化UserInfoDao
	UserInfoDaoImpl userDao=new UserInfoDaoImpl();
	
	JsonObject obj=new JsonObject();
	try {
		boolean flag=userDao.inNotUserAccount(account);
		if(flag){
			obj.addProperty("resultCode", 1);
		}else{
			obj.addProperty("resultCode", 0);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	response.getWriter().write(obj.toString());
}

}
