package com.bookStore.user.dao.impl;

import java.sql.SQLException;

import org.junit.Test;

import com.bookStore.user.dao.AccountDao;

public class AccountDaoTest {

	private AccountDao accountDao = new AccountDaoImpl();
	
	@Test
	public void testGetBalanceByAccountId() throws SQLException {
		float balacne = accountDao.getBalanceByAccountId(1);
		System.out.println(balacne);
	}

}
