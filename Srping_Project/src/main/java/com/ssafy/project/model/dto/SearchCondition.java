package com.ssafy.project.model.dto;

public class SearchCondition {
	private int videoId;
	private String key = "none";
	private String value = "";
	private String order = "none";
	private String orderBy = "ASC";
	
	public SearchCondition(String key, String value, String order) {
		this.key = key;
		this.value = value;
		this.order = order;
	}
	public SearchCondition(String key, String value) {
		this.key = key;
		this.value = value;
	}
	public SearchCondition(String key) {
		this.key = key;
	}
	public SearchCondition(String key, String value, String order, String orderBy) {
		this.key = key;
		this.value = value;
		this.order = order;
		this.orderBy = orderBy;
	}
	public SearchCondition() {}
	
	public int getVideoId() {
		return videoId;
	}
	
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	@Override
	public String toString() {
		return "SearchCondition [key=" + key + ", value=" + value + ", order=" + order + ", orderBy=" + orderBy + "]";
	}
	
}
