package com.project.model.service;

import java.util.List;

import com.project.model.dto.MyRoutine;
import com.project.model.dto.ResultAttend;
import com.project.model.dto.Routine;

public interface MyRoutineService {

	List<ResultAttend> getAttendList(String userId);

	void doAttend(MyRoutine attend);

	ResultAttend getAttend(String userId, String regDate);

	List<ResultAttend> getMyRoutineList(String userId);

	void insertMyRoutine(MyRoutine myRoutine);

	Routine getMyRoutine(String userId, int routineId);

	void deleteMyRoutine(String userId, int routineId);

	boolean findMyRoutine(MyRoutine myRoutine);

}
