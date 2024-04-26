package com.ssafy.project.model.service;

import java.util.List;

import com.ssafy.project.model.dto.Video;

public interface VideoService {
	
	public abstract Video getVideo(int id);
	
	public abstract List<Video> getList();
	
}
