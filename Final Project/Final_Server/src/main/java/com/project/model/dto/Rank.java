package com.project.model.dto;

public class Rank {
	private String nickName;
	int rate;
	int exp;
	
	public Rank(String nickName, int rate, int exp) {
		this.nickName = nickName;
		this.rate = rate;
		this.exp = exp;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	@Override
	public String toString() {
		return "Rank [nickName=" + nickName + ", rate=" + rate + ", exp=" + exp + "]";
	}
	
}
