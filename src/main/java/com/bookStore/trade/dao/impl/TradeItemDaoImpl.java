package com.bookStore.trade.dao.impl;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.bookStore.common.dao.impl.BaseDaoImpl;
import com.bookStore.trade.bean.TradeItem;
import com.bookStore.trade.dao.TradeItemDao;

public class TradeItemDaoImpl extends BaseDaoImpl<TradeItem> implements TradeItemDao {

	@Override
	public void insertTradeItems(Object[][] args) throws SQLException {
		String sql = "INSERT INTO TRADEITEM (BOOKID, QUANTITY, TRADEID) VALUES (?, ?, ?)";
		batch(sql, args);
	}

	@Override
	public Set<TradeItem> getTradeItemsByTradeId(Integer tradeId) throws SQLException {
		String sql = "SELECT ITEMID itemId, BOOKID bookId, QUANTITY quantity, TRADEID tradeId FROM TRADEITEM WHERE TRADEID = ?";
		return new HashSet<TradeItem>(queryForList(sql, tradeId));
	}

}
