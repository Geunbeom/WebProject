package com.ssafy.project.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.project.model.dao.VideoDao;
import com.ssafy.project.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {
	
	private final VideoDao vDao;
	
	@Autowired
	private VideoServiceImpl(VideoDao vDao) {
		this.vDao = vDao;
	}
	
	@Override
	public Video getVideo(int id) {
		vDao.updateViewCnt(id);
		return vDao.selectOne(id);
	}

	@Override
	public List<Video> getList() {
		return vDao.selectAll();
	}

}
