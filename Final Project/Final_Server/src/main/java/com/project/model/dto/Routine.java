package com.project.model.dto;

public class Routine {
	private int id;
	private String part;
	private String detail;
	private int sets;
	private int count;
	
	public Routine(int id, String part, String detail, int sets, int count) {
		this.id = id;
		this.part = part;
		this.detail = detail;
		this.sets = sets;
		this.count = count;
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

	@Override
	public String toString() {
		return "Routine [id=" + id + ", part=" + part + ", detail=" + detail + ", sets=" + sets + ", count=" + count
				+ "]";
	}
	
	
}
