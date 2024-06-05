package com.project.model.service;

import java.util.List;

import com.project.model.dto.FreeBoard;
import com.project.model.dto.RoutineBoard;
import com.project.model.dto.SearchCondition;

public interface FreeBoardService {

	List getFreeBoardList();

	void createFreeBoard(FreeBoard freeBoard);

	FreeBoard getFreeBoard(int id);

	void deleteFreeBoard(int id);

	void putFreeBoard(FreeBoard freeBoard);

	List<RoutineBoard> search(SearchCondition searchCondition);
}
