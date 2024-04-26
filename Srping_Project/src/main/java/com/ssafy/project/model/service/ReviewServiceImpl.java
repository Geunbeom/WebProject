package com.ssafy.project.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.project.model.dao.ReviewDao;
import com.ssafy.project.model.dto.Review;
import com.ssafy.project.model.dto.SearchCondition;

@Service
public class ReviewServiceImpl implements ReviewService {

	private final ReviewDao repository;
	
	@Autowired
	private ReviewServiceImpl(ReviewDao repository) {
		this.repository = repository;
	}

	@Override
	public List<Review> getList(int id) {
		return repository.selectAll(id);
	}

	@Override
	public Review getReview(int id, int idx) {
		repository.updateViewCnt(id, idx);
		return repository.selectOne(id, idx);
	}

	@Override
	public void writeReview(Review review) {
		repository.insertReview(review);

	}

	@Override
	public void modifyReview(Review review) {
		repository.updateReview(review);
	}

	@Override
	public void removeReview(int id, int idx) {
		repository.deleteReview(id, idx);
	}

	@Override
	public List<Review> searchByCon(SearchCondition searchCon) {
		return repository.searchCondition(searchCon);
	}

}
