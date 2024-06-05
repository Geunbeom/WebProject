package com.project.model.dto;

public class LikeBoard {
	private int id;
	private String userId;
	private int boardId;
	
	public LikeBoard(int id, String userId, int boardId) {
		this.id = id;
		this.userId = userId;
		this.boardId = boardId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	@Override
	public String toString() {
		return "LikeBoard [id=" + id + ", userId=" + userId + ", boardId=" + boardId + "]";
	}
	
}
