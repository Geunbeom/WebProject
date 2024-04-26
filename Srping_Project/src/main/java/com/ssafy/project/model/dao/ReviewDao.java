package com.ssafy.project.model.dao;

import java.util.List;

import com.ssafy.project.model.dto.Review;
import com.ssafy.project.model.dto.SearchCondition;

public interface ReviewDao {
	public abstract List<Review> selectAll(int id);

	public abstract Review selectOne(int id, int idx);

	public abstract void insertReview(Review review);

	public abstract void updateReview(Review review);

	public abstract void deleteReview(int id, int idx);

	public abstract void updateViewCnt(int id, int idx);

	public abstract List<Review> searchCondition(SearchCondition searchCon);
	
}
