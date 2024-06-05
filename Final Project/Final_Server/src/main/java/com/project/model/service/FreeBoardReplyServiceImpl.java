package com.project.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.dao.FreeBoardReplyDao;
import com.project.model.dto.FreeBoardReply;

@Service
public class FreeBoardReplyServiceImpl implements FreeBoardReplyService{

	private final FreeBoardReplyDao dao;
	
	@Autowired
	public FreeBoardReplyServiceImpl(FreeBoardReplyDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List getFreeBoardReplyList(int id) {
		return dao.getFreeBoardReplyList(id);
	}

	@Override
	public void createFreeBoardReply(FreeBoardReply freeBoardReply) {
		dao.createFreeBoardReply(freeBoardReply);
	}

	@Override
	public FreeBoardReply getFreeBoardReply(int rid) {
		return dao.getFreeBoardReply(rid);
	}

	@Override
	public void deleteFreeBoardReply(int rid) {
		dao.deleteFreeBoardReply(rid);
	}

	@Override
	public void putFreeBoardReply(FreeBoardReply freeBoardReply) {
		dao.putFreeBoardReply(freeBoardReply);
	}

}
