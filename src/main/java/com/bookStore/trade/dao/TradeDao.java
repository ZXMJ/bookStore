package com.bookStore.trade.dao;

import java.sql.SQLException;
import java.util.Set;

import com.bookStore.common.dao.BaseDao;
import com.bookStore.trade.bean.Trade;

public interface TradeDao extends BaseDao<Trade> {

	public long insertTrade(Trade trade) throws SQLException;
	
	public Set<Trade> getTradesByUserId(Integer userId) throws SQLException;
}
