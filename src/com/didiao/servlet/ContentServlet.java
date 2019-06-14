package com.didiao.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.didiao.dao.GoodsDao;
import com.didiao.dao.impl.GoodsDaoImpl;
import com.didiao.pojo.GoodsContent;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * @Desc:内容评论Servlet
 */
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//设置响应编码
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	//创建dao对象
	GoodsDao goodsDao=new GoodsDaoImpl();
	List<GoodsContent> contentList=new ArrayList<GoodsContent>();
	//创建Json对象
	JsonObject obj=new JsonObject();
	//创建GSON对象
	Gson gson=new Gson();
	try {
		//调用DAO查询所有商品的评论信息
		contentList=goodsDao.selectGoodsContent();
	    if(contentList!=null&&contentList.size()>0){
	       //将集合转换为JSON
	    	String json=gson.toJson(contentList);
	    	obj.addProperty("data", json);
	    }
	    response.getWriter().write(obj.toString());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

}
