package com.bookStore.trade.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Set;

import org.junit.Test;

import com.bookStore.trade.bean.Trade;
import com.bookStore.trade.dao.TradeDao;

public class TradeDaoTest {

	private TradeDao tradeDao = new TradeDaoImpl();
	
	@Test
	public void testInsertTrade() throws SQLException {
		Trade trade = new Trade();
		trade.setUserId(1);
		trade.setTradeTime(new Date(new java.util.Date().getTime()));
		tradeDao.insertTrade(trade);
	}

	@Test
	public void testGetTradesByUserId() throws SQLException {
		Set<Trade> trades = tradeDao.getTradesByUserId(1);
		System.out.println(trades);
		
	}

}
