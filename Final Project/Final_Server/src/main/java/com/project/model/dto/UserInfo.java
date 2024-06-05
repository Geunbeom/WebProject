package com.project.model.dto;

public class UserInfo {
	private String id;
	private int mileage;
	private int exp;
	private int rate;
	private int highscore;
	
	public UserInfo() {
		
	}
	
	public UserInfo(String id, int mileage, int exp, int rate, int highscore) {
		this.id = id;
		this.mileage = mileage;
		this.exp = exp;
		this.rate = rate;
		this.highscore = highscore;
	}
	
	
	public int getExp() {
		return exp;
	}


	public void setExp(int exp) {
		this.exp = exp;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}


	public int getHighscore() {
		return highscore;
	}


	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}


	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", mileage=" + mileage + ", exp=" + exp + ", rate=" + rate + ", highscore="
				+ highscore + "]";
	}
	
}
