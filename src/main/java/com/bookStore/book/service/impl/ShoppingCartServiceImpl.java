package com.bookStore.book.service.impl;

import com.bookStore.book.bean.ShoppingCart;
import com.bookStore.book.service.ShoppingCartService;

public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Override
	public void removeBook(ShoppingCart sc, int id) {
		sc.removeBook(id);
	}

	@Override
	public void clearCart(ShoppingCart sc) {
		sc.clearCart();
	}

	@Override
	public void updateShoppingItem(ShoppingCart sc, int id, int num) {
		sc.updateShoppingItem(id, num);
	}

}
