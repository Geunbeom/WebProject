package com.ssafy.project.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.project.model.dao.UserDao;
import com.ssafy.project.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserDao uDao;
	
	@Autowired
	public UserServiceImpl(UserDao uDao) {
		this.uDao = uDao;
	}
	
	@Override
	public void regist(User user) {
		uDao.regist(user);
	}

	@Override
	public List<User> getUserList() {
		return uDao.getUserList();
	}

	@Override
	public User searchUser(String id) {
		return uDao.findUser(id);
	}
	
	
}
