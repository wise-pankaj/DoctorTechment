package com.techment.exception;

public class PatientNotFound  extends RuntimeException {
	
	String msg;

	public PatientNotFound(String msg) {
		super(msg);
		this.msg = msg;
	}

	public PatientNotFound() {
		super();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
