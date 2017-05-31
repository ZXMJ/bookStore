package com.bookStore.trade.service;

import java.sql.SQLException;
import java.util.Set;

import com.bookStore.trade.bean.TradeItem;

public interface TradeItemService {

	public Set<TradeItem> getTradeItemsByTradeId(int tradeId) throws SQLException;
	
}
