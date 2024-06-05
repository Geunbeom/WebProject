package com.project.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.model.dto.MyRoutine;
import com.project.model.dto.ResultAttend;
import com.project.model.dto.Routine;

public interface MyRoutineDao {

	List<ResultAttend> getAttendList(@Param("userId") String userId);

	void doAttend(MyRoutine attend);

	ResultAttend getAttend(@Param("userId")String userId, @Param("regDate")String regDate);

	
	
	List<ResultAttend> getMyRoutineList(@Param("userId") String userId);

	void insertMyRoutine(MyRoutine myRoutine);

	Routine getMyRoutine(@Param("userId")String userId, @Param("routineId")int routineId);

	void deleteMyRoutine(@Param("userId")String userId, @Param("routineId")int routineId);

}
