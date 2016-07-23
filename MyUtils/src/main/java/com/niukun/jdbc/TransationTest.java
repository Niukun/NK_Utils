package com.niukun.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransationTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			//重点是这两个可能出现错误的函数放在一起
			insertUserData(conn);
			insertAddressData(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("=========== 捕获异常 ===========");
			e.printStackTrace();
			try {
				conn.rollback();
				System.out.println("=========== 事务回滚成功！ ===========");
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e3) {
				// TODO: handle exception
				e3.printStackTrace();
			}
		}
	}

	// 获取数据库连接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager
					.getConnection(
							"jdbc:sqlserver://localhost:1433;DatabaseName=EmrPatientOld",
							"sa", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void insertUserData(Connection conn) throws SQLException {
		String sql = "";
		Statement st = conn.createStatement();
		int count = st.executeUpdate(sql);
		System.out.println("用户向表中插入了" + count + "条记录！");
	}

	public static void insertAddressData(Connection conn) throws SQLException {
		String sql = "";
		Statement st = conn.createStatement();
		int count = st.executeUpdate(sql);
		System.out.println("用户向表中插入了" + count + "条记录！");
	}

}
