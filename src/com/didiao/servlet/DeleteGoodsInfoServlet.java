package com.didiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.didiao.dao.GoodsDao;
import com.didiao.dao.impl.GoodsDaoImpl;
import com.google.gson.JsonObject;



	public class DeleteGoodsInfoServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
		
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			int id=new Integer(request.getParameter("id"));
			GoodsDao goodDao=new GoodsDaoImpl();
			int status=goodDao.deleteGoodsInfo(id);
			//创建JSONObject对象
			JsonObject obj = new JsonObject();
			if(status>0){
				obj.addProperty("resultCode",1);
				obj.addProperty("message","删除成功!");
			}else{
				obj.addProperty("resultCode",0);
				obj.addProperty("message", "删除失败");
			}
			//将信息响应到浏览器页面
			response.getWriter().write(obj.toString());
		}
}
