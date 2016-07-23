package com.niukun.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryTest {
	public static void main(String[] args) throws Exception {
		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection conn = cf.makeConnection();
		System.out.println(conn.getAutoCommit());
	}
}
