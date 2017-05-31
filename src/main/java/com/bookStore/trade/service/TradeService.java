package com.bookStore.trade.service;

import java.sql.SQLException;
import java.util.Set;

import com.bookStore.trade.bean.Trade;

public interface TradeService {

	public Set<Trade> getTradesByUserId(int userId) throws SQLException;
}
