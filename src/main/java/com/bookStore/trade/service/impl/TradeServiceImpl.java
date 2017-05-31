package com.bookStore.trade.service.impl;

import java.sql.SQLException;
import java.util.Set;

import com.bookStore.trade.bean.Trade;
import com.bookStore.trade.dao.TradeDao;
import com.bookStore.trade.dao.impl.TradeDaoImpl;
import com.bookStore.trade.service.TradeService;

public class TradeServiceImpl implements TradeService {

	private TradeDao tradeDao = new TradeDaoImpl();
	@Override
	public Set<Trade> getTradesByUserId(int userId) throws SQLException {
		return tradeDao.getTradesByUserId(userId);
	}

}
