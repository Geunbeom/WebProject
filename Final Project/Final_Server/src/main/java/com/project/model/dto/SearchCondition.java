package com.project.model.dto;

public class SearchCondition {
	
	private String key = "none";
	private String word;

	private String orderBy = "id";
	private String orderDir = "desc";
	
	
	public SearchCondition() {
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getWord() {
		return word;
	}


	public void setWord(String word) {
		this.word = word;
	}


	public String getOrderBy() {
		return orderBy;
	}


	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}


	public String getOrderDir() {
		return orderDir;
	}


	public void setOrderDir(String orderDir) {
		this.orderDir = orderDir;
	}


	@Override
	public String toString() {
		return "SearchCondition [key=" + key + ", word=" + word + ", orderBy=" + orderBy + ", orderDir=" + orderDir
				+ "]";
	}
	
}
