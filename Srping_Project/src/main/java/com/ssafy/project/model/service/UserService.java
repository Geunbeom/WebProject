package com.ssafy.project.model.service;

import java.util.List;

import com.ssafy.project.model.dto.User;

public interface UserService  {

	void regist(User user);

	List<User> getUserList();

	User searchUser(String id);

}
