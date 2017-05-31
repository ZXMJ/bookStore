package com.bookStore.trade.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.bookStore.trade.bean.TradeItem;
import com.bookStore.trade.dao.TradeItemDao;

public class TradeItemDaoTest {

	private TradeItemDao tradeItemDao = new TradeItemDaoImpl();

	@Test
	public void testInsertTradeItems() throws SQLException {

		List<TradeItem> tradeItems = new ArrayList<TradeItem>();
		TradeItem tradeItem1 = new TradeItem();
		tradeItem1.setBookId(1);
		tradeItem1.setQuantity(1);
		tradeItem1.setTradeId(1);
		tradeItems.add(tradeItem1);
		TradeItem tradeItem2 = new TradeItem();
		tradeItem2.setBookId(2);
		tradeItem2.setQuantity(2);
		tradeItem2.setTradeId(1);
		tradeItems.add(tradeItem2);
		Object[][] args = new Object[tradeItems.size()][3];
		for(int i = 0;i<tradeItems.size();i++){
			args[i][0] = tradeItems.get(i).getBookId();
			args[i][1] = tradeItems.get(i).getQuantity();
			args[i][2] = tradeItems.get(i).getTradeId();
		}
		tradeItemDao.insertTradeItems(args);
	}

	@Test
	public void testGetTradeItemsByTradeId() throws SQLException {
		Set<TradeItem> tradeItems = tradeItemDao.getTradeItemsByTradeId(1);
		System.out.println(tradeItems);
	}

}
