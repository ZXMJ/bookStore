package com.bookStore.user.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookStore.book.bean.Book;
import com.bookStore.book.service.BookService;
import com.bookStore.book.service.impl.BookServiceImpl;
import com.bookStore.trade.bean.Trade;
import com.bookStore.trade.bean.TradeItem;
import com.bookStore.trade.service.TradeItemService;
import com.bookStore.trade.service.TradeService;
import com.bookStore.trade.service.impl.TradeItemServiceImpl;
import com.bookStore.trade.service.impl.TradeServiceImpl;
import com.bookStore.user.bean.UserInfo;
import com.bookStore.user.service.UserService;
import com.bookStore.user.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();

	private TradeService tradeService = new TradeServiceImpl();

	private TradeItemService tradeItemService = new TradeItemServiceImpl();

	private BookService bookService = new BookServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		UserInfo userInfo = null;
		if (username != null && !username.trim().equals("")) {
			try {
				userInfo = userService.getUserInfoByUsername(username);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (userInfo != null) {
			Set<Trade> trades = null;
			try {
				trades = tradeService.getTradesByUserId(userInfo.getUserId());
				userInfo.setTrades(trades);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (trades != null && trades.size() > 0) {
				Set<TradeItem> tradeItems = null;
				for (Trade trade : trades) {
					try {
						tradeItems = tradeItemService.getTradeItemsByTradeId(trade.getTradeId());
						trade.setItems(tradeItems);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					if (tradeItems != null && tradeItems.size() > 0) {
						for (TradeItem tradeItem : tradeItems) {
							try {
								Book book = bookService.getBookByBookId(tradeItem.getBookId());
								tradeItem.setBook(book);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}

		}
		
		request.setAttribute("userInfo", userInfo);
		request.getRequestDispatcher("/WEB-INF/book/trades.jsp").forward(request, response);
	}
}
