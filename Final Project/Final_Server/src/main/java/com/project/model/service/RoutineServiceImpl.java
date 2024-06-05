package com.project.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.dao.RoutineDao;
import com.project.model.dto.Routine;

@Service
public class RoutineServiceImpl implements RoutineService{
	
	private final RoutineDao dao;
	
	@Autowired
	public RoutineServiceImpl(RoutineDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Routine> getRoutineList() {
		return dao.getRoutineList();
	}

	@Override
	public Routine getRoutine(int id) {
		return dao.getRoutine(id);
	}

	@Override
	public void createRoutine(Routine routine) {
		dao.createRoutine(routine);
	}


}
