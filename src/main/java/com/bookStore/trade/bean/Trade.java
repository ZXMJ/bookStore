package com.bookStore.trade.bean;

import java.sql.Date;
import java.util.Set;

public class Trade {

	private Integer tradeId;
	
	private Integer userId;
	
	private Date tradeTime;

	private Set<TradeItem> items;
	
	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	public Set<TradeItem> getItems() {
		return items;
	}

	public void setItems(Set<TradeItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", userId=" + userId + ", tradeTime=" + tradeTime + "]";
	}
	
}
