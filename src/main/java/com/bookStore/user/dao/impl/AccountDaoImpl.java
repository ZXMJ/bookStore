package com.bookStore.user.dao.impl;

import java.sql.SQLException;

import com.bookStore.common.dao.impl.BaseDaoImpl;
import com.bookStore.user.bean.Account;
import com.bookStore.user.dao.AccountDao;

public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao {
	
	@Override
	public void updateBalanceByAccountId(Integer accountId, float totalPrice) throws SQLException {
		String sql = "UPDATE ACCOUNT SET BALANCE = BALANCE - ? WHERE ACCOUNTID = ?";
		update(sql, totalPrice, accountId);
	}

	@Override
	public Float getBalanceByAccountId(Integer accountId) throws SQLException {
		String sql = "SELECT BALANCE FROM ACCOUNT WHERE ACCOUNTID = ?";
		return querySingleVal(sql, accountId);
	}

}
