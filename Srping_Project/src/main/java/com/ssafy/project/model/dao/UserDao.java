package com.ssafy.project.model.dao;

import java.util.List;

import com.ssafy.project.model.dto.User;

public interface UserDao {

	void regist(User user);

	List<User> getUserList();

	User findUser(String id);
	
}
