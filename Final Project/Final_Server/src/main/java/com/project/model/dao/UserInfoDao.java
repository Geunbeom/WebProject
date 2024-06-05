package com.project.model.dao;

import java.util.List;

import com.project.model.dto.UserInfo;

public interface UserInfoDao {

	UserInfo getInfo(String id);

	void registInfo(UserInfo info);

	void mileageModify(UserInfo info);

	void expModify(UserInfo info);

	void rateUp(UserInfo info);

	List getRankList();

	void highscoreModify(UserInfo info);

	List highscoreRank();
}
