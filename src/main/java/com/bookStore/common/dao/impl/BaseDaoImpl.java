package com.bookStore.common.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.bookStore.common.dao.BaseDao;
import com.bookStore.common.util.ConnectionContext;
import com.bookStore.common.util.ReflectUtil;

public class BaseDaoImpl<T> implements BaseDao<T> {

	private QueryRunner qr = new QueryRunner();

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		clazz = (Class<T>) ReflectUtil.getSuperClassGenricType(getClass());
	}

	/**
	 * @date 2017年3月17日,上午8:41:45
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @see com.bookStore.dao.Dao#insert(java.lang.String, java.lang.Object[])
	 */
	@Override
	public <V> V insert(String sql, Object... args) throws SQLException {
		Connection con = ConnectionContext.getInstance().get();
		return qr.insert(con, sql, new ScalarHandler<V>(), args);
	}

	/**
	 * @date 2017年3月17日,上午8:41:41
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @see com.bookStore.dao.Dao#update(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void update(String sql, Object... args) throws SQLException {
		Connection con = ConnectionContext.getInstance().get();
		qr.update(con, sql, args);
	}

	/**
	 * @date 2017年3月17日,上午8:41:38
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @see com.bookStore.dao.Dao#delete(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void delete(String sql, Object... args) throws SQLException {
		Connection con = ConnectionContext.getInstance().get();
		qr.update(con, sql, args);
	}

	/**
	 * @date 2017年3月17日,上午8:41:36
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @see com.bookStore.dao.Dao#query(java.lang.String, java.lang.Object[])
	 */
	@Override
	public T query(String sql, Object... args) throws SQLException {
		Connection con = ConnectionContext.getInstance().get();
		return qr.query(con, sql, new BeanHandler<T>(clazz), args);
	}

	/**
	 * @date 2017年3月17日,上午8:41:33
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @see com.bookStore.dao.Dao#querySingleVal(java.lang.String,
	 *      java.lang.Object[])
	 */
	@Override
	public <V> V querySingleVal(String sql, Object... args) throws SQLException {
		Connection con = ConnectionContext.getInstance().get();
		return qr.query(con, sql, new ScalarHandler<V>(), args);
	}

	/**
	 * @date 2017年3月17日,上午8:41:29
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @see com.bookStore.dao.Dao#queryForList(java.lang.String,
	 *      java.lang.Object[])
	 */
	@Override
	public List<T> queryForList(String sql, Object... args) throws SQLException {
		Connection con = ConnectionContext.getInstance().get();
		return qr.query(con, sql, new BeanListHandler<T>(clazz), args);
	}

	/**
	 * @date 2017年3月17日,上午8:41:24
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @see com.bookStore.dao.Dao#batch(java.lang.String, java.lang.Object[][])
	 */
	@Override
	public void batch(String sql, Object[]... args) throws SQLException {
		Connection con = ConnectionContext.getInstance().get();
		qr.batch(con, sql, args);
	}

}
