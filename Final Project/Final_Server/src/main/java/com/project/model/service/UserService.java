package com.project.model.service;

import com.project.model.dto.User;

public interface UserService {

	User getUser(String id);

	boolean doLogin(User user);

	void doRegist(User user);

	void doUpdate(User user);

	String searchNickName(String nickName);

}
