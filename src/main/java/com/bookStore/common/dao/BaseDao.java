package com.bookStore.common.dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T> {
	
	/**
	 * @Description: 插入数据后返回主键
	 *
	 * @date 2017年3月17日,上午8:23:56
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	 <V> V insert(String sql, Object... args) throws SQLException;

	/**
	 * @Description: 修改信息
	 *
	 * @date 2017年3月17日,上午8:24:23
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param sql
	 * @param args
	 * @throws SQLException
	 */
	void update(String sql, Object... args) throws SQLException;

	/**
	 * @Description: 删除数据
	 *
	 * @date 2017年3月17日,上午8:25:33
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param sql
	 * @param args
	 * @throws SQLException
	 */
	void delete(String sql, Object... args) throws SQLException;

	/**
	 * @Description: 查询，返回一个对象
	 *
	 * @date 2017年3月17日,上午8:25:49
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	T query(String sql, Object... args) throws SQLException;

	/**
	 * @Description: 查询，返回一个属性
	 *
	 * @date 2017年3月17日,上午8:26:05
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	<V> V querySingleVal(String sql, Object... args) throws SQLException;

	/**
	 * @Description: 查询，返回一个集合
	 *
	 * @date 2017年3月17日,上午8:26:20
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	List<T> queryForList(String sql, Object... args) throws SQLException;

	/**
	 * @Description: 批量操作
	 *
	 * @date 2017年3月17日,上午8:26:38
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param sql
	 * @param args
	 * @throws SQLException 
	 */
	void batch(String sql, Object[]... args) throws SQLException;
}
