package com.bookStore.user.bean;

import java.util.Set;

import com.bookStore.trade.bean.Trade;

public class UserInfo {

	private Integer userId;
	
	private String username;
	
	private Integer accountId;

	private Set<Trade> trades;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Set<Trade> getTrades() {
		return trades;
	}

	public void setTrades(Set<Trade> trades) {
		this.trades = trades;
	}
	
}
