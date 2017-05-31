package com.bookStore.user.dao;

import java.sql.SQLException;

import com.bookStore.common.dao.BaseDao;
import com.bookStore.user.bean.UserInfo;

public interface UserInfoDao extends BaseDao<UserInfo> {

	public Integer getUserIdByUserNameAccountId(String username, Integer accountId) throws SQLException;
	
	public UserInfo getUserInfoByUsername(String username) throws SQLException;
	
}
