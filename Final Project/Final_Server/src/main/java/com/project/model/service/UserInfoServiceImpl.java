package com.project.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.dao.UserInfoDao;
import com.project.model.dto.Rank;
import com.project.model.dto.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	private final UserInfoDao dao;
	
	@Autowired
	public UserInfoServiceImpl(UserInfoDao dao) {
		this.dao = dao;
	}

	@Override
	public UserInfo getInfo(String id) {
		return dao.getInfo(id);
	}

	@Override
	public void registInfo(UserInfo info) {
		dao.registInfo(info);
	}

	@Override
	public void mileageModify(UserInfo info) {
		dao.mileageModify(info);
	}

	@Override
	public UserInfo expModify(UserInfo info) {
		dao.expModify(info);
		return dao.getInfo(info.getId());
	}

	@Override
	public void rateUp(UserInfo info) {
		dao.rateUp(info);
	}

	@Override
	public List getRankList() {
		List list = dao.getRankList();
		if (list.size() < 10) {
			for (int i=list.size()+1; i<=10; i++) {
				list.add(new Rank("none", 0, 0));
			}
		}
		return list;
	}

	@Override
	public void highscoreModify(UserInfo info) {
		dao.highscoreModify(info);
	}

	@Override
	public List highscoreRank() {
		List list = dao.highscoreRank();
		if (list.size() < 10) {
			for (int i=list.size()+1; i<=10; i++) {
				list.add(new UserInfo("none", 0, 0, 0, 0));
			}
		}
		return list;
	}
	

}
