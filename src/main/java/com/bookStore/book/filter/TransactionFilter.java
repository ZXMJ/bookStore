package com.bookStore.book.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.bookStore.common.util.ConnectionContext;
import com.bookStore.common.util.JdbcC3P0Util;

public class TransactionFilter implements Filter {

    public TransactionFilter() {
    }

    public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Connection con = null;
		try {
			con =  JdbcC3P0Util.getCon();
			con.setAutoCommit(false);
			ConnectionContext.getInstance().bind(con);
			
			chain.doFilter(request, response);
			con.commit();
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			JdbcC3P0Util.close(con);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
