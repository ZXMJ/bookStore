package com.bookStore.trade.dao;

import java.sql.SQLException;
import java.util.Set;

import com.bookStore.common.dao.BaseDao;
import com.bookStore.trade.bean.TradeItem;

public interface TradeItemDao extends BaseDao<TradeItem> {
	
	public void insertTradeItems(Object args [][]) throws SQLException;
	
	public Set<TradeItem> getTradeItemsByTradeId(Integer tradeId) throws SQLException;
}
