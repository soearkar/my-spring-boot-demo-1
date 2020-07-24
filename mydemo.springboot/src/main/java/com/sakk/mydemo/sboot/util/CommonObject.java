package com.sakk.mydemo.sboot.util;

import java.io.Serializable;

public class CommonObject implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;
	private String description;

	public CommonObject() {
		super();
	}

	public CommonObject(int code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
