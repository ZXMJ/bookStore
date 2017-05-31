package com.bookStore.book.service;

import com.bookStore.book.bean.ShoppingCart;

public interface ShoppingCartService {

	public void removeBook(ShoppingCart sc, int id);

	public void clearCart(ShoppingCart sc);

	public void updateShoppingItem(ShoppingCart sc, int id, int num);
}
