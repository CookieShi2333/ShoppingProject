package com.didiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.didiao.dao.GoodsDao;
import com.didiao.dao.impl.GoodsDaoImpl;
import com.didiao.pojo.Goods;

/**
 * @desc :商品详情Servlet
 */
public class GoodsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应编码格式
		response.setCharacterEncoding("utf-8");
		//设置商品id
		int id=Integer.parseInt(request.getParameter("id"));
		Goods goods=new Goods();
		GoodsDao goodsDao=new GoodsDaoImpl();
		try {
			//执行调用商品详情方法
			goods=goodsDao.selectGoodsDetail(id);
			//判断对象信息是否存在
			if(null!=goods){
				//就放到request域
				request.setAttribute("goods", goods);	
			}
			//转发
			request.getRequestDispatcher("goodinfo.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
        
	}
}
