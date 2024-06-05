package com.project.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.dao.RoutineBoardReplyDao;
import com.project.model.dto.RoutineBoard;
import com.project.model.dto.RoutineBoardReply;

@Service
public class RoutineBoardReplyServiceImpl implements RoutineBoardReplyService {

	private final RoutineBoardReplyDao dao;
	
	@Autowired
	public RoutineBoardReplyServiceImpl(RoutineBoardReplyDao dao) {
		this.dao = dao;
	}

	@Override
	public List getRoutineBoardReplyList(int id) {
		return dao.getRoutineBoardReplyList(id);
	}

	@Override
	public void createRoutineBoardReply(RoutineBoardReply routineBoardReply) {
		dao.createRoutineBoardReply(routineBoardReply);
	}

	@Override
	public RoutineBoardReply getRoutineBoardReply(int rid) {
		return dao.getRoutineBoardReply(rid);
	}

	@Override
	public void deleteRoutineBoardReply(int rid) {
		dao.deleteRoutineBoardReply(rid);
	}

	@Override
	public void putRoutineBoardReply(RoutineBoardReply routineBoardReply) {
		dao.putRoutineBoardReply(routineBoardReply);
	}
	

}
