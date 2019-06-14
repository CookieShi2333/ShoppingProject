package com.didiao.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @Description: 数据库连接类
 * @author GXJ
 * @Company:华北科技学院
 * @Date:2019年3月17日
 */
public class DbUtil {
	
	//共享连接参数
	private static String SQL_DRIVER = "";
	private static String SQL_URL = "";
	private static String SQL_USERNAME = "";
	private static String SQL_PASSWORD = "";
	
	
	//先加载，一调用该类就先加载资源文件
	static {
		getPropertiesInfo();
	} 
	
	//读取资源文件
	private static void getPropertiesInfo() {
		Properties proper = new Properties();
		InputStream instream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
		try {
			proper.load(instream);
		} catch (Exception ex) {
			System.out.println("无法找到Properties文件！！");
			ex.printStackTrace();
		}
		SQL_DRIVER = proper.getProperty("driver");
		SQL_URL = proper.getProperty("url");
		SQL_USERNAME = proper.getProperty("username");
		SQL_PASSWORD = proper.getProperty("password");
	}
	
	//提供公共的获取方法
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// 加载驱动
			Class.forName(SQL_DRIVER);
		} catch (Exception ex) {
			System.out.println("驱动错误！请检查！");
			ex.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(SQL_URL,SQL_USERNAME,SQL_PASSWORD);
		} catch (Exception ex) {
			System.out.println("数据库的连接出现错误！请检查！");
			ex.printStackTrace();
		}
		return conn;
	}
}
