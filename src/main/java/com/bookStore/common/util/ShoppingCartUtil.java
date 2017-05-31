package com.bookStore.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bookStore.book.bean.ShoppingCart;

public class ShoppingCartUtil {

	public static ShoppingCart getShoppingCart(HttpServletRequest request){
		HttpSession session = request.getSession();
		ShoppingCart sc = (ShoppingCart) session.getAttribute("shoppingCart");
		if(sc == null){
			sc = new ShoppingCart();
			session.setAttribute("shoppingCart", sc);
		}
		return sc;
	}
}
