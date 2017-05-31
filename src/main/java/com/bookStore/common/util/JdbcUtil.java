package com.bookStore.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

	private static Properties pro;

	private static String className;
	private static String url;
	private static String user;
	private static String password;

	static {
		pro = new Properties();
		InputStream inStream = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			pro.load(inStream);
			className = pro.getProperty("dirverClass", "com.mysql.jdbc.Driver");
			url = pro.getProperty("url", "jdbc:mysql://localhost:3306/test");
			user = pro.getProperty("user", "root");
			password = pro.getProperty("password", "fan123");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConByDriverManager() throws ClassNotFoundException, SQLException {
		Class.forName(className);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}

	public static Connection getConByDriver() throws SQLException {
		Driver driver = new com.mysql.jdbc.Driver();
		Properties info = new Properties();
		info.put("user", pro.getProperty("user", "root"));
		info.put("password", pro.getProperty("password", "fan123"));
		Connection con = driver.connect(url, info);
		return con;
	}

	public static void close(Connection con, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
