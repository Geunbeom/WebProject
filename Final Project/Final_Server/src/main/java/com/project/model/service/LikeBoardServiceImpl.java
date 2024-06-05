package com.project.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.dao.LikeBoardDao;
import com.project.model.dao.RoutineBoardDao;
import com.project.model.dto.LikeBoard;
import com.project.model.dto.RoutineBoard;

@Service
public class LikeBoardServiceImpl implements LikeBoardService{
	
	private final LikeBoardDao dao;
	private final RoutineBoardDao boardDao;
	
	@Autowired
	public LikeBoardServiceImpl(LikeBoardDao dao, RoutineBoardDao boardDao) {
		this.dao = dao;
		this.boardDao = boardDao;
	}
	
	
	@Override
	public List<LikeBoard> getBoardLike(int boardId) {
		return dao.getBoardLike(boardId);
	}

	@Override
	public List<RoutineBoard> getUserLike(String userId) {
		return dao.getUserLike(userId);
	}


	@Override
	public int likeCheck(LikeBoard info) {
		return dao.likeCheck(info);
	}


	@Override
	public void unLike(LikeBoard info) {
		dao.unLike(info);
		boardDao.downLike(info.getBoardId());
	}


	@Override
	public void likeBoard(LikeBoard info) {
		dao.likeBoard(info);
		boardDao.upLike(info.getBoardId());
	}

}
