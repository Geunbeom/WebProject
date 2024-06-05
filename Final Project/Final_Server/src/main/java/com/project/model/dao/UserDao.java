package com.project.model.dao;

import com.project.model.dto.User;

public interface UserDao {

	User getUser(String id);

	void doRegist(User user);

	String searchNickName(String nickName);

	void doUpdate(User user);

}
