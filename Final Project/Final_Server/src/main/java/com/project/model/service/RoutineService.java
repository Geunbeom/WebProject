package com.project.model.service;

import java.util.List;

import com.project.model.dto.Routine;

public interface RoutineService {

	List<Routine> getRoutineList();

	Routine getRoutine(int id);

	void createRoutine(Routine routine);


}
