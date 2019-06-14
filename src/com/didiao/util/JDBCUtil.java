package com.didiao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description:持久层工具类
 * @author GXJ
 * @Company:华北科技学院
 * @Date:2019年3月17日
 */
public class JDBCUtil {

	// 写一个插入信息的模板
	public static int insert(String sql,Connection conn) {
		int rows = 0;
		try {
			rows = conn.prepareStatement(sql).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	// 查询操作的模板
	public static ResultSet query(String sql) {
		Connection conn = DbUtil.getConnection();
		ResultSet set = null;
		try {
			set = conn.createStatement().executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return set;
	}
	// 关闭资源
	public static void closeConn(Connection conn,ResultSet rs,PreparedStatement ps) {
		try {
			if(conn != null) {
				conn.close();
			}
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
