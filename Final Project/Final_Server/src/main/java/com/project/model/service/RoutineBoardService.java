package com.project.model.service;

import java.util.List;

import com.project.model.dto.RoutineBoard;
import com.project.model.dto.SearchCondition;

public interface RoutineBoardService {

	List getRoutineBoardList();

	void createRoutineBoard(RoutineBoard routineBoard);

	RoutineBoard getRoutineBoard(int id);

	void deleteRoutineBoard(int id);

	void putRoutineBoard(RoutineBoard routineBoard);

	List<RoutineBoard> search(SearchCondition searchCondition);

}
