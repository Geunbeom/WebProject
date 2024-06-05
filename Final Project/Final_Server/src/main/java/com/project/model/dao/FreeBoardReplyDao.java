package com.project.model.dao;

import java.util.List;

import com.project.model.dto.FreeBoardReply;

public interface FreeBoardReplyDao {

	List getFreeBoardReplyList(int id);

	void createFreeBoardReply(FreeBoardReply freeBoardReply);

	FreeBoardReply getFreeBoardReply(int id);

	void deleteFreeBoardReply(int rid);

	void putFreeBoardReply(FreeBoardReply freeBoardReply);

}
