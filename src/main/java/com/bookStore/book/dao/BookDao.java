package com.bookStore.book.dao;

import java.sql.SQLException;
import java.util.List;

import com.bookStore.book.bean.Book;
import com.bookStore.book.bean.CriteriaBook;
import com.bookStore.common.bean.Page;
import com.bookStore.common.dao.BaseDao;

public interface BookDao extends BaseDao<Book> {

	/**
	 * @Description: 通过id获取书
	 *
	 * @date 2017年3月20日,上午9:13:50
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public Book getBookByBookId(Integer id) throws SQLException;

	/**
	 * @Description: 获取搜索结果
	 *
	 * @date 2017年3月20日,上午9:14:14
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param cb
	 * @return
	 * @throws SQLException 
	 */
	public Page<Book> getPage(CriteriaBook cb) throws SQLException;

	/**
	 * @Description: 总书籍数
	 *
	 * @date 2017年3月20日,上午9:15:12
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param cb
	 * @return
	 * @throws SQLException 
	 */
	public long getTotalBookNumber(CriteriaBook cb) throws SQLException;

	/**
	 * @Description: 获取某页的书籍集合
	 *
	 * @date 2017年3月20日,上午9:15:15
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param cb
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 */
	public List<Book> getPageList(CriteriaBook cb, int pageSize) throws SQLException;
	
	/**
	 * @Description: 获取书籍数量
	 *
	 * @date 2017年3月21日,上午9:09:54
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @return
	 * @throws SQLException 
	 */
	public Integer getBookNumberByBookId(Integer id) throws SQLException;
	
	/**
	 * @Description: 出售图书后更新书籍已售和库存数量
	 *
	 * @date 2017年4月5日,下午5:48:36
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param id
	 * @param quantity
	 * @throws SQLException 
	 */
	public void updateBookNumber(Integer id, Integer quantity) throws SQLException;
}
