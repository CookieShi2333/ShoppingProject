package com.didiao.dao;

import java.util.List;

import com.didiao.pojo.Goods;
import com.didiao.pojo.GoodsContent;

public interface GoodsDao {
	//查询所有的商品信息数据
	List<Goods> selectGoodsList(String sort,String title);
	//查询商品评论内容
	List<GoodsContent> selectGoodsContent();
	//查询商品详细信息
    Goods selectGoodsDetail(int id);
    //添加商品信息
    int insertGoodsInfo(Goods good);
    //删除商品信息
    int deleteGoodsInfo(int id);
    
}
