package com.project.model.service;

import java.util.List;

import com.project.model.dto.FreeBoardReply;

public interface FreeBoardReplyService {

	List getFreeBoardReplyList(int id);

	void createFreeBoardReply(FreeBoardReply freeBoardReply);

	FreeBoardReply getFreeBoardReply(int rid);

	void deleteFreeBoardReply(int rid);

	void putFreeBoardReply(FreeBoardReply freeBoardReply);

}
