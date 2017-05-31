package com.bookStore.user.dao;

import java.sql.SQLException;

import com.bookStore.common.dao.BaseDao;
import com.bookStore.user.bean.Account;

public interface AccountDao extends BaseDao<Account> {

	public void updateBalanceByAccountId(Integer accountId, float totalPrice) throws SQLException;
	
	public Float getBalanceByAccountId(Integer accountId) throws SQLException;
}
