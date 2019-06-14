package com.didiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.didiao.dao.UserInfoDao;
import com.didiao.pojo.User;
import com.didiao.util.DbUtil;
import com.didiao.util.JDBCUtil;


public class UserInfoDaoImpl implements UserInfoDao{

	public int registerUserInfo(String email, String account, String password) {
		//编写注册sql  ?占位符，这样可以防止sql注入
		String sql="insert into user(email,account,password) values(?,?,?)";
		//创建连接 导包导入java.sql
	    Connection conn=null;
	    //创建预编译对象，导入java.sql包
	    PreparedStatement ps=null;
	    //添加成功后的状态变量
	    int status=0;
	    try{
	    	conn=DbUtil.getConnection();
	    	ps= conn.prepareStatement(sql);
	    	//设置占位符
	    	ps.setString(1, email);
	    	ps.setString(2,account);
	    	ps.setString(3, password);
	    	//执行插入
	    	status=ps.executeUpdate();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }finally{
	    	JDBCUtil.closeConn(conn, null, ps);
	    }
		return status;
	}

	public boolean inNotUserAccount(String account) {
		//编写查询用户账号SQL
		//根据账户的账号查询该账户的是否存在账号 账号：account
		String sql="select * from user where account=?";
		boolean flag=false;
		ResultSet rs=null;
		//创建连接
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DbUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, account);
			rs=ps.executeQuery();
			if(rs.next()){
			 flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConn(conn, rs, ps);
		}
		return flag;
	}

	/* (non-Javadoc)
	 * 用户登录功能实现
	 */
	
	public String loginUserInfo(String account, String password) {
		//编写查询用户账号SQL
				//根据账户的账号查询该账户的是否存在账号 账号：account
				String sql="select * from user where account=?";
				boolean flag=false;
				ResultSet rs=null;
				//创建连接
				Connection conn=null;
				PreparedStatement ps=null;
				String flag1=null;
				User user=new User();
				//System.out.println(account);
		    	//System.out.println(password);
				try {
					conn=DbUtil.getConnection();
					ps=conn.prepareStatement(sql);
					ps.setString(1, account);
					rs=ps.executeQuery();
					if(rs.next()){//如果账户存在
					 user.setAccount(rs.getString("account"));
					 user.setPassword(rs.getString("password"));
					 System.out.println(user.getPassword());
					 if(password.equals(user.getPassword())){//如果存在账户的密码正确
						 flag1="all_right";
					 }else{//如果存在账户的密码错误
						 flag1="password_error";
					 }
					}else{//如果账户不存在
						 flag1="account_not_exist";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					JDBCUtil.closeConn(conn, rs, ps);
				}
				return flag1;
	}

	public int insertUserComment(String nickName, String comments) {
		//编写新增商品评论内容sql
		String sql="insert into tb_content(nick_name,comment_content) values (?,?)";
		Connection conn=null;   //创建连接
		PreparedStatement ps=null;//创建预编译对象
		int status=0;  //返回数据状态值
		try {
			conn=DbUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, nickName);  //设置占位符
			ps.setString(2, comments);
			status=ps.executeUpdate();  //执行新增
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConn(conn, null, ps);
		}
		return status;
	}

}
