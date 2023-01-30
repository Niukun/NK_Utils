package com.niukun.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC {
	public static void main(String[] args) {
		Connection connection = getConnection();
		System.out.println(connection);
	}

	// 获取数据库连接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/xy?useSSL=false&serverTimezone=GMT%2B8",
							"root", "Niukun@12");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 插入
	public static void insert() {
		Connection conn = getConnection();
		try {
			String sql = "";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("用户向表中插入了" + count + "条记录！");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 查询
	public static void query() {
		Connection conn = getConnection();
		ResultSet rs = null;
		try {
			String sql = "";
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);
			int count = 0;
			while (rs.next()) {
				System.out.print(rs.getString(1) + " + ");
				System.out.println(rs.getString(3));
				count++;
			}
			System.out.println("用户向表中查询到" + count + "条记录！");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 更新
	public static void update() {
		Connection conn = getConnection();
		ResultSet rs = null;
		try {
			String sql = "";
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);
			int count = 0;
			while (rs.next()) {
				System.out.print(rs.getString(1) + " + ");
				System.out.println(rs.getString(3));
				count++;
			}
			System.out.println("用户向表中更新了" + count + "条记录！");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 删除
	public static void delete() {
		Connection conn = getConnection();
		ResultSet rs = null;
		try {
			String sql = "";
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);
			int count = 0;
			while (rs.next()) {
				System.out.print(rs.getString(1) + " + ");
				System.out.println(rs.getString(3));
				count++;
			}
			System.out.println("用户向表中删除了" + count + "条记录！");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
