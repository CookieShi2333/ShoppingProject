package com.didiao.dao;

import com.didiao.pojo.User;

public interface UserInfoDao {
   //添加用户信息
	int registerUserInfo(String email,String account,String password);
   //判断用户是否存在
	//booolean true/false 默认值人false(假的) true(真的)
	boolean inNotUserAccount(String account);
	
	//用户登录
	String loginUserInfo(String account,String password);
	
	//插入用户评论
	int insertUserComment(String nickName,String comments);
}
