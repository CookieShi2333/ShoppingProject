package com.didiao.dao.impl;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.didiao.dao.GoodsDao;
import com.didiao.pojo.Goods;
import com.didiao.pojo.GoodsContent;
import com.didiao.util.DbUtil;
import com.didiao.util.JDBCUtil;

public class GoodsDaoImpl implements GoodsDao{


	public List<Goods> selectGoodsList(String sort,String title) {
		//编写sql
		//1=1是做查询是用的，是为了避免其他查询为空时，这条查询语句报错
		String sql = "select * from goods where 1=1";
		if("up".equals(sort)){
			sql+=" order by money desc";// sql=sql+""
		}
		if("down".equals(sort)){
			//若要追加语句，则需在sql语句前加入空格
			sql+=" order by money";// sql=sql+""
		}
		//模糊查询条件拼接
		if(null!=title){
			String str_title=null;
			try {
				str_title=new String(title.getBytes("ISO8859-1"),"utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
			//若要追加语句，则需在sql语句前加入空格
			sql+=" and title like '%"+str_title+"%'";
		}//System.out.println("cuocuo");
		List<Goods> goodList = new ArrayList<Goods>();
		//创建商品对象
		Goods good = null;
		ResultSet rs = null;
		try{
			
		   rs = JDBCUtil.query(sql);
		   while(rs.next()){
			   good = new Goods();
			   good.setId(rs.getInt("id"));
			   good.setTitle(rs.getString("title"));
			   good.setOldMoney(Double.parseDouble(rs.getString("oldMoney")));
			   good.setMoney(Double.parseDouble(rs.getString("Money")));
			   good.setGoodNumber(Integer.parseInt(rs.getString("goodnumber")));
			   good.setGoodIntroduction(rs.getString("goodIntroduction"));
			   good.setSellNumber(Integer.parseInt(rs.getString("sellnumber")));
			   good.setImage(rs.getString("images"));
			   System.out.println(good.getId() );
			   //放入集合
			   goodList.add(good);
		   }
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConn(null, rs, null);
		}
		return goodList;
	}

	
	public List<GoodsContent> selectGoodsContent() {
		//编写查询商品评论内容信息sql
		String sql="select * from tb_content";
		Connection conn=null;
		PreparedStatement ps=null;
		List<GoodsContent> contentList=new ArrayList<GoodsContent>();
		ResultSet rs=null;
		GoodsContent goodsContent=null;
		try {
			conn=DbUtil.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				goodsContent = new GoodsContent();
				goodsContent.setId(rs.getInt("id"));
				goodsContent.setNickName(rs.getString("nick_name"));
				goodsContent.setCommentContent(rs.getString("comment_content"));
				contentList.add(goodsContent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConn(conn, rs, ps);
		}
		return contentList;
	}

    //编写查询商品详细信息
	public Goods selectGoodsDetail(int id) {
		// 编写查询商品详细信息的sql
		String sql = "select * from goods where id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Goods goods = null;
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				goods = new Goods();
				goods.setTitle(rs.getString("title"));
				goods.setGoodNumber(new Integer(rs.getString("goodNumber")));
				goods.setGoodIntroduction(rs.getString("goodIntroduction"));
				goods.setImage(rs.getString("images"));
				goods.setMoney(new Double(rs.getString("money")));
				goods.setOldMoney(new Double(rs.getString("oldMoney")));
				goods.setSellNumber(new Integer(rs.getString("sellNumber")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConn(conn, rs, ps);
		}
		return goods;
	}

	
	public int insertGoodsInfo(Goods good) {
		String sql = "insert into goods(title,oldMoney,money,goodNumber,goodIntroduction,sellNumber,images) values(?,?,?,?,?,?,?)";
		//创建连接、预编译对象、状态变量
		Connection conn = null;
		PreparedStatement ps = null;
		int status = 0;
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, good.getTitle());
			ps.setString(2, String.valueOf(good.getOldMoney()));
			ps.setString(3, String.valueOf(good.getMoney()));
			ps.setString(4, String.valueOf(good.getGoodNumber()));
			ps.setString(5, good.getGoodIntroduction());
			ps.setString(6, String.valueOf(good.getSellNumber()));
			ps.setString(7, good.getImage());
			//执行新增操作
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}


	
	public int deleteGoodsInfo(int id) {
		String sql="delete from goods where id=?";
		//创建连接
		Connection conn=null;
		//创建预编译对象
		PreparedStatement ps=null;
		int status=0;
		try {
			conn=DbUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBCUtil.closeConn(conn, null, ps);
		return status;
	}
}