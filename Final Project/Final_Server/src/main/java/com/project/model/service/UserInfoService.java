package com.project.model.service;

import java.util.List;

import com.project.model.dto.UserInfo;

public interface UserInfoService {

	UserInfo getInfo(String id);

	void registInfo(UserInfo info);

	void mileageModify(UserInfo info);

	UserInfo expModify(UserInfo info);

	void rateUp(UserInfo afterUser);

	List getRankList();

	void highscoreModify(UserInfo info);

	List highscoreRank();



}
