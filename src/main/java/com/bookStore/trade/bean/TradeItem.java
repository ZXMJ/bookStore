package com.bookStore.trade.bean;

import com.bookStore.book.bean.Book;

public class TradeItem {

	private Integer itemId;
	
	private Integer bookId;
	
	private Integer quantity;
	
	private Integer tradeId;
	
	private Book book;
	
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "TradeItem [itemId=" + itemId + ", bookId=" + bookId + ", quantity=" + quantity + ", tradeId=" + tradeId
				+ "]";
	}
	
}
