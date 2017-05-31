package com.bookStore.book.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookStore.book.bean.Book;
import com.bookStore.book.bean.CriteriaBook;
import com.bookStore.book.bean.ShoppingCart;
import com.bookStore.book.bean.ShoppingCartItem;
import com.bookStore.book.service.BookService;
import com.bookStore.book.service.ShoppingCartService;
import com.bookStore.book.service.impl.BookServiceImpl;
import com.bookStore.book.service.impl.ShoppingCartServiceImpl;
import com.bookStore.common.bean.Page;
import com.bookStore.common.util.FormatUtil;
import com.bookStore.common.util.ShoppingCartUtil;
import com.google.gson.Gson;

public class BookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private BookService bookService = new BookServiceImpl();

	private ShoppingCartService scService = new ShoppingCartServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		try {
			if (methodName == null) {
				return;
			}
			Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	protected void cash(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String username = request.getParameter("username");

		int accountId = getAttr(request, "accountId");

		StringBuffer message = null;

		Integer userId = -1;
		if (username != null && !"".equals(username) && accountId != -1) {
			userId = bookService.getUserIdByUserNameAccountId(username, accountId);
		} else {
			message = new StringBuffer("用户名或者卡号不合法！");
			backCashPage(request, response, message.toString());
			return;
		}
		if (userId == null || userId == -1) {
			message = new StringBuffer("用户名卡号不匹配！");
			backCashPage(request, response, message.toString());
			return;
		}
		ShoppingCart sc = ShoppingCartUtil.getShoppingCart(request);

		float totalPrice = sc.getTotalPrice();

		float balance = bookService.getBalanceByAccountId(accountId);

		if (totalPrice > balance) {
			message = new StringBuffer("余额不足！");
			backCashPage(request, response, message.toString());
			return;
		}

		Collection<ShoppingCartItem> items = sc.getItems();

		for (ShoppingCartItem sci : items) {
			int num = sci.getQuantity();
			long storeNum = bookService.getBookStoreNumberByBookId(sci.getBook().getId());
			if (num > storeNum) {
				if (message == null)
					message = new StringBuffer(sci.getBook().getTitle() + ", ");
				else
					message.append(sci.getBook().getTitle() + ", ");
			}
		}

		if (message != null) {
			String mess = message.substring(0, message.length() - 2) + "库存不足";
			backCashPage(request, response, mess);
			return;
		}

		bookService.cash(request, accountId, userId);

		response.sendRedirect("index.jsp");
	}

	public void backCashPage(HttpServletRequest request, HttpServletResponse response, String message)
			throws ServletException, IOException {
		request.setAttribute("message", message);
		request.getRequestDispatcher("/WEB-INF/book/cash.jsp").forward(request, response);
	}

	protected void changeItemNumber(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int id = getAttr(request, "id");
		int num = getAttr(request, "num");
		ShoppingCart sc = ShoppingCartUtil.getShoppingCart(request);
		scService.updateShoppingItem(sc, id, num);

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("totalPrice", sc.getTotalPrice());
		data.put("totalNumber", sc.getTotalNumber());

		Gson gson = new Gson();
		String json = gson.toJson(data);

		response.setContentType("text/javascript");
		response.getWriter().print(json);
	}

	protected void clearShoppingCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		ShoppingCart sc = ShoppingCartUtil.getShoppingCart(request);
		scService.clearCart(sc);
		request.getRequestDispatcher("bookServlet?method=toCommonPage&page=cart").forward(request, response);
	}

	protected void delItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int id = getAttr(request, "id");
		ShoppingCart sc = ShoppingCartUtil.getShoppingCart(request);
		scService.removeBook(sc, id);
		request.getRequestDispatcher("bookServlet?method=toCommonPage&page=cart").forward(request, response);
	}

	protected void toCommonPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String page = request.getParameter("page");
		request.getRequestDispatcher("/WEB-INF/book/" + page + ".jsp").forward(request, response);
		return;
	}

	protected void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		int id = getAttr(request, "id");
		if (id != -1) {
			ShoppingCart sc = ShoppingCartUtil.getShoppingCart(request);
			Book book = bookService.getBookByBookId(id);
			if (book != null) {
				sc.addBook(book);
				request.setAttribute("title", book.getTitle());
				request.getRequestDispatcher("bookServlet?method=getBooks").forward(request, response);
				return;
			}
			response.sendRedirect(request.getContextPath() + "/error/bookError.jsp");
			return;
		}
	}

	protected void getBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int id = getAttr(request, "id");
		if (id != -1) {
			Book book = bookService.getBookByBookId(id);
			if (book != null) {
				request.setAttribute("book", book);
				request.getRequestDispatcher("/WEB-INF/book/book.jsp").forward(request, response);
				return;
			}
		}
		response.sendRedirect(request.getContextPath() + "/error/bookError.jsp");
	}

	protected void getBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String minPriceStr = request.getParameter("minPrice");
		String maxPriceStr = request.getParameter("maxPrice");
		String pageNoStr = request.getParameter("pageNo");
		float minPrice = FormatUtil.parseFloat(minPriceStr, 0);
		float maxPrice = FormatUtil.parseFloat(maxPriceStr, Integer.MAX_VALUE);
		int pageNo = FormatUtil.parseInt(pageNoStr, 1);
		CriteriaBook cb = new CriteriaBook(minPrice, maxPrice, pageNo);
		try {
			Page<Book> bookPage = bookService.getBooks(cb);
			request.setAttribute("bookPage", bookPage);
			request.getRequestDispatcher("/WEB-INF/book/books.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private int getAttr(HttpServletRequest request, String attrName) {
		String attrStr = request.getParameter(attrName);
		return FormatUtil.parseInt(attrStr, -1);
	}
}
