package com.project.model.dto;

public class MyRoutine {
	private String userId;
	private int	routineId;
	private String regDate;
	private int attend;
	
	public MyRoutine(String userId, int routineId, String regDate, int attend) {
		this.userId = userId;
		this.routineId = routineId;
		this.regDate = regDate;
		this.attend = attend;
	}

	
	public int getAttend() {
		return attend;
	}

	public void setAttend(int attend) {
		this.attend = attend;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRoutineId() {
		return routineId;
	}

	public void setRoutineId(int routineId) {
		this.routineId = routineId;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Attend [userId=" + userId + ", routineId=" + routineId + ", regDate=" + regDate + "]";
	}
	
}
