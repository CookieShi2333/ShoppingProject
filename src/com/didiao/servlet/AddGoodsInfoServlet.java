package com.didiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.didiao.dao.GoodsDao;
import com.didiao.dao.impl.GoodsDaoImpl;
import com.didiao.pojo.Goods;
import com.google.gson.JsonObject;

/**
 * @desc 增加商品信息
 */
public class AddGoodsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//请求编码设置
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//接受参数
		String title = request.getParameter("title");
		String oldMoney = request.getParameter("oldMoney");
		String money = request.getParameter("money");
		String goodNumber = request.getParameter("goodNumber");
		String goodIntroduction = request.getParameter("goodIntroduction");
		String sellNumber = request.getParameter("sellNumber");
		String images = request.getParameter("images");
		//对图片的url做处理
		if(null!=images&&images.length()>0) {
			images = "http://localhost:8081/ShoppingProject/goods/"+images;
		}
		//创建DAO对象
		GoodsDao goodsDao = new GoodsDaoImpl();
		//创建JSONObject对象
		JsonObject obj = new JsonObject();
		//创建goods对象
		Goods good = new Goods();
		//状态值
		int status = 0;
		try {
			//将参数数据放入Goods对象中
			good.setTitle(title);
			good.setOldMoney(Double.parseDouble(oldMoney));
			good.setMoney(Double.parseDouble(money));
			good.setGoodNumber(Integer.parseInt(goodNumber));
			good.setGoodIntroduction(goodIntroduction);
			good.setSellNumber(Integer.parseInt(sellNumber));
			good.setImage(images);
			//执行调用
			status = goodsDao.insertGoodsInfo(good);
			//数据判断
			if(status > 0) {
				obj.addProperty("resultCode", 1);
				obj.addProperty("message", "新增成功！");
			}else {
				obj.addProperty("resultCode", 0);
				obj.addProperty("message", "新增失败！");
			}
			response.getWriter().write(obj.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
