package com.project.model.service;

import java.util.List;

import com.project.model.dto.LikeBoard;
import com.project.model.dto.RoutineBoard;

public interface LikeBoardService {

	List<LikeBoard> getBoardLike(int boardId);

	List<RoutineBoard> getUserLike(String userId);

	int likeCheck(LikeBoard info);

	void unLike(LikeBoard info);

	void likeBoard(LikeBoard info);

}
