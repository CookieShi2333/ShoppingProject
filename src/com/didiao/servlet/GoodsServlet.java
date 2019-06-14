package com.didiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.didiao.dao.impl.GoodsDaoImpl;
import com.didiao.pojo.Goods;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class GoodsServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	//重写HttpServlet中的service方法（包括了doGet和doPost方法）
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应编码格式
		response.setCharacterEncoding("utf-8");
		//获取前端传递的排序参数
		String sort=request.getParameter("sort");
		//接收模糊查询的条件参数也就是我们的title（根据商品名称）
		String title = request.getParameter("title");
		//json===>>>>{name:zhangsan,age:18}
		response.setContentType("application/json,character=utf-8");
		//初始化Dao实现类
		GoodsDaoImpl dao = new GoodsDaoImpl();
		//调用Dao查询商品信息列表数据
		List<Goods> GoodsList = dao.selectGoodsList(sort,title);
		JsonObject obj = new JsonObject();
		//判断集合中的数据
		if(null == GoodsList){
			obj.addProperty("resultCode", 0);
			obj.addProperty("message", "获取失败！");
			
		}else {
			//创建一个JsonArray数组（用于json数据存放）
			//数组里存储对象
			JsonArray array = new JsonArray();
			//遍历查询出来的商品信息列表then放在JsonObject中
			//快捷键整理代码格式CTRL+I 或CTRL+SHIFT+F
			
			for (Goods good : GoodsList) {
				JsonObject dataObject = new JsonObject();
				dataObject.addProperty("id", good.getId());
				dataObject.addProperty("title", good.getTitle());
				dataObject.addProperty("oldMoney", good.getOldMoney());
				dataObject.addProperty("money", good.getMoney());
				dataObject.addProperty("goodNumber", good.getGoodNumber());
				dataObject.addProperty("goodIntroduction", good.getGoodIntroduction());
				dataObject.addProperty("sellNumber", good.getSellNumber());
				dataObject.addProperty("image", good.getImage());
				//将dataObject放入JsonArray
				array.add(dataObject);
			}
			obj.addProperty("resultCode", 1);//1代表获取数据成功
			obj.addProperty("message", "获取成功！");
			obj.add("data", array);
		}
        //响应数据
		response.getWriter().write(obj.toString());
	}

}
