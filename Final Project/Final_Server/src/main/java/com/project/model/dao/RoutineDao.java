package com.project.model.dao;

import java.util.List;

import com.project.model.dto.Routine;

public interface RoutineDao {

	List<Routine> getRoutineList();

	Routine getRoutine(int id);

	void createRoutine(Routine routine);


}
