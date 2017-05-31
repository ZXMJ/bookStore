package com.bookStore.book.bean;

public class ShoppingCartItem {

	private Book book;
	private int quantity;
	
	public ShoppingCartItem(Book book) {
		this.book = book;
		quantity = 1;
	}
	
	public ShoppingCartItem(Book book, int quantity) {
		this.book = book;
		this.quantity = quantity;
	}

	
	/**
	 * @Description: 获取该商品的总价
	 *
	 * @date 2017年3月29日,上午9:21:44
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @return
	 */
	public float getTotalPrice(){
		return book.getPrice()*quantity;
	}
	/**
	 * @Description: 该商品数量加1
	 *
	 * @date 2017年3月29日,上午9:20:47
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	public void increment(){
		quantity++;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
