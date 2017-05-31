package com.bookStore.book.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.bookStore.book.bean.Book;
import com.bookStore.book.bean.CriteriaBook;
import com.bookStore.common.bean.Page;

public interface BookService {

	/**
	 * @Description: 获取书籍的搜索结果
	 *
	 * @date 2017年3月22日,上午9:57:53
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param criteriaBook
	 * @return
	 * @throws SQLException 
	 */
	public Page<Book> getBooks(CriteriaBook criteriaBook) throws SQLException;
	
	/**
	 * @Description: 通过id获取书籍
	 *
	 * @date 2017年3月27日,下午4:33:41
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public Book getBookByBookId(Integer bookId) throws SQLException;
	
	/**
	 * @Description: 通过id获取书籍库存
	 *
	 * @date 2017年4月6日,上午9:40:07
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param bookId
	 * @return
	 * @throws SQLException
	 */
	public Integer getBookStoreNumberByBookId(Integer bookId) throws SQLException;
	
	
	/**
	 * @Description: 通过用户名，卡号获取userId
	 *
	 * @date 2017年4月6日,上午9:29:02
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param username
	 * @param accountId
	 * @return
	 * @throws SQLException
	 */
	public Integer getUserIdByUserNameAccountId(String username, Integer accountId) throws SQLException;
	
	/**
	 * @Description: 通过userId获取余额
	 *
	 * @date 2017年4月6日,上午9:30:46
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param accountId
	 * @return
	 * @throws SQLException
	 */
	public Float getBalanceByAccountId(Integer accountId) throws SQLException;
	
	
	/**
	 * @Description: 结账时相关数据更新
	 *
	 * @date 2017年4月6日,上午10:49:36
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param request
	 * @throws SQLException
	 */
	public void cash(HttpServletRequest request,Integer accountId, Integer userId) throws SQLException;
	
}
