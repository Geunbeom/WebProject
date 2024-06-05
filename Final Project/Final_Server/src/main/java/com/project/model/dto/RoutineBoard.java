package com.project.model.dto;

public class RoutineBoard {
	private int id;
	private int routineId;
	private String title;
	private String writer;
	private String content;
	private int viewCnt;
	private String regDate;
	private int like;
	
	public RoutineBoard(int routineId, String title, String writer, String content) {
		this.routineId = routineId;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public int getLike() {
		return like;
	}
	
	public void setLike(int like) {
		this.like = like;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoutineId() {
		return routineId;
	}

	public void setRoutineId(int routineId) {
		this.routineId = routineId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "RoutineBoard [id=" + id + ", routineId=" + routineId + ", title=" + title + ", writer=" + writer
				+ ", content=" + content + ", viewCnt=" + viewCnt + ", regDate=" + regDate + "]";
	}
	
	
}
