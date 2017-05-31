package com.bookStore.user.dao.impl;

import java.sql.SQLException;

import org.junit.Test;

import com.bookStore.user.dao.UserInfoDao;

public class UserInfoDaoTest {

	private UserInfoDao uid = new UserInfoDaoImpl();
	@Test
	public void testGetUserIdByUserNameAccountId() throws SQLException {
		Integer userId = uid.getUserIdByUserNameAccountId("aa", 2);
		if(userId!=null){
			System.out.println(userId);
			return ;
		}
		System.out.println("不存在");
	}

}
