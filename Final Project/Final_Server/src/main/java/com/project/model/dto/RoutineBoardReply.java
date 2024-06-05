package com.project.model.dto;

public class RoutineBoardReply {
	private int replyId;
	private int boardId;
	private String writer;
	private String content;
	private String regDate;
	
	
	public RoutineBoardReply(String writer, String content) {
		this.writer = writer;
		this.content = content;
	}


	public int getReplyId() {
		return replyId;
	}


	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}


	public int getBoardId() {
		return boardId;
	}


	public void setBoardId(int boardId) {
		this.boardId = boardId;
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


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return "FreeBoardReply [replyId=" + replyId + ", boardId=" + boardId + ", writer=" + writer + ", content="
				+ content + ", regDate=" + regDate + "]";
	}
	
	
}
