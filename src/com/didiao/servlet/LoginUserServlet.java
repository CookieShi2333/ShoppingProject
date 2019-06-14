package com.didiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.didiao.dao.impl.UserInfoDaoImpl;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class LoginUserServlet
 */
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//设置编码格式为UTF-8
    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
      //接收账户参数
    	String account = request.getParameter("account");
      //接受密码参数
    	String password=request.getParameter("password");
    	
    	//System.out.println(account);
    	//System.out.println(password);
    	//System.out.println();
        //实例化UserInfoDao
    	UserInfoDaoImpl userDao=new UserInfoDaoImpl();
    	String flag1=null;
    	JsonObject obj=new JsonObject();
    	try {
    		flag1=userDao.loginUserInfo(account, password);
    		System.out.println(flag1);
    		if(flag1=="all_right"){
    			obj.addProperty("resultCode", 1);
    			obj.addProperty("message", "一切正常!");
    			request.getSession().setAttribute("account",account);
    			obj.addProperty("account","account");
    		}if(flag1=="password_error"){
    			obj.addProperty("resultCode", 2);
    			obj.addProperty("message", "密码错误");
    		}if(flag1=="account_not_exist"){
    			obj.addProperty("resultCode", 3);
    			obj.addProperty("message", "账户不存在，请重新输入!");
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	response.getWriter().write(obj.toString());
    }
    }
    


