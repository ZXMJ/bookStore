package com.bookStore.common.dao.impl;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.bookStore.book.bean.Book;
import com.bookStore.book.dao.impl.BookDaoImpl;
import com.bookStore.common.dao.BaseDao;

public class BaseDaoImplTest {

	BaseDao<Book> basedao = new BookDaoImpl();

	@Test
	public void testInsertStringT() throws SQLException {
		String sql = "INSERT INTO BOOK (AUTHOR,TITLE,PRICE,PUBLISHINGDATE,SALESAMOUNT,STORENUMBER,REMARK) "
				+ "VALUES (?,?,?,?,?,?,?)";
		basedao.insert(sql, "kb","maba",24F,new Date(),1,9,"better");
		basedao.insert(sql, "jmas","king",23F,new Date(),1,9,"better");
		basedao.insert(sql, "wade","shark",3F,new Date(),1,9,"good");
		basedao.insert(sql, "kd","kill",35F,new Date(),1,9,"better");
	}

	@Test
	public void testUpdate() throws SQLException {
		String sql = "UPDATE BOOK SET ID = ? WHERE ID = ?";
		basedao.update(sql, 2, 3);
	}

	@Test
	public void testDelete() throws SQLException {
		String sql = "DELETE FROM BOOK WHERE ID = ?";
		basedao.delete(sql, 1);
	}

	@Test
	public void testQuery() throws SQLException {
		String sql = "SELECT id, author, title, price, publishingDate, salesAmount, storeNumber, remark FROM BOOK WHERE ID = ?";
		Book book = basedao.query(sql, 1);
		System.out.println(book);
	}

	@Test
	public void testQuerySingleVal() throws SQLException {
		String sql = "SELECT COUNT(ID) FROM BOOK";
		long num = basedao.querySingleVal(sql);
		System.out.println(num);
	}

	@Test
	public void testQueryForList() throws SQLException {
		String sql = "SELECT id, author, title, price, publishingDate, salesAmount, storeNumber, remark FROM BOOK";
		List<Book> books = basedao.queryForList(sql);
		System.out.println(books);
	}

	@Test
	public void testBatch() throws SQLException {
		String sql = "UPDATE BOOK SET PRICE = PRICE + ? WHERE ID = ?";
		basedao.batch(sql, new Object[]{10,1}, new Object[]{20,2});
	}

}
