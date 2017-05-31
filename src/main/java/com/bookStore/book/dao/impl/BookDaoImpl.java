package com.bookStore.book.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.bookStore.book.bean.Book;
import com.bookStore.book.bean.CriteriaBook;
import com.bookStore.book.dao.BookDao;
import com.bookStore.common.bean.Page;
import com.bookStore.common.dao.impl.BaseDaoImpl;

public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {

	private int pageSize = 3;

	@Override
	public Book getBookByBookId(Integer bookId) throws SQLException {
		String sql = "SELECT id, author, title, price, publishingDate, salesAmount, storeNumber, remark FROM BOOK WHERE ID = ?";
		return query(sql, bookId);
	}

	@Override
	public Page<Book> getPage(CriteriaBook cb) throws SQLException {

		Page<Book> page = new Page<Book>(cb.getPageNo());
		page.setTotalBookNumber((int) getTotalBookNumber(cb));
		// 过滤cb中页码不合法的数据
		cb.setPageNo(page.getPageNo());
		page.setCurrentList(getPageList(cb, pageSize));
		return page;
	}

	@Override
	public long getTotalBookNumber(CriteriaBook cb) throws SQLException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(ID) FROM BOOK ");
		boolean flag = appendSql(cb, sql);
		if(flag){
			return querySingleVal(sql.toString(), cb.getMinPrice(), cb.getMaxPrice());
		}
		return querySingleVal(sql.toString());
	}


	@Override
	public List<Book> getPageList(CriteriaBook cb, int pageSize) throws SQLException {
		StringBuffer sql = new StringBuffer("SELECT id, author, title, price, publishingDate, salesAmount, storeNumber, remark FROM BOOK ");
		boolean flag = appendSql(cb, sql);
		sql.append(" LIMIT ?, ?");
		if(flag){
			return queryForList(sql.toString(), cb.getMinPrice(), cb.getMaxPrice(), (cb.getPageNo() - 1) * pageSize, pageSize);
		}
		return queryForList(sql.toString(), (cb.getPageNo() - 1) * pageSize, pageSize);
	}

	@Override
	public Integer getBookNumberByBookId(Integer bookId) throws SQLException {
		String sql = "SELECT storeNumber FROM BOOK WHERE ID = ?";
		return querySingleVal(sql, bookId);
	}

	private boolean appendSql(CriteriaBook cb, StringBuffer sql) {
		if (!(cb.getMinPrice() == 0 && cb.getMaxPrice() == Integer.MAX_VALUE)) {
			sql.append(" WHERE PRICE > ? AND PRICE < ? ");
			return true;
		}
		return false;
	}

	@Override
	public void updateBookNumber(Integer id, Integer quantity) throws SQLException {
		String sql = "UPDATE BOOK SET SALESAMOUNT = SALESAMOUNT + ?, STORENUMBER = STORENUMBER - ? WHERE ID = ?";
		update(sql, quantity, quantity, id);
	}
}
