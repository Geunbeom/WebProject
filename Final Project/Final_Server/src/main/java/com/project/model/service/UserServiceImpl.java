package com.project.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.dao.UserDao;
import com.project.model.dto.User;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserDao dao;
	
	@Autowired
	public UserServiceImpl(UserDao dao) {
		this.dao = dao;
	}
	
	@Override
	public User getUser(String id) {
		return dao.getUser(id);
	}

	@Override
	public boolean doLogin(User user) {
		User loginUser = dao.getUser(user.getId());
		if (loginUser == null || !loginUser.getPassword().equals(user.getPassword()))
			return false;
		else return true;
	}

	@Override
	public void doRegist(User user) {
		dao.doRegist(user);
	}

	@Override
	public void doUpdate(User user) {
		dao.doUpdate(user);
	}

	@Override
	public String searchNickName(String nickName) {
		return dao.searchNickName(nickName);
	}

}
