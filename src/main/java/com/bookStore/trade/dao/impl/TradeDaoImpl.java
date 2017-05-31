package com.bookStore.trade.dao.impl;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.bookStore.common.dao.impl.BaseDaoImpl;
import com.bookStore.trade.bean.Trade;
import com.bookStore.trade.dao.TradeDao;

public class TradeDaoImpl extends BaseDaoImpl<Trade> implements TradeDao {

	@Override
	public long insertTrade(Trade trade) throws SQLException {
		String sql = "INSERT INTO TRADE (USERID,TRADETIME) VALUES(?,?)";
		return insert(sql, trade.getUserId(),trade.getTradeTime());
	}

	@Override
	public Set<Trade> getTradesByUserId(Integer userId) throws SQLException{
		String sql = "SELECT TRADEID tradeId, USERID userId, TRADETIME tradeTime FROM TRADE WHERE USERID = ?";
		return new HashSet<Trade>(queryForList(sql, userId));
	}

}
