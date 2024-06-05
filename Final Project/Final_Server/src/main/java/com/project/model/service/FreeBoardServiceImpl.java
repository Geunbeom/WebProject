package com.project.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.dao.FreeBoardDao;
import com.project.model.dto.FreeBoard;
import com.project.model.dto.RoutineBoard;
import com.project.model.dto.SearchCondition;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {
	
	private final FreeBoardDao dao;
	
	@Autowired
	public FreeBoardServiceImpl(FreeBoardDao dao) {
		this.dao = dao;
	}

	@Override
	public List getFreeBoardList() {
		return dao.getFreeBoardList();
	}

	@Override
	public void createFreeBoard(FreeBoard freeBoard) {
		dao.createFreeBoard(freeBoard);
	}

	@Override
	public FreeBoard getFreeBoard(int id) {
		dao.viewCntPlus(id);
		return dao.getFreeBoard(id);
	}

	@Override
	public void deleteFreeBoard(int id) {
		dao.deleteFreeBoard(id);
	}

	@Override
	public void putFreeBoard(FreeBoard freeBoard) {
		dao.putFreeBoard(freeBoard);
	}

	@Override
	public List<RoutineBoard> search(SearchCondition searchCondition) {
		return dao.search(searchCondition);
	}
}
