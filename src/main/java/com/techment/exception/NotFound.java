package com.techment.exception;

public class NotFound  extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;

	public NotFound(String msg) {
		super(msg);
		this.msg = msg;
	}

	public NotFound() {
		super();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
