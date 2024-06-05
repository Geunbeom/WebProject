package com.project.model.dao;

import java.util.List;

import com.project.model.dto.FreeBoard;
import com.project.model.dto.RoutineBoard;
import com.project.model.dto.SearchCondition;

public interface FreeBoardDao {

	List getFreeBoardList();

	void createFreeBoard(FreeBoard freeBoard);

	FreeBoard getFreeBoard(int id);

	void deleteFreeBoard(int id);

	void putFreeBoard(FreeBoard freeBoard);

	void viewCntPlus(int id);

	public List<RoutineBoard> search(SearchCondition searchCondition);
}
