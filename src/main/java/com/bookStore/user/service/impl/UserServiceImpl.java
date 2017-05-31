package com.bookStore.user.service.impl;

import java.sql.SQLException;

import com.bookStore.user.bean.UserInfo;
import com.bookStore.user.dao.UserInfoDao;
import com.bookStore.user.dao.impl.UserInfoDaoImpl;
import com.bookStore.user.service.UserService;

public class UserServiceImpl implements UserService {

	private UserInfoDao userDao =new UserInfoDaoImpl();
	@Override
	public UserInfo getUserInfoByUsername(String username) throws SQLException{
		return userDao.getUserInfoByUsername(username);
	}

}
