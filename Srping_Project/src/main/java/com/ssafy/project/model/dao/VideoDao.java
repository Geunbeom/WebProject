package com.ssafy.project.model.dao;

import java.util.List;

import com.ssafy.project.model.dto.Video;

public interface VideoDao {
	
	public abstract Video selectOne(int id);
	
	public abstract void updateViewCnt(int id);
	
	public abstract List<Video> selectAll();
	
}
