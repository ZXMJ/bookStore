package com.bookStore.common.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcC3P0Util {

	private static DataSource datasource;

	static {
		datasource = new ComboPooledDataSource("bookStoreC3P0");
	}

	public static Connection getCon() throws SQLException {
		return datasource.getConnection();
	}

	public static void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
