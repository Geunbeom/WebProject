package com.project.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.dao.RoutineBoardDao;
import com.project.model.dto.RoutineBoard;
import com.project.model.dto.SearchCondition;

@Service
public class RoutineBoardServiceImpl implements RoutineBoardService{
	
	private final RoutineBoardDao dao;
	
	@Autowired
	public RoutineBoardServiceImpl(RoutineBoardDao dao) {
		this.dao = dao;
	}

	@Override
	public List getRoutineBoardList() {
		return dao.getRoutineBoardList();
	}

	@Override
	public void createRoutineBoard(RoutineBoard routineBoard) {
		dao.createRoutineBoard(routineBoard);
	}

	@Override
	public RoutineBoard getRoutineBoard(int id) {
		dao.viewCntPlus(id);
		return dao.getRoutineBoard(id);
	}

	@Override
	public void deleteRoutineBoard(int id) {
		dao.deleteRoutineBoard(id);
	}

	@Override
	public void putRoutineBoard(RoutineBoard routineBoard) {
		dao.putRoutineBoard(routineBoard);
	}
	
	@Override
	public List<RoutineBoard> search(SearchCondition searchCondition) {
		return dao.search(searchCondition);
	}

}
