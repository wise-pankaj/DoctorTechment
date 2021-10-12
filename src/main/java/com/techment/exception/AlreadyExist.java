package com.techment.exception;

public class AlreadyExist extends RuntimeException{

	/**
	 * 
	 */
	String msg;
	private static final long serialVersionUID = 1L;
	public AlreadyExist(String msg) {
		super();
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	

}
