package com.project.model.dto;

public class ResultAttend {
	private int id;
	private String part;
	private String detail;
	private int sets;
	private int count;
	private String regDate;
	
	public ResultAttend(int id, String part, String detail, int sets, int count, String regDate) {
		this.id = id;
		this.part = part;
		this.detail = detail;
		this.sets = sets;
		this.count = count;
		this.regDate = regDate;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "ResultAttend [part=" + part + ", detail=" + detail + ", sets=" + sets + ", count=" + count
				+ ", regDate=" + regDate + "]";
	}
	
}
