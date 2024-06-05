package com.project.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.dao.MyRoutineDao;
import com.project.model.dto.MyRoutine;
import com.project.model.dto.ResultAttend;
import com.project.model.dto.Routine;

@Service
public class MyRoutineServiceImpl implements MyRoutineService{
	
	private final MyRoutineDao dao;
	
	@Autowired
	public MyRoutineServiceImpl(MyRoutineDao dao) {
		this.dao = dao;
	}

	@Override
	public List<ResultAttend> getAttendList(String userId) {
		return dao.getAttendList(userId);
	}

	@Override
	public void doAttend(MyRoutine attend) {
		dao.doAttend(attend);
	}

	@Override
	public ResultAttend getAttend(String userId, String regDate) {
		return dao.getAttend(userId, regDate);
	}

	@Override
	public List<ResultAttend> getMyRoutineList(String userId) {
		return dao.getMyRoutineList(userId);
	}

	@Override
	public void insertMyRoutine(MyRoutine myRoutine) {
		dao.insertMyRoutine(myRoutine);
	}

	@Override
	public Routine getMyRoutine(String userId, int routineId) {
		return dao.getMyRoutine(userId, routineId);
	}

	@Override
	public void deleteMyRoutine(String userId, int routineId) {
		dao.deleteMyRoutine(userId, routineId);
	}

	@Override
	public boolean findMyRoutine(MyRoutine myRoutine) {
		if (dao.getMyRoutine(myRoutine.getUserId(), myRoutine.getRoutineId()) == null) {
			return false;			
		}
		return true;
	}
	


}
