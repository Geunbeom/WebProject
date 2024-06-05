package com.project.model.dao;

import java.util.List;

import com.project.model.dto.RoutineBoard;
import com.project.model.dto.SearchCondition;

public interface RoutineBoardDao {

	public List getRoutineBoardList();

	public void createRoutineBoard(RoutineBoard routineBoard);

	public RoutineBoard getRoutineBoard(int id);

	public void deleteRoutineBoard(int id);

	public void putRoutineBoard(RoutineBoard routineBoard);

	public void viewCntPlus(int id);

	public void upLike(int boardId);

	public void downLike(int boardId);
	
	public List<RoutineBoard> search(SearchCondition searchCondition);

}
