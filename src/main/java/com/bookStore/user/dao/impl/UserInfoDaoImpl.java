package com.bookStore.user.dao.impl;

import java.sql.SQLException;

import com.bookStore.common.dao.impl.BaseDaoImpl;
import com.bookStore.user.bean.UserInfo;
import com.bookStore.user.dao.UserInfoDao;

public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo> implements UserInfoDao {

	@Override
	public Integer getUserIdByUserNameAccountId(String username, Integer accountId) throws SQLException {
		String sql="SELECT USERID FROM USERINFO WHERE USERNAME = ? AND ACCOUNTID = ?";
		return querySingleVal(sql, username, accountId);
	}

	@Override
	public UserInfo getUserInfoByUsername(String username) throws SQLException{
		String sql="SELECT USERID,USERNAME,ACCOUNTID FROM USERINFO WHERE USERNAME = ?";
		return query(sql, username);
	}

}
