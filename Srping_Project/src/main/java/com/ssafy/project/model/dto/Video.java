package com.ssafy.project.model.dto;

public class Video {
	private int id;
	private String title;
	private String part;
	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	private String url;
	private int viewCnt;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Video() {
		
	}

	public Video(int id, String title, String part, String url) {
		this.id = id;
		this.title = title;
		this.part = part;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", viewCnt=" + viewCnt + ", url=" + url + "]";
	}
	
}
