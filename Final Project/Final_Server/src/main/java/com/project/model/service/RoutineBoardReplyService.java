package com.project.model.service;

import java.util.List;

import com.project.model.dto.RoutineBoardReply;

public interface RoutineBoardReplyService {

	List getRoutineBoardReplyList(int id);

	void createRoutineBoardReply(RoutineBoardReply routineBoardReply);

	RoutineBoardReply getRoutineBoardReply(int rid);

	void deleteRoutineBoardReply(int rid);

	void putRoutineBoardReply(RoutineBoardReply routineBoardReply);

}
