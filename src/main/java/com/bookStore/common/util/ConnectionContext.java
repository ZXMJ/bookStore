package com.bookStore.common.util;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionContext {

	private static ConnectionContext instance = new ConnectionContext();

	private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

	private ConnectionContext() {}

	public static ConnectionContext getInstance() throws SQLException {
		return instance;
	}

	public void bind(Connection con){
		threadLocal.set(con);
	}
	
	public Connection get(){
		return threadLocal.get();
	}
	
	public void remove(){
		threadLocal.remove();
	}
}
