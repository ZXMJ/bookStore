package com.bookStore.common.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.bookStore.common.util.JdbcC3P0Util;

public class JdbcC3P0UtilTest {

	@Test
	public void testGetCon() throws SQLException {
		Connection con = JdbcC3P0Util.getCon();
		System.out.println(con);
		con.close();
	}

}
