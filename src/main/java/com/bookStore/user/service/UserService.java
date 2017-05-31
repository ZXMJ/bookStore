package com.bookStore.user.service;

import java.sql.SQLException;

import com.bookStore.user.bean.UserInfo;

public interface UserService {

	public UserInfo getUserInfoByUsername(String username) throws SQLException;
}
