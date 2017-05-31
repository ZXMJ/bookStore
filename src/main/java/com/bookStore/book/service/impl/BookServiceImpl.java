package com.bookStore.book.service.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bookStore.book.bean.Book;
import com.bookStore.book.bean.CriteriaBook;
import com.bookStore.book.bean.ShoppingCart;
import com.bookStore.book.bean.ShoppingCartItem;
import com.bookStore.book.dao.BookDao;
import com.bookStore.book.dao.impl.BookDaoImpl;
import com.bookStore.book.service.BookService;
import com.bookStore.common.bean.Page;
import com.bookStore.common.util.ShoppingCartUtil;
import com.bookStore.trade.bean.Trade;
import com.bookStore.trade.dao.TradeDao;
import com.bookStore.trade.dao.TradeItemDao;
import com.bookStore.trade.dao.impl.TradeDaoImpl;
import com.bookStore.trade.dao.impl.TradeItemDaoImpl;
import com.bookStore.user.dao.AccountDao;
import com.bookStore.user.dao.UserInfoDao;
import com.bookStore.user.dao.impl.AccountDaoImpl;
import com.bookStore.user.dao.impl.UserInfoDaoImpl;

public class BookServiceImpl implements BookService {

	private BookDao bookDao = new BookDaoImpl();

	private UserInfoDao userInfoDao = new UserInfoDaoImpl();

	private AccountDao accountDao = new AccountDaoImpl();

	private TradeDao tradeDao = new TradeDaoImpl();

	private TradeItemDao tradeItemDao = new TradeItemDaoImpl();

	@Override
	public Page<Book> getBooks(CriteriaBook criteriaBook) throws SQLException {
		return bookDao.getPage(criteriaBook);
	}

	@Override
	public Book getBookByBookId(Integer bookId) throws SQLException {
		return bookDao.getBookByBookId(bookId);
	}

	@Override
	public Integer getBookStoreNumberByBookId(Integer bookId) throws SQLException {
		return bookDao.getBookNumberByBookId(bookId);
	}

	@Override
	public Integer getUserIdByUserNameAccountId(String username, Integer accountId) throws SQLException {
		return userInfoDao.getUserIdByUserNameAccountId(username, accountId);
	}

	@Override
	public Float getBalanceByAccountId(Integer accountId) throws SQLException {
		return accountDao.getBalanceByAccountId(accountId);
	}

	@Override
	public void cash(HttpServletRequest request, Integer accountId, Integer userId) throws SQLException {
		ShoppingCart sc = ShoppingCartUtil.getShoppingCart(request);

		Collection<ShoppingCartItem> items = sc.getItems();

		for (ShoppingCartItem sci : items) {
			bookDao.updateBookNumber(sci.getBook().getId(), sci.getQuantity());
		}

		accountDao.updateBalanceByAccountId(accountId, sc.getTotalPrice());

//		int j = 10/0;
		
		Trade trade = new Trade();
		trade.setUserId(userId);
		trade.setTradeTime(new Date(new java.util.Date().getTime()));
		long tradeId = tradeDao.insertTrade(trade);

		Object[][] args = new Object[items.size()][3];
		List<ShoppingCartItem> scis = new ArrayList<ShoppingCartItem>(items);
		for (int i = 0; i < items.size(); i++) {
			args[i][0] = scis.get(i).getBook().getId();
			args[i][1] = scis.get(i).getQuantity();
			args[i][2] = tradeId;
		}
		tradeItemDao.insertTradeItems(args);

		sc.clearCart();
	}

}
