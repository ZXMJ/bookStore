package com.bookStore.book.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

	private Map<Integer, ShoppingCartItem> map = new HashMap<Integer, ShoppingCartItem>();

	public void updateShoppingItem(int id, int quantity) {
		ShoppingCartItem sci = map.get(id);
		if (sci != null) {
			sci.setQuantity(quantity);
		}
	}

	// TODO
	public ShoppingCartItem getShoppingCartItem(int id) {
		return null;
	}

	/**
	 * @Description: 判断购物车是否有该商品
	 *
	 * @date 2017年3月29日,下午1:38:05
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param id
	 * @return
	 */
	public boolean hasBook(int id) {
		return map.containsKey(id);
	}

	/**
	 * @Description: 获取购物车详情
	 *
	 * @date 2017年3月29日,下午1:35:42
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @return
	 */
	public Collection<ShoppingCartItem> getItems() {
		return map.values();
	}

	/**
	 * @Description: 判断购物车是否为空
	 *
	 * @date 2017年3月29日,下午1:34:10
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @return
	 */
	public boolean isEmpty() {
		return map.isEmpty();
	}

	/**
	 * @Description: 删除购物车中某一项商品
	 *
	 * @date 2017年3月29日,下午1:31:04
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param id
	 */
	public void removeBook(int id) {
		map.remove(id);
	}

	/**
	 * @Description: 获取购物车总价格
	 *
	 * @date 2017年3月29日,下午1:29:07
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @return
	 */
	public float getTotalPrice() {
		float totalPrice = 0;
		for (ShoppingCartItem sci : getItems()) {
			totalPrice += sci.getTotalPrice();
		}
		return totalPrice;
	}

	/**
	 * @Description: 加入购物车
	 *
	 * @date 2017年3月29日,下午1:25:08
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param book
	 */
	public void addBook(Book book) {
		int id = book.getId();
		ShoppingCartItem sci = map.get(id);
		if (sci == null) {
			sci = new ShoppingCartItem(book);
			map.put(id, sci);
		} else {
			sci.increment();
		}
	}

	/**
	 * @Description: 清空购物车
	 *
	 * @date 2017年3月29日,下午1:24:15
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 */
	public void clearCart() {
		map.clear();
	}

	/**
	 * @Description: 获取商品总数
	 *
	 * @date 2017年3月29日,上午10:35:55
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @return
	 */
	public int getTotalNumber() {
		int total = 0;
		for (ShoppingCartItem sci : getItems()) {
			total += sci.getQuantity();
		}
		return total;
	}
}
