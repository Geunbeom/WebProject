package com.project.model.dao;

import java.util.List;

import com.project.model.dto.LikeBoard;
import com.project.model.dto.RoutineBoard;

public interface LikeBoardDao {

	List<LikeBoard> getBoardLike(int boardId);

	List<RoutineBoard> getUserLike(String userId);

	int likeCheck(LikeBoard info);

	void unLike(LikeBoard info);

	void likeBoard(LikeBoard info);

}
