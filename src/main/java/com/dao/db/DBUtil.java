package com.dao.db;

import java.sql.*;
import java.util.Map;

/**
 * Title: DBUtil.java Description: 数据库连接工具类
 * 
 * @author 龚梁钧
 * @created 2016年12月19日 上午9:50:18
 */
public class DBUtil {
	private static Connection connection = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	/**
	 * @discription 获取连接对象的方法
	 * @author 龚梁钧
	 * @created 2016年12月19日 上午9:50:57
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql:///sakila?characterEncoding=utf-8", "root",
					"glj950618");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @discription 获取预编译对象的方法
	 * @author 龚梁钧
	 * @created 2016年12月19日 上午9:51:24
	 * @param sql
	 * @return
	 */
	public static PreparedStatement getPreparedStatement(String sql) {
		try {
			ps = getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	/**
	 * @discription 绑定参数方法
	 * @author 龚梁钧
	 * @created 2016年12月19日 上午9:51:50
	 * @param ps
	 * @param params
	 */
	public static void bindParams(PreparedStatement ps, Object[] params) {
		for (int i = 0; i < params.length; i++) {
			// 数组下标 0
			// 参数 1
			try {
				ps.setObject(i + 1, params[i]);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @discription 执行Sql语句返回受影响的行数
	 * @author 龚梁钧
	 * @created 2016年12月19日 上午9:52:30
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int executeUpdate(String sql, Object[] params) {
		int count = 0;
		ps = getPreparedStatement(sql);
		bindParams(ps, params);
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return count;

	}
	/*
	 * public static void alterTableCascade(int n){ Connection conn =
	 * DBUtil.getConnection(); PreparedStatement pstm = null; ResultSet rs =
	 * null; String sql1 = "SET FOREIGN_KEY_CHECKS = "+n; try { pstm =
	 * conn.prepareStatement(sql1); rs = pstm.executeQuery(); } catch
	 * (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }finally{ closeAll(); } }
	 */

	/**
	 * @discription 在此输入一句话描述作用
	 * @author 龚梁钧
	 * @created 2016年12月19日 下午2:43:50
	 * @param sql1
	 *            去掉外键关联
	 * @param sql2
	 * @param sql3添加外键关联
	 * @return
	 */
	public static int executeUpdateTwo(String sql1, String sql2, String sql3) {
		int count = 0;
		Connection conn = DBUtil.getConnection();
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql1);
			count = statement.executeUpdate(sql2);
			statement.executeUpdate(sql3);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return count;

	}

	/**
	 * @discription 获取结果集
	 * @author 龚梁钧
	 * @created 2016年12月19日 上午9:52:50
	 * @param sql
	 * @param params
	 * @return
	 */
	public static ResultSet executeQuery(String sql, Object[] params) {
		ps = getPreparedStatement(sql);
		if (params != null) {
			bindParams(ps, params);
		}
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * @discription 获取结果集
	 * @author 龚梁钧
	 * @created 2016年12月19日 上午9:53:11
	 * @param sql
	 * @return
	 */
	public static ResultSet getResultSet(String sql) {
		ps = getPreparedStatement(sql);
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * @discription 关闭所有资源的方法
	 * @author 龚梁钧
	 * @created 2016年12月19日 上午9:53:25
	 */
	public static void closeAll() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
