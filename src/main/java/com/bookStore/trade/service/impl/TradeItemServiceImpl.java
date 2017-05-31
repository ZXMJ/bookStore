package com.bookStore.trade.service.impl;

import java.sql.SQLException;
import java.util.Set;

import com.bookStore.trade.bean.TradeItem;
import com.bookStore.trade.dao.TradeItemDao;
import com.bookStore.trade.dao.impl.TradeItemDaoImpl;
import com.bookStore.trade.service.TradeItemService;

public class TradeItemServiceImpl implements TradeItemService {

	private TradeItemDao tradeItemDao = new TradeItemDaoImpl();
	@Override
	public Set<TradeItem> getTradeItemsByTradeId(int tradeId) throws SQLException {
		return tradeItemDao.getTradeItemsByTradeId(tradeId);
	}

}
